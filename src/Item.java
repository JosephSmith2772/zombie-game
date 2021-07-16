
public class Item {

	int amount;
	int modifyer;

	public Item(int amount, int modifyer) {
		this.amount = amount;
		this.modifyer = modifyer;

	}

	public int getAmount() {
		return amount;
	}

	public int getModifyer() {
		return modifyer;
	}

	public void add(int amount) {
		this.amount = amount + amount;
		
	}
	
	public void subtract(int amt)
	{
		amount = amount - amt;
	}

}
