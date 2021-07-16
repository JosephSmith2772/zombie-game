import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * This class keeps track of all of our player information Player stats and
 * player related methods. This class also extends the magic class so that we
 * can use those methods as well.
 * 
 * @author Joe
 *
 */
public class Player extends Magic {
	int playerMaxHp;
	int playerMaxMana;
	int playerHp;
	int playerDefence;
	int playerAttack;
	int playerMagicDefense;
	int playerXp;
	int playerLevel = 1;
	int playerMana;

	HashMap<String, Item> inventory = new HashMap<>();

	/**
	 * This is our constructor for our player object Holds all of the player
	 * variables.0
	 * 
	 * @param playerHp
	 * @param playerAttack
	 * @param playerDefence
	 * @param playerMagicDefense
	 */
	public Player(int playerHp, int playerAttack, int playerDefence, int playerMagicDefense, int playerXp,
			int playerMana, int playerMaxMana, int playerMaxHp) {

		this.playerHp = playerHp;
		this.playerDefence = playerDefence;
		this.playerAttack = playerAttack;
		this.playerMagicDefense = playerMagicDefense;
		this.playerXp = playerXp;
		this.playerMana = playerMana;
		this.playerMaxMana = playerMaxMana;
		this.playerMaxHp = playerMaxHp;

	}

	/**
	 * This is our attack method for our player it passes in zombie defense and
	 * subtracts it from player attack to decide damage, it then returns the damage
	 * 
	 * @param zombieDefence
	 * @return
	 */

	Scanner input = new Scanner(System.in);

	public int attack(int zombieDefence) {
		Random rand = new Random();
		int value = rand.nextInt(10);
		if (value == 1 || value == 0) {

			System.out.println("You miss your target");
			int damage = 0;
			if (damage <= 0)
				damage = 0;
			return damage;

		}
		int damage = playerAttack - zombieDefence;
		if (damage <= 0)
			damage = 0;
		return damage;

	}

	/**
	 * This is the subtract health method, it was easier to break the attack method
	 * into two so that i can keep using the same attack method for everything
	 * Passes in damage and just sutracts that from player hp
	 * 
	 * @param damage
	 */
	public void subtractHp(int damage) {
		playerHp = playerHp - damage;
	}

	/**
	 * This is our method for checking if the players health has dropped below zero
	 * and if they are still alive or not.
	 * 
	 * @return
	 */
	public boolean isAlive() {
		boolean isAlive = true;
		if (playerHp <= 0) {
			isAlive = false;
		}
		return isAlive;

	}

	/**
	 * This is the level up method, fairly simple, checks to see if the playerxp is
	 * above the threshold and if it is increases stats.
	 */
	public void levelUp() {
		int mpIncrease = 0;
		int hpIncrease = 0;
		int xpThreshold = 0;
		int attackIncrease = 0;
		int defenceIncrease = 0;
		switch (playerLevel) {
			case 1:
				xpThreshold = 30;
				hpIncrease = 10;
				mpIncrease = 15; // These vairables are in each switch case so that we can change the value of //
									// stats that you
									// gain when leveling up, this changes the increase based on player level. Also
									// changes the amount of xp needed to level up each level.
				attackIncrease = 1;
				defenceIncrease = 1;
				break;
			case 2:
				xpThreshold = 65;
				hpIncrease = 25;
				mpIncrease = 25;
				attackIncrease = 3;
				defenceIncrease = 3;

				break;
			case 3:
				xpThreshold = 150;
				hpIncrease = 40;
				mpIncrease = 50;
				attackIncrease = 7;
				defenceIncrease = 7;
				break;
			case 4:
				xpThreshold = 300;
				hpIncrease = 50;
				mpIncrease = 65;
				attackIncrease = 10;
				defenceIncrease = 10;
				break;
			case 5:
				xpThreshold = 750;
				hpIncrease = 100;
				mpIncrease = 100;
				attackIncrease = 25;
				defenceIncrease = 25;
				break;

		}

		if (playerXp > xpThreshold) {
			playerLevel = playerLevel + 1;
			playerMaxHp = playerMaxHp + hpIncrease; // All of this code just increases the players stats depending on
													// the
			// players level using the above switch. Also displays
			// A congrajulatory message to the player for gaining a level.
			playerMaxMana = playerMaxMana + mpIncrease;
			playerAttack = playerAttack + attackIncrease;
			playerDefence = playerDefence + defenceIncrease;
			System.out.println("Congratulations you have are now level " + playerLevel);
			reset();

		}

	}

	/**
	 * This is the get defense method it just grabs and returns the players current
	 * defense
	 * 
	 */
	public int getDefence() {
		return playerDefence;
	}

	/**
	 * This is the get hp method returns the players current hp
	 * 
	 * 
	 */
	public int getHp() {
		return playerHp;
	}

	/**
	 * this is the get attack method, returns the current player attack
	 * 
	 *
	 */
	public int getAttack() {
		return playerAttack;
	}

	public HashMap<String, Item> getinventory() {
		return inventory;
	}

	/**
	 * This is my get method for player xp so that i can acces this variable in
	 * other classes.
	 * 
	 * @return
	 */

	public int getplayerXp() {
		return playerXp;
	}

	/**
	 * This is the get method to get the mana total from the player class.
	 * 
	 * @return
	 */
	public int getplayerMana() {
		return playerMana;
	}

	public int getplayerMaxMana() {
		return playerMaxMana;
	}

	public int getplayerMaxHp() {
		return playerMaxHp;
	}

	/**
	 * This is our reset method this resets any player values currently just hp back
	 * to the max. I use this whenever you visit an inn or run away in the game
	 */

	public void reset() {
		playerHp = playerMaxHp;
		playerMana = playerMaxMana;
	}

	public void addItem(String name, int amount) {
		Item currentStack = inventory.get(name);
		if (currentStack == null) {
			inventory.put(name, new Item(amount, 30));
			System.out.println("You found the potion we are in add item method.");

		} else {
			currentStack.add(amount);
			inventory.put(name, currentStack);
		}
		System.out.println("======= INVENTORY =====");
		for (String key : inventory.keySet()) {
			System.out.println(key + ": " + inventory.get(key).getAmount());
		}
		System.out.println("========================");
	}

	public void useItem(String name) {
Item item = inventory.get(name);
	
		System.out.println("This is the use item method");
		if (item != null) {
			switch (name) {
				case "potion":
		
					if (item.getAmount() == 0) {
						System.out.println("You are out of poitons");
					}
					playerHp = playerHp + item.getModifyer();
					System.out.println("You used a health potion you gained " + item.getModifyer() + "health");
					
					break;

				case "Mana potion":
					playerMana = playerMana + item.getModifyer();
					System.out.println("You used a mana point, you gained 30 mana");
					break;
			
			
			
				
			

		}
				item.subtract(1);
			System.out.println("You have " + item.getAmount() + " " + name + "(s) left.");
			if (item.getAmount() == 0) {
				inventory.remove("potion");
				System.out.println("You don't have any potions left");
				

			} else {
				inventory.put(name, item);
			}
			
		}
	}			
				
}
			

		
		
