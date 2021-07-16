/**
 * This is the fast zombie class Keeps track of everything specific to the fast
 * zombie type This class extends the abstract zombie class so that it has acess
 * ot all of the variables and methods of Zombie
 * 
 * @author Gues
 * 
 * 
 *
 */



public class FastZombie extends Zombie {
	/**
	 * This is the constructor for our fast zombie object Keeps track of all
	 * variables relating to the fast zombie
	 * 
	 * @param zombieHp
	 * @param fastZombieAttack
	 * @param zombieDefence
	 * @param zombieMagicDefense
	 * 
	 * 
	 */
	
 
	
	public FastZombie(int zombieHp, int fastZombieAttack, int zombieDefence, int zombieMagicDefense, int xpWorth) {
		super(zombieHp, fastZombieAttack, zombieDefence, zombieMagicDefense, xpWorth);
	}
	

	@Override
	/**
	 * This is the specific attack method for the fast zombie It passes in defence
	 * and uses that and the fast zombies attack to calculate damage which is then
	 * returned.
	 */
	public int attack(int playerDefence) {

		int damage = attack - playerDefence;
		if (damage < 0) {
			damage = 0;
		}
		// TODO Auto-generated method stub
		return damage;
	}

}
