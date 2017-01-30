public class FPTP extends SocialPreferenceFunction {
	@Override
	public void elect() {
		for(Selection c : Election.candidates) {
			for(Ballot b : Election.ballots){
				if(c.getID() == b.firstChoice()) {
					c.incrementWins();
				}
			}
		}
		Selection winner = null;
		int mostVotes =0;
		int winNumber = (int)Math.ceil(Election.ballots.size()/2.0);
		for(Selection c : Election.candidates){
			if(winNumber <= c.wins()) {
				System.out.println(c.getName() + " wins by clear majority.");
			}
			if(c.wins() > mostVotes){
				mostVotes = c.wins();
				winner = c;
			}
		}
		System.out.println(winner.getName() + " is elected under pluralitarian rules.");
		for(Selection c : Election.candidates) {
			c.resetWins(); // so we can do condorcet or other algs.
		}
	}
}
