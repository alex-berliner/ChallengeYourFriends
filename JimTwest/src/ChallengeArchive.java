import java.util.ArrayList;


public class ChallengeArchive {

	ArrayList<Challenge> challenges = new ArrayList<Challenge>();
	
	public void storeChallenge(Challenge challenge)
	{
		System.out.println("CHALLENGE ID (INSIDE ARCHIVE): " + challenge.getId());
		challenges.add(challenge.getId(), challenge);
	}
	
	public void displaySavedChallenges()
	{
		for(int i = 0; i < challenges.size(); i++)
		{
			System.out.println(challenges.get(i).challengeTweet());
		}
	}
}
