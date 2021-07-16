import java.util.Scanner;
import java.util.Stack;

/**
 * Main driver class for the program, has our main game loops
 * 
 * @author Joe
 *
 */
public class Main {
	Player player;
	Scanner input = new Scanner(System.in);

	public Main() {
		boolean isPlaying = true;

		// This creates our player and passes in the values
		player = new Player(100, 8, 5, 4, 0, 30, 30, 100);
		// This si the main game loop where we first call the intro method and then the
		// fight
		while (isPlaying) {
			introduction();
			fightIntro();

			if (player.isAlive() == false) {
				break;
			}

			System.out.println("You head to the Inn and rest, you feel like your at full strength once again!");
		}

		System.out.println("Game Over, You Died");
	}

	/**
	 * This is the intro methhod right now it just calls the reset method to reset
	 * stats before starting another fight In the future i will add all introduction
	 * type things to this method.
	 */
	public void introduction() {
		player.reset();
	}

	/**
	 * The fightIntro method here takes care of creating our zombies and putting
	 * them into a stack to fight later It Then had our code for the ablity to
	 * display current stats and run away if you so choose.
	 */
	public void fightIntro() {
		Stack<Zombie> Zombies = new Stack<Zombie>();
		Zombies.push(new BossZombie(45, 4, 3, 0, 12));
		Zombies.push(new PowerfulZombie(30, 11, 3, 0, 8));
		Zombies.push(new FastZombie(25, 6, 3, 0, 6));
		boolean runsAway = false;
		// The if runs away gives you the ablity to run, uses a boolean to check if you
		// are runnign away, and if soo it breaks out of the loops back up to the intro
		// of the main game loop.
		while (!Zombies.isEmpty() && player.isAlive()) {
			if (runsAway) {
				break;
			}
			Zombie zombie = Zombies.pop();
			System.out.println("\n\nYou have come across a " + zombie.getClass().getName()
					+ ", Here are your current stats: " + "\n\nHP: " + player.getHp() + "\nAttack: "
					+ player.getAttack() + "\nDefence: " + player.getDefence() + "\nMana " + player.getplayerMana()
					+ "\nExperiance " + player.getplayerXp() + "\n\nDo you want to fight it? \n0: yes\n1: no");
			// This switch here give you the chance to run away, if you choose yes, it will
			// call the Fight Zombie method, and if no it will set runs away to true.
			switch (input.nextInt()) {
				case 0:
					fightZombie(zombie);
					break;
				case 1:
					// Since we are not fighting the zombie, put it back on the stack
					Zombies.push(zombie);
					System.out.println("You run away!");
					player.levelUp();
					runsAway = true;
					break;
			}
			// Checks to see if the stack is empty to see whether you have defeated all of
			// the Zombies
		}
		if (Zombies.isEmpty()) {
			System.out.println("You defeated the wave of zombies!");
		}
		// Checks to see if the player Is still alive before continuing to loop.
		if (!player.isAlive()) {
			return;
		}
		//
	}

	/**
	 * This is our actual fight method for our fight against the Zombiew Passes in
	 * the curreent Zombie on the stack It first checks to make sure both the player
	 * and the Zombie are still alive before going into the Loop It then uses the
	 * attack and subtractDamage methods to play out the fight until either the
	 * Zombie or player is dead.
	 */
	public void fightZombie(Zombie zombie) {
		while (zombie.isAlive() && player.isAlive()) {

			System.out.println("Please enter 1 for attack, 2 to bring up the spells menu, or 3 to use a item");
			// Following switch statemant allows the user to choose what they want to do
			// Attack or cast fireball.
			switch (input.nextInt()) {
				case 1:
					int playerDamage = player.attack(zombie.getDefence());
					zombie.subtractDamage(playerDamage);

					System.out.println(
							"You did " + playerDamage + " damage to the " + zombie.getClass().getName() + " zombie!");
					if (!zombie.isAlive()) {
						System.out.println("You defeated that zombie!");
						player.playerXp = player.getplayerXp() + zombie.xpWorth;
						player.levelUp();
						System.out.println("You found a potion!");
						player.addItem("potion", 1);
						player.addItem("mana potion", 1);
						break;
					}
					int zombieDamage = zombie.attack(player.getDefence());
					player.subtractHp(zombieDamage);
					System.out.println("The zombie did " + zombieDamage + " damage to you! You only have "
							+ player.getHp() + " hp left!");
					break;
				case 2:
					System.out.println("Please enter 1 for fireball, or 2 for Cure");
					switch (input.nextInt()) {
						case 1:
							if (player.getplayerMana() < player.getfireballCost()) {
								System.out.println("You don't have enough mana to cast that.");
								break;
							}
							player.playerMana = player.calculateFireballMana(player.getplayerMana());
							int playerDamage1 = player.fireball(zombie.getzombieMagicDefense());
							zombie.subtractDamage(playerDamage1);
							System.out.println(
									"You did " + playerDamage1 + " damage to the " + zombie.getClass().getName()
											+ zombie.getClass().getName() + " Has " + zombie.getHp() + " hp left");

							if (!zombie.isAlive()) {
								System.out.println("You defeated that zombie!");
								player.playerXp = player.getplayerXp() + zombie.xpWorth;
								System.out.println("You gained " + player.getplayerXp() + "experiance");
								player.levelUp();
								System.out.println("You found a potion!");
								player.addItem("potion", 1);
								player.addItem("mana potion", 1);
							}
							int zombieDamage1 = zombie.attack(player.getDefence());
							player.subtractHp(zombieDamage1);
							System.out.println("The zombie did " + zombieDamage1 + " damage to you! You have "
									+ player.getHp() + " hp left!");
							break;

						case 2:
							if (player.getplayerMana() < player.getCureCost()) {
								System.out.println("You don't have enought mana to cast that");
								break;

							}
							player.playerHp = (player.cure(player.playerHp));
							player.playerMana = (player.calculateCureMana(player.playerMana));
							System.out.println("You healed yourself for " + player.getCure() + " Health "
									+ "\nYou now have " + player.getHp() + " hp remaining");

							int zombieDamage2 = zombie.attack(player.getDefence());
							player.subtractHp(zombieDamage2);
							System.out.println("The zombie did " + zombieDamage2 + " damage to you! You have "
									+ player.getHp() + " hp left!");
							break;

					}
					break;
				case 3:
					System.out.println("Enter 1 to use a potion, or 2 to use a mana potion");
					switch (input.nextInt()) {

						case 1:
						  
							player.useItem("potion");
							int zombieDamage1 = zombie.attack(player.getDefence());
							player.subtractHp(zombieDamage1);
							System.out.println("The zombie did " + zombieDamage1 + " damage to you! You have "
									+ player.getHp() + " hp left!");
							break;
						case 2:
							player.useItem("mana potion");
							player.useItem("potion");
							int zombieDamage2 = zombie.attack(player.getDefence());
							player.subtractHp(zombieDamage2);
							System.out.println("The zombie did " + zombieDamage2 + " damage to you! You have "
									+ player.getHp() + " hp left!");
							break;
					}

			}

		}
	}

	/**
	 * This is just for organizations looks better to run everything above in one
	 * main method down here
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}

}
