
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package OurPackage;

/**
 *
 * @author sherif
 */
//package twitter4j.examples.search;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;
import twitter4j.Trend;
import twitter4j.Trends;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import twitter4j.PagableResponseList;




import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class TwitterClass{
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args
     */
	private Vector FromUser = new Vector();
	private Vector Tweets = new Vector();
	private Vector Date = new Vector();
	private Vector ProfImageUrl = new Vector();
        private Vector UserStatus = new Vector();
	private Vector Language = new Vector();
        private Vector DailyTrends = new Vector();
        private Vector WeeklyTrends = new Vector();
        private Vector UserFollowers = new Vector();
        private String AsOfDate = new String();
        private String Trends = "";
	public List<Tweet> tweets;
        List<Trends> DailyTrendsList;
        List<Trends> WeeklyTrendsList;
	public void SearchTweets(String SearchInput)
	{
		Twitter twitter = new TwitterFactory().getInstance();
        try {
	            QueryResult result = twitter.search(new Query(SearchInput));
	             tweets = result.getTweets();
                     
                     if(!FromUser.isEmpty())
                     {
                        FromUser.clear();
	            	Tweets.clear();
	            	Date.clear();
	            	ProfImageUrl.clear();
	            	Language.clear();
                        UserFollowers.clear();
                        UserStatus.clear();
                     }
	            for (Tweet tweet : tweets) {
                        try{
	            	FromUser.addElement(tweet.getFromUser().replaceAll("'", "^"));
	            	//Tweets.addElement(new String(tweet.getText().replaceAll("'", "^").getBytes(),"utf-8"));
                        Tweets.addElement(tweet.getText().replaceAll("'", "^"));
	            	Date.addElement(tweet.getCreatedAt());
	            	ProfImageUrl.addElement(tweet.getProfileImageUrl().replaceAll("'", "^"));
	            	Language.addElement(tweet.getIsoLanguageCode().replaceAll("'", "^"));
                        }
                        catch(Exception e){}

	            }

             } catch (TwitterException te) {
            te.printStackTrace();
            
            JOptionPane.showMessageDialog(null,"Connection Error \n Failed to search tweets","Try Again",JOptionPane.ERROR_MESSAGE);


            }
	}

        public void Trends()
        {
            Twitter twitter = new TwitterFactory().getInstance();
            try {
                    WeeklyTrendsList = twitter.getWeeklyTrends();
             
                    for (Trends trends : WeeklyTrendsList) {
                        AsOfDate =""+trends.getAsOf();
                        for (Trend trend : trends.getTrends()) {
                            //System.out.println(trend.getName());
                            WeeklyTrends.addElement(trend.getName());

                        }
                        break;
                }
                    
                 Trends = "TRENDING TOPICS  "+(WeeklyTrends.toString());
                   
            } catch (TwitterException te) {
                te.printStackTrace();
               
                JOptionPane.showMessageDialog(null,"Connection Error\n Failed to get trends","Try Again",JOptionPane.ERROR_MESSAGE);
            }
    }

        public void Followers(String Author)
        {
            try {
                Twitter twitter = new TwitterFactory().getInstance();
                long cursor = -1;
                int count = 50;
                PagableResponseList<User> users;
                do {
                    users = twitter.getFollowersStatuses(Author, cursor);
                    for (User user : users) {
                      if(count > 0)
                      {
                            if (null != user.getStatus()) {
                                                  
                                    UserFollowers.addElement(user.getScreenName().replaceAll("'", "^"));
                                    UserStatus.addElement(user.getStatus().getText().replaceAll("'", "^"));
                               
                            } else {
                                // the user is protected
                                UserFollowers.addElement(user.getScreenName());
                                UserStatus.addElement("The User is Protected");
                            }
                            count--;
                            
                            
                      }
                      else
                          break;
                       }
               
                } while ((cursor = users.getNextCursor()) != 0 && count > 0);
                
        } catch (TwitterException te) {
            te.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to show followers","Try Again",JOptionPane.ERROR_MESSAGE);
        }
    
        }


	public static void main(String args[])
	{
	
	}
	public Vector getFromUser()
	{
			return FromUser;
	}

	public Vector getTweets()
	{
			return Tweets;
	}

	public Vector getDate()
	{
			return Date;
	}

	public Vector getProfImageUrl()
	{
			return ProfImageUrl;
	}

	public Vector getLanguage()
	{
			return Language;
	}

        public String getAsOfDate()
        {
            return AsOfDate;
        }

        public Vector getWeeklyTrends()
        {
            return WeeklyTrends;
        }
        
        public Vector getUserFollowers()
        {
            return UserFollowers;
        }
        
        public Vector getUserStatus()
        {
            return UserStatus;
        }
        
        
         public String getTrends()
        {
            return Trends;
        }
}
