
public class InstantRunoff extends SocialPreferenceFunction
{
	public static int count(Selection s)
	{
		int votes = 0;
		for(Ballot b : Election.ballots)
			if(s.matches(b.firstChoice())) {
				votes++;
			}
		return votes;
	}
	public static int findLeast()
	{
		int least = Integer.MAX_VALUE;
		int leastID = 0;
		for(Selection s : Election.candidates)
			if (count(s) < least)
			{
				leastID = s.getID();
				least = count(s);
			}
		return leastID;
	}

	private static void strikeName(Selection s)
	{
		Election.candidates.remove(s);
		for(Ballot b : Election.ballots)
			if(b.firstChoice() == s.getID()) {
				b.kill();
			}
		removeExhaustedBallots();
	}
	private static void removeExhaustedBallots()
	{
		for(Ballot b : Election.ballots)
			if (b.getBallot().size() == 0) {
				Election.ballots.remove(b);
			}
	}
	public static double percentage(Selection g)
	{
		return ((double)Math.round((count(g))/((double)Election.ballots.size())*10000))/100;
	}

	@Override
	public void elect()
	{
		int round = 0;
		while(Election.candidates.size() > 1)
		{
			round++;
			System.out.println("ROUND " + round + " RESULTS:");
			for(Selection q : Election.candidates)
			{
				System.out.printf("%25s %30s %25s", "Candidate " + q.getName(), "with " + percentage(q)+"% of votes this round", "and " + count(q) + " total votes.");
				System.out.println();
			}
			strikeName(lookup(findLeast()));
		}
	}
}
