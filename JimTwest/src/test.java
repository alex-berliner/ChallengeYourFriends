
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.util.*;


public class test {
	public static void main(String [] args) throws TwitterException, IOException
	{
		Scanner in = new Scanner(System.in);
		boolean createdChallenge = true;
		

		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("GQ4KveeL45kZvX4wnQXVrhRAs");
		cb.setOAuthConsumerSecret("RU67euqxYe6ZFZK5RR5lh5nukwP49Ah33qKD6CFbcTDL8XyUcO");
		
		ChallengeArchive archive = new ChallengeArchive();
		
		try {
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
		
			LogIn signIn = new LogIn();
			
			signIn.logIn(twitter);
			
			System.out.println("Create a new challenge (true/false)?");
			createdChallenge = in.nextBoolean();
			in.nextLine();
			
			while(createdChallenge) {
				
				CreateChallenge cc = new CreateChallenge();
				Challenge challenge;
				
				
				if(createdChallenge) {
					challenge = cc.menu(in, twitter);
					System.out.println("CHALLENGE ID: " + challenge.getId());
					archive.storeChallenge(challenge);
					
					
				}
					
				 
				System.out.println("Create another challenge (true/false)?");
				createdChallenge = in.nextBoolean();
				in.nextLine();
				
			}
			
			archive.displaySavedChallenges();
			

	        System.out.println("ready exit");
		} catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
		}

		
//		Twitter twitter = TwitterFactory.getSingleton();
//		String message = "This is a test";
////		List<Status> statuses = twitter.getHomeTimeline();
////		System.out.println("Showing home timeline");
////		for(Status status: statuses){
////			System.out.println(status.getUser().getName() + ":" + status.getText());
////		}
//		
//		ResponseList<Location> locations;
//		
//		locations = twitter.getAvailableTrends();
//		System.out.println("Showing available trend");
//		for(Location location : locations){
//			System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
//		}
//		
//		Trends trends = twitter.getPlaceTrends(23424977);
//		for(int i = 0; i < trends.getTrends().length; i++){
//			System.out.println(trends.getTrends()[i].getName());
//		}
		
	}
}