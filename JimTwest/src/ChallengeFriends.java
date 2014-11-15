import java.util.ArrayList;
import java.util.Scanner;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class ChallengeFriends {
	
	public void menu(Scanner in, Twitter twitter, Challenge challenge) throws TwitterException
	{
		ArrayList<String> friends;

		
		friends = nameFriends(in);
		sendChallenge(in, twitter, friends, challenge);
	}
	
	private ArrayList<String> nameFriends(Scanner in)
	{
		//Scanner in = new Scanner(System.in);
		
		System.out.println("How many friends would you like to challenge (1-10)?");
		int numOfFriends = in.nextInt();
		in.nextLine();
		System.out.println("Number of friends to challenge: " + numOfFriends);
		System.out.println();
		
		ArrayList<String> friends = new ArrayList<String>();
		
		
		for(int i = 0; i < numOfFriends; i++)
		{
			System.out.println("What is the name of friend #" + (i+1) + " that you would like to challenge?");
			String friendName = in.nextLine();
			System.out.println("Friend name: @" + friendName);
			System.out.println();
			
			friends.add(friendName);
		}
		
		//in.close();
		
		return friends;
	}
	
	private void sendChallenge(Scanner in, Twitter twitter, ArrayList<String> friends, Challenge challenge) throws TwitterException
	{
		//Scanner in = new Scanner(System.in);
		Status status;
		
		System.out.println("Send challenge (true/false)?");
		boolean sendChallenge = in.nextBoolean();
		in.nextLine();
		if(!sendChallenge)
		{
			in.close();
			return;
		}
			
		for(int i = 0; i < friends.size(); i++)
		{
			status = twitter.updateStatus("@" + friends.get(i) + challenge.challengeTweet());
								
			System.out.println("Successfully updated the status to [" + status.getText() + "].");
		}
		//in.close();
	}
}
