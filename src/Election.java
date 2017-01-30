import java.util.ArrayList;
import java.util.Collections;


public class Election
{
	public static ArrayList<Ballot> ballots = new ArrayList<Ballot>();
	public static ArrayList<Selection> candidates = new ArrayList<Selection>();

	public static void main(String[] args)
	{
		//TESTER CODE BLOCK
		candidates.add(new Selection(1, "Martin")); //Winner
		candidates.add(new Selection(2, "Riley")); //Spoiler
		candidates.add(new Selection(3, "Mark"));  //Opposition



		ballots.add(new Ballot(1,2,3));
		ballots.add(new Ballot(1,2,3));
		ballots.add(new Ballot(1,2,3)); //3 for 1, 2 is second choice.
		ballots.add(new Ballot(2,1,3));
		ballots.add(new Ballot(2,1,3));
		ballots.add(new Ballot(3,1,2));
		ballots.add(new Ballot(3,1,2));
		ballots.add(new Ballot(3,2,1));
		ballots.add(new Ballot(3,2,1));
		Collections.shuffle(candidates);
		new Condorcet().elect();
		new InstantRunoff().elect();
		new FPTP().elect();
		candidates.clear();
		ballots.clear();

		//Example from https://en.wikipedia.org/wiki/Condorcet_method#Finding_the_winner
		candidates.add(new Selection(1, "Memphis")); //Winner
		candidates.add(new Selection(2, "Nashville")); //Spoiler
		candidates.add(new Selection(3,  "Chattanooga"));  //Opposition
		candidates.add(new Selection(4, "Knoxville"));  //Opposition

		for(int i=0; i<42; i++){ //near Memphis, 42%
			ballots.add(new Ballot(1,2,3,4));
		}
		for(int i=0; i<26; i++){ //near Nashville, 26%
			ballots.add(new Ballot(2,3,4,1));
		}
		for(int i=0; i<15; i++){ //near Chat, 15%
			ballots.add(new Ballot(3,4,2,1));
		}
		for(int i=0; i<17; i++){ //near Knoxville, 17%
			ballots.add(new Ballot(4,3,2,1));
		}

		new Condorcet().elect();
		new InstantRunoff().elect();
		new FPTP().elect();
	}

}
