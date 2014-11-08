import java.util.ArrayList;


public class Challenge {
	
	public String challengeName;
	public String link;
	public ArrayList<String> rules;
	public int numOfDays;
	
	private static int id = -1; // Needs to be synced with database
	
	
	public Challenge(String challengeName, int numOfDays, ArrayList<String> rules)
	{
		this.challengeName = challengeName;
		this.numOfDays = numOfDays;
		this.rules = rules;
		id = id + 1;
	}
	
	public Challenge(String challengeName, int numOfDays, ArrayList<String> rules, String link)
	{
		this.challengeName = challengeName;
		this.numOfDays = numOfDays;
		this.rules = rules;
		this.link = link;
		id = id + 1;
	}

	public String challengeTweet()
	{
		String tweet;
		if(link != null)
			tweet = " has " + numOfDays + " days to complete the #" + challengeName + "Challenge. " + link + " #CYF";
		else
			tweet = " has " + numOfDays + " days to complete the #" + challengeName + "Challenge. #CYF";
		return tweet;
	}
	
	public int getId()
	{
		return id;
	}
	
	
	public ArrayList<String> getRules()
	{
		return rules;
	}
	
	public String getName()
	{
		return challengeName;
	}
	
}
