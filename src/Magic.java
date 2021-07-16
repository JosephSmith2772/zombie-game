/**
 * This is the magic class, it will keep track of all magic related variables
 * for the game as well as any spell methods. I think this is more organized
 * than keeping all of these spells in the player class. This class is extended
 * by the player class.
 * 
 * @author Joe
 *
 */
public class Magic {

	int fireball = 9;
	int fireballCost = 5;
	int cure = 20;
	int cureCost = 8;

	/**
	 * This is the fireball method passes in the magic defense of the zomie and
	 * minuses that from the value for fireball and returns that as damage.
	 * 
	 * 
	 */
	public int fireball(int zombieMagicDefense) {
		
		int damage = (int) (fireball - zombieMagicDefense);
		return damage;
		

	}
	public int calculateFireballMana(int playerMana) {
		playerMana = playerMana - fireballCost;
		
		return playerMana;
	}
	
	public int cure(int playerHp) {
		
	    int heal = (playerHp + cure); 
		return  heal;
	}
	
	public int calculateCureMana(int playerMana) {
		playerMana = playerMana - cureCost;
		return playerMana;
		
	}
	
	public int Powerup( int playerAttack)
	{   
		int count = 0;
		while (count < 2)
		{
	
			playerAttack = playerAttack + 4;
			
			
		}
		count++;
		return playerAttack;
	}

	/**
	 * Basic get method for our fireball variable returns the value of fireball
	 * 
	 */
	public int getfireball() {
		return fireball;
	}
	/**
	 * This is the get method for fireball cost. Returns the mana cost for fireball
	 * @return
	 */
	
	public int getfireballCost() {
		return fireballCost;
	}
	
	public int getCure() {
		return cure;
	}
	
	public int getCureCost() {
		return cureCost;
	}

}
