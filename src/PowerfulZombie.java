/**
 * This is the powerfull zombie class, extends the abstract zombie class So that
 * we can use all of those methods and variables of zombie Has any specific
 * methods like attack are only for the powerful zombie.
 * 
 *
 *
 */
public class PowerfulZombie extends Zombie {
	/**
	 * This is the constructor for the powerfull zombie object. Holds all of the
	 * variables relating to powerful zombie
	 * 
	 * @param zombieHp
	 * @param fastZombieAttack
	 * @param zombieDefence
	 * @param zombieMagicDefense
	 */
	public PowerfulZombie(int zombieHp, int fastZombieAttack, int zombieDefence, int zombieMagicDefense, int xpWorth) {
		super(zombieHp, fastZombieAttack, zombieDefence, zombieMagicDefense, xpWorth);

		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * This is the attack method for the powerful Zombbie there is a modifier on his
	 * attack compared to the fast zombie other than that most of the attack methods
	 * are similar.
	 */
	public int attack(int playerDefence) {

		int damage = (this.attack) - playerDefence;

		if (damage < 0)
			damage = 0;
		// TODO Auto-generated method stub
		return damage;
	}

}
