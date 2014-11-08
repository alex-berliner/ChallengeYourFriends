import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;


import java.awt.Desktop;
import java.io.*;
import java.net.URI;





public class LogIn {
	
	public void logIn(Twitter twitter) throws TwitterException, IOException {
		

			
			try {
				System.out.println("-----");
				 
	            // get request token.
	            // this will throw IllegalStateException if access token is already available
	            // this is oob, desktop client version
	            RequestToken requestToken = twitter.getOAuthRequestToken(); 
	
	            System.out.println("Got request token.");
	            System.out.println("Request token: " + requestToken.getToken());
	            System.out.println("Request token secret: " + requestToken.getTokenSecret());
	
	            System.out.println("|-----");
	
	            AccessToken accessToken = null;
	
	            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	             
	            while (null == accessToken) {
	                System.out.println("Open the following URL and grant access to your account:");
	//            	We're going to try to launch the browser for the user .... if we can
	                System.out.println("Launching browser..."); 
	                try { 
	                	Desktop desktop = Desktop.getDesktop(); 
	                	desktop.browse(new URI(requestToken.getAuthorizationURL())); 
	                	} catch (Exception e) { 
	                		System.out.println("Problem in launching browser. Copy and paste the following URL into a browser:"); 
	                		System.out.println(requestToken.getAuthorizationURL()); 
	                	}
	                //System.out.println(requestToken.getAuthorizationURL());
	                System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
	                String pin = br.readLine();
	            
	                try {
	                    if (pin.length() > 0) {
	                        accessToken = twitter.getOAuthAccessToken(requestToken, pin);
	                    } else {
	                        accessToken = twitter.getOAuthAccessToken(requestToken);
	                    }
	                } catch (TwitterException te) {
	                    if (401 == te.getStatusCode()) {
	                        System.out.println("Unable to get the access token.");
	                    } else {
	                        te.printStackTrace();
	                    }
	                }
	            }
	            System.out.println("Got access token.");
	            System.out.println("Access token: " + accessToken.getToken());
	            System.out.println("Access token secret: " + accessToken.getTokenSecret());
	            
	          //persist to the accessToken for future reference.
	            storeAccessToken(twitter.verifyCredentials().getId() , accessToken);
	            
			} catch (IllegalStateException ie) {
	            // access token is already available, or consumer key/secret is not set.
	            if (!twitter.getAuthorization().isEnabled()) {
	                System.out.println("OAuth consumer key/secret is not set.");
	                System.exit(-1);
	            }
	        }
		
	}

private static void storeAccessToken(long useId, AccessToken accessToken){
    //store accessToken.getToken()
    //store accessToken.getTokenSecret()
	
	//System.out.println("USEID: "+useId+" ACCESSTOKEN: " + accessToken.getToken());
  }
	
}
