/**
 * This is my Monster interface, this will handle all enemy monsters in this
 * game It contains all of the generic methods that i use throughout this
 * program.
 * 
 * 
 *
 */
public interface Monsters {

	public int attack(int playerDefence);

	public void subtractDamage(int damage);

	public int getDefence();

	public int getAttack();

	public int getHp();

	public boolean isAlive();

}