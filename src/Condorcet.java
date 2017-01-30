import java.util.ArrayList;


public class Condorcet extends SocialPreferenceFunction {
	@Override
	public void elect() {
		for(Selection c : Election.candidates) {
			for(Selection d : Election.candidates) { // TODO alg left inefficient with foreach: is running each contest twice.
				if(!c.getName().equals(d.getName())) { // Can't compete against yourself!
					if(beats(c, d)) {
						System.out.println(c.getName() + " beats " + d.getName() + " by condorcet rules.");
						c.incrementWins();
					}
				}
			}
		}
		boolean hasWinner = false;
		for(Selection c : Election.candidates) {
			if(c.wins() == Election.candidates.size() - 1) { // because you have to beat all candidates but one: yourself
				System.out.println(c.getName() + " is a condorcet winner.");
				hasWinner = true;
			}
		}
		if(!hasWinner) {
			System.out.println("For this scenario there is no condorcet winner.");
		}
		for(Selection c : Election.candidates){
			c.resetWins(); //so we can do FPTP or other algs.
		}
	}

	private static boolean beats(Selection c, Selection d) {
		int tallyC = 0;
		int tallyD = 0;
		for(Ballot b : Election.ballots) {
			ArrayList<Integer> bal = b.getBallot();
			lookup(c.getID());
			for(Integer i : bal) {
				if(i == c.getID()) {
					tallyC++;
					break;
				}
				else if(i == d.getID()) {
					tallyD++;
					break;
				}
			}
		}
		if(tallyC > tallyD)
			return true;
		return false;
	}
}
