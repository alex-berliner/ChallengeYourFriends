import java.util.ArrayList;
import java.util.Scanner;

import twitter4j.Twitter;
import twitter4j.TwitterException;


public class CreateChallenge {
	
	
	public Challenge menu(Scanner in, Twitter twitter) throws TwitterException
	{
		String challengeName;
		ArrayList<String> rules;
		int numOfDays;
		String linkName;
		Challenge challenge;
		
		
		challengeName = nameChallenge(in);
		rules = createRules(in);
		numOfDays = createTimeframe(in);
		linkName = addLink(in);
		
		
		challenge = createChallenge(challengeName, rules, numOfDays, linkName);
		
		sendChallenge(in, twitter, challenge);

		return challenge;
	
	}
	
	private String nameChallenge(Scanner in)
	{
		//Scanner in = new Scanner(System.in);
		String modifiedChallengeName;
		
		do {
			System.out.println("What would you like to name your challenge?");
			String challengeName = in.nextLine();
			String delims = "[ ]+";
			String[] tokens = challengeName.split(delims);
		
			modifiedChallengeName = Character.toUpperCase(tokens[0].charAt(0)) + tokens[0].substring(1);
			for(int i = 1; i < tokens.length; i++)
			{
				modifiedChallengeName += Character.toUpperCase(tokens[i].charAt(0)) + tokens[i].substring(1);
			}
			System.out.println("Challenge name: " + challengeName);
			System.out.println("Modified Challenge name: " + modifiedChallengeName);
			System.out.println();
			
			if(modifiedChallengeName.length() > 20)
			{
				System.out.println("Please keep the name of your challenge to 20 characters or under");
			}
		} while (modifiedChallengeName.length() > 20);
		
		//in.close();
		
		return modifiedChallengeName;
	}
	
	private ArrayList<String> createRules(Scanner in)
	{
		//Scanner in = new Scanner(System.in);
		ArrayList<String> rules = new ArrayList<String>();
		
		System.out.println("Does your challenge have rules (0,1,2, or 3)?");
		int numOfRules = in.nextInt();
		in.nextLine();
		System.out.println("Number rules: " + numOfRules);
		System.out.println();
		
		for(int i = 0; i < numOfRules; i++)
		{
			System.out.println("What is rule #" + (i+1) + "?");
			String rule = in.nextLine();
			rules.add(rule);
		}
		
		//in.close();
		
		return rules;
	}
	
	private int createTimeframe(Scanner in)
	{
		//Scanner in = new Scanner(System.in);
	
		System.out.println("How many days to complete the challenge?");
		int numOfDays = in.nextInt();
		in.nextLine();
		System.out.println("Number of days to complete: " + numOfDays);
		System.out.println();
		
		//in.close();
		
		return numOfDays;
	}
	
	private String addLink(Scanner in)
	{
		//Scanner in = new Scanner(System.in);
		String linkName;
		
		System.out.println("Do you have a link to your challenge (true/false)?");
		boolean hasLink = in.nextBoolean();
		in.nextLine();
		if(hasLink)
		{
			System.out.println("Paste your link here: ");
			linkName = in.nextLine();
			System.out.println("Link: " + linkName);
			System.out.println();
		}
		else
		{
			linkName = null;
		}
		
		//in.close();
		
		return linkName;
	}
	
	private Challenge createChallenge(String name, ArrayList<String> rules, int timeframe, String link)
	{
		return new Challenge(name, timeframe, rules, link);
	}
	
	private void sendChallenge(Scanner in, Twitter twitter, Challenge challenge) throws TwitterException
	{
		//Scanner in = new Scanner(System.in);
		
		System.out.println("Send challenge now (true/false)?");
		boolean sendChallenge = in.nextBoolean();
		in.nextLine();
		if(sendChallenge) {
			ChallengeFriends cf = new ChallengeFriends();
			cf.menu(in, twitter, challenge);
		}
		
		//in.close();
	}
}
