import java.util.ArrayList;
public class Ballot
{
	private final ArrayList<Integer> ballot = new ArrayList<Integer>();
	public Ballot(int... ids)
	{
		for(int i : ids)
			ballot.add(i);
	}
	public void kill()
	{
		ballot.remove(0);
	}
	public int firstChoice()
	{
		return ballot.get(0);
	}
	public ArrayList<Integer> getBallot()
	{
		return ballot;
	}
}
