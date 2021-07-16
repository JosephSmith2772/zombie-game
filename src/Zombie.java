/**
 * This is the abstract Zombie class, This handles all of the basic Stats or
 * methods that are remain the same for all of the different type of Zombies
 * that will be used in this game. It is abstract so that i can finish all of
 * the methods differently for each zombie.
 * 
 * 
 *
 */
public abstract class Zombie implements Monsters {
	// Basic variables for thee zombies stats
	public int hp = 0;
	public int attack = 0;
	public int defence = 0;
	public int zombieMagicDefense = 0;
	public int xpWorth = 0; 

	/**
	 * This is the basic constructor for all types of zombies keeps track of 
	 * the general zombie varaibles which are currently 0
	 * @param zombieHp
	 * @param fastZombieAttack
	 * @param zombieDefence
	 * @param zombieMagicDefense
	 */
	public Zombie(int zombieHp, int fastZombieAttack, int zombieDefence, int zombieMagicDefense, int xpWorth) {
		this.hp = zombieHp;
		this.attack = fastZombieAttack;
		this.defence = zombieDefence;
		this.zombieMagicDefense = zombieMagicDefense;
		this.xpWorth = xpWorth;

	}

	@Override
	/**
	 * This is the subtract damage method It just passes in damage from the attack
	 * method and subtracts that from hp. Allowing us deal damage and keep track of
	 * health
	 */
	public void subtractDamage(int damage) {
		// TODO Auto-generated method stub
		this.hp = this.hp - damage;

	}
	
	

	/**
	 * This is the get attack method, It returns the attack value
	 */

	@Override
	public int getAttack() {
		return attack;
	}

	/**
	 * This is the get defense method it returns the current value for defense
	 */
	@Override
	public int getDefence() {
		return defence;
	}

	/**
	 * This is the get hp method returns the current value for hp
	 */
	@Override
	public int getHp() {
		return hp;
	}

	/**
	 * This is the get magic defense method It will return the current zombie magic
	 * defense
	 * 
	 * 
	 */
	public int getzombieMagicDefense() {
		return zombieMagicDefense;
	}

	@Override
	/**
	 * This is a very usefull method that is used often to check if the zombie or
	 * player is still alive Uses a basic boolean to change the is alive variable
	 * eitehr to true or false depending on if you are above 0 hp or not
	 */
	public boolean isAlive() {
		// TODO Auto-generated method stub
		boolean alive = true;
		if (hp <= 0)
			alive = false;
		return alive;
	}

}