
public class Selection
{
	private final String name;
	private final int id;
	private int wins =0;
	public Selection(int ID, String n)
	{
		id=ID;
		name=n;
	}
	public boolean matches(int i)
	{
		return (this.id == i);
	}
	public int getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public void incrementWins() {
		wins++;
	}
	public int wins(){
		return wins;
	}
	public void resetWins(){
		wins=0;
	}
}
