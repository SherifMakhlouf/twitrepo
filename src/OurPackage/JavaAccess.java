/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package OurPackage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author sherif
 */
public class JavaAccess {

    public boolean insertInTweets(String[] str, int CatID)
    {
         try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           if(SameTweet(Integer.parseInt(str[1]),str[2]) == false)
           {
                statement.execute("INSERT INTO Tweets (Tweet,AuthorID,TweetDate,Locale,SearchKW,CatID) VALUES ('"+str[0]+"','"+Integer.parseInt(str[1])+"','"+str[2]+"','"+str[3]+"','"+str[4]+"',"+CatID+")");
                connection.close();
                return true;
           }
           else
           {
               JOptionPane.showMessageDialog(null,"This tweet is already saved","Try Again",JOptionPane.ERROR_MESSAGE);
               connection.close();
                return false;
           }
           
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       return false;
       }
    }

    public void insertInCat(String CatName)
    {
       try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           statement.execute("insert into Category (CatName) VALUES ('"+CatName+"')");
           getFromCat();
           connection.close();
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       }
    }

    public Vector getFromCat()
    {
        try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           ResultSet Result = statement.executeQuery("SELECT CatName FROM Category");
           while(Result.next())
           {
               CatResult.addElement(Result.getString(1));
           }
           connection.close();
           return CatResult;
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       return CatResult;
       }
    }


    public void deleteFromCat(String CatName)
    {
        
         try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           statement.executeUpdate("DELETE FROM Category WHERE CatName ='"+CatName+"'");
          
           connection.close();
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       }
    }

    public int getLast()
    {
         try
       {
           int LastID = 0;
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           statement.execute("SELECT last(TweetID) FROM Tweets");
           ResultSet rs =  statement.getResultSet();
           if (rs.next())
           {
                LastID = rs.getInt(1);
           }


           connection.close();
            return LastID;
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       return 0;
       }
    }

    public int getCatID(String CatName)
    {
        try
       {
           int CatID = 1;
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           statement.execute("SELECT CatID FROM Category WHERE CatName='"+CatName+"'");
           ResultSet rs =  statement.getResultSet();
           if (rs.next())
           {
                CatID = rs.getInt(1);
           }

           connection.close();
            return CatID;
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       return 0;
       }
    }

    public void insertInIsCat(int TID, int CID)
    {
        try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           statement.execute("insert into IsCategorized (TID,CID) VALUES("+TID+","+CID+")");
           connection.close();
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       }
    }

    public void insertInTrends(Vector Trends, String Date)
    {
        try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           for(int i = 0; i < Trends.size(); i++)
           statement.execute("INSERT INTO Trends (TrendText,AsOfDate) VALUES('"+Trends.elementAt(i)+"'"+",'"+Date+"')");
           connection.close();
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       }
    }

    public boolean isTrend(String KewWord)
        {
           try
           {
               int count = 0;
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT count(TrendText) FROM Trends WHERE TrendText='"+KewWord+"'");
               ResultSet rs =  statement.getResultSet();
               while(rs.next())
                count  = rs.getInt(1);
               connection.close();
               if(count != 0)
                    return true;
               else
                   return false;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
           return false;
           }
       }

    public int getTrendID(String TrendText)
    {
        try
       {
           int TrendID = -1;
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           statement.execute("SELECT TrendID FROM Trends WHERE TrendText='"+TrendText+"'");
           ResultSet rs =  statement.getResultSet();
           if (rs.next())
           {
                TrendID = rs.getInt(1);
           }

          
           connection.close();
            return TrendID;
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       return 0;
       }
    }

     public void insertInIsTrend(int TweetID, int TrendID)
    {
        try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           statement.execute("insert into IsTrend (TweetID,TrendID) VALUES("+TweetID+","+TrendID+")");
           connection.close();
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       }
    }
     
     
     //inserts in author tabel
     public int insertInAuthor(String Author,String ProfImage)
     {
         int AuthorID = 0;
         try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           //prevent redundancy
           if(!isThere(Author))
           {
               statement.execute("insert into Author (AuthorName,ProfImageURL) VALUES('"+Author+"','"+ProfImage+"')");
           }
       
           statement.execute("SELECT AuthorID FROM Author WHERE AuthorName='"+Author+"'");
               ResultSet rs =  statement.getResultSet();
               if (rs.next())
               {
                    AuthorID = rs.getInt(1);
               }
           connection.close();
           
           return AuthorID;
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       return -1;
       }
     }
     // check if the same author is in author tabel
     public boolean isThere(String AuthorName)
        {
           try
           {
               int count = 0;
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT count(AuthorName) FROM Author WHERE AuthorName='"+AuthorName+"'");
               ResultSet rs =  statement.getResultSet();
               while(rs.next())
                count  = rs.getInt(1);
               connection.close();
               if(count != 0)
                    return true;
               else
                   return false;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
           return false;
           }
       }
     
     //check if the new follower is already in the tabel
     public boolean isFollower(String FollowerName)
        {
           try
           {
               int count = 0;
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT count(FollowerName) FROM Followers WHERE FollowerName='"+FollowerName+"'");
               ResultSet rs =  statement.getResultSet();
               while(rs.next())
                count  = rs.getInt(1);
               connection.close();
               if(count != 0)
                    return true;
               else
                   return false;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error in Checking the Followers Tabel","Try Again",JOptionPane.ERROR_MESSAGE);
           return false;
           }
       }
     
     
     public int insertInFollowers(String Follower,String Status)
     {
         int FollowerID = 0;
         try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           //prevent redundancy
           if(isFollower(Follower) == false)
           {
               statement.execute("INSERT INTO Followers (FollowerName,FollowerStatus) VALUES('"+Follower+"','"+Status+"')");
           }
       
           statement.execute("SELECT FollowerID FROM Followers WHERE FollowerName ='"+Follower+"'");
               ResultSet rs =  statement.getResultSet();
               if (rs.next())
               {
                    FollowerID = rs.getInt(1);
               }
           connection.close();
           
           return FollowerID;
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error in inserting in Followers","Try Again",JOptionPane.ERROR_MESSAGE);
       return -1;
       }
     }
     
     
      public void insertInFollowedBy(int AuthorID, int FollowerID)
    {
        try
       {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection = java.sql.DriverManager.getConnection(DataBase);
           Statement statement = connection.createStatement();
           //System.out.println("In insert"+TweetID);
           if(!SameRelation(AuthorID,FollowerID))
           statement.execute("INSERT INTO FollowedBy (AuthorID,FollowerID) VALUES("+AuthorID+","+FollowerID+")");
          
           connection.close();
       }
       catch(Exception e){e.printStackTrace();
       JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       }
    }
      
      public boolean SameRelation(int AuthorID, int FollowerID)
        {
           try
           {
               int count = 0;
   
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT count(*) FROM FollowedBy WHERE AuthorID="+AuthorID+" AND FollowerID="+FollowerID);
                ResultSet rs =  statement.getResultSet();
                 while(rs.next())
                    count  = rs.getInt(1);
          
               connection.close();
               if(count != 0 )
                    return true;
               else
                   return false;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error in Checking the Followers Tabel","Try Again",JOptionPane.ERROR_MESSAGE);
           return false;
           }
       }
      
      
      public boolean SameTweet(int AuthorID, String Date)
        {
           try
           {
               int count = 0;
   
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT count(*) FROM Tweets WHERE AuthorID="+AuthorID+" AND TweetDate='"+Date+"'");
                ResultSet rs =  statement.getResultSet();
                 while(rs.next())
                    count  = rs.getInt(1);
          
               connection.close();
               if(count != 0 )
                    return true;
               else
                   return false;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error in Checking the Followers Tabel","Try Again",JOptionPane.ERROR_MESSAGE);
           return false;
           }
       }
      
      
      public String getAuthorName(int AuthorID)
        {
           try
           {
               String AuthorName="";
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT AuthorName FROM Author WHERE AuthorID="+AuthorID);
               ResultSet rs =  statement.getResultSet();
               while(rs.next())
                AuthorName = rs.getString("AuthorName");
               connection.close();
               return AuthorName;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
           return "Eror";
           }
       }
      
      public String getImageURL(String AuthorName)
      {
          String ImageURL = "";
          try
           {
               
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT ProfImageURL FROM Author WHERE AuthorName='"+AuthorName+"'");
               ResultSet rs =  statement.getResultSet();
               
               while(rs.next())
                ImageURL = rs.getString("ProfImageURL");
               connection.close();
               return ImageURL;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
           return "Eror";
           }
      }
      
      public String getLanguage(String AuthorName)
      {
          String Language = "";
          try
           {
               
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               
               statement.execute("SELECT Locale FROM Tweets WHERE AuthorID="+getAuthorID(AuthorName));
               ResultSet rs =  statement.getResultSet();
               
               while(rs.next())
                Language = rs.getString("Locale");
               connection.close();
               return Language;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
           return "Eror";
           }
      }
      
      public int getAuthorID(String AuthorName)
      {
          int AuthorID = 0;
          try
           {
               
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               Connection connection = java.sql.DriverManager.getConnection(DataBase);
               Statement statement = connection.createStatement();
               statement.execute("SELECT AuthorID FROM Author WHERE AuthorName='"+AuthorName+"'");
               ResultSet rs =  statement.getResultSet();
               
               while(rs.next())
                AuthorID = rs.getInt("AuthorID");
               connection.close();
               return AuthorID;
            }
           catch(Exception e){e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
           return 0;
           }
      }
    private Vector CatResult = new Vector();
    private String DataBase = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=TwitterDB.mdb;";
}


