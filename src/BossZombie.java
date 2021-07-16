import java.util.Random;

/**
 * This is the boss Zombie class Keeps track of all methods specific to the Boss
 * zombie object Extends the zombie class to use all of those variables and
 * methods
 * 
 * 
 *
 */
public class BossZombie extends Zombie {
	/**
	 * This is my zombie constructor for our boss zombie Keeps track of all
	 * variables relating to boss zombie
	 * 
	 * @param zombieHp
	 * @param fastZombieAttack
	 * @param zombieDefence
	 * @param zombieMagicDefense
	 */
	public BossZombie(int zombieHp, int fastZombieAttack, int zombieDefence, int zombieMagicDefense, int xpWorth) {
		super(zombieHp, fastZombieAttack, zombieDefence, zombieMagicDefense, xpWorth);
		// TODO Auto-generated constructor stub
	}

	/**
	 * THis is the boss zombies attack method, it uses the math.random to change the
	 * value of the boss zombies attack every hit, THis method passes in the players
	 * defense and subtracts that from the attack value to return a damage variable
	 */
	@Override
	public int attack(int playerDefence) {
        Random rand = new Random();
        int value = rand.nextInt(3) + 2;
		int damage = (int) (this.attack * value - playerDefence);
		if (damage < 0)
			damage = 0;
		
		
		return damage;
	}

}
