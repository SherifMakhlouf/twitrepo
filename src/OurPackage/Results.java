/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Results.java
 *
 * Created on 08/04/2011, 02:05:56 م
 */

package OurPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Results extends javax.swing.JPanel {

String database ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=TwitterDB.mdb;" ;
    public Results() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ResultsTabedPanel = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        AllResultsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        FollowersTable = new javax.swing.JTable();
        NewSearchButton = new javax.swing.JButton();
        MoreDetailsPanel = new javax.swing.JPanel();
        Author = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();
        Language = new javax.swing.JLabel();
        LanguageLabel = new javax.swing.JLabel();
        ProImage = new javax.swing.JLabel();
        ImageLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));

        setBackground(new java.awt.Color(255, 255, 255));

        ResultsTabedPanel.setName("ResultsTabedPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        AllResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tweet Tittle", "Sender Name", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AllResultsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        AllResultsTable.setName("AllResultsTable"); // NOI18N
        AllResultsTable.setShowHorizontalLines(false);
        AllResultsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AllResultsTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(AllResultsTable);
        AllResultsTable.getColumnModel().getColumn(0).setResizable(false);
        AllResultsTable.getColumnModel().getColumn(0).setPreferredWidth(600);
        AllResultsTable.getColumnModel().getColumn(1).setResizable(false);
        AllResultsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        AllResultsTable.getColumnModel().getColumn(2).setResizable(false);
        AllResultsTable.getColumnModel().getColumn(2).setPreferredWidth(150);

        ResultsTabedPanel.addTab("All Results", jScrollPane1);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        FollowersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Follower", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FollowersTable.setName("FollowersTable"); // NOI18N
        FollowersTable.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(FollowersTable);
        FollowersTable.getColumnModel().getColumn(0).setResizable(false);
        FollowersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        FollowersTable.getColumnModel().getColumn(1).setResizable(false);
        FollowersTable.getColumnModel().getColumn(1).setPreferredWidth(450);

        ResultsTabedPanel.addTab("Followers", jScrollPane2);

        NewSearchButton.setText("New Search");
        NewSearchButton.setName("NewSearchButton"); // NOI18N
        NewSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewSearchButtonActionPerformed(evt);
            }
        });

        MoreDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        MoreDetailsPanel.setName("MoreDetailsPanel"); // NOI18N

        Author.setText("Author     :");
        Author.setName("Author"); // NOI18N

        AuthorLabel.setName("AuthorLabel"); // NOI18N

        Language.setText("Language :");
        Language.setName("Language"); // NOI18N

        LanguageLabel.setName("LanguageLabel"); // NOI18N

        ProImage.setText("Author Image :");
        ProImage.setName("ProImage"); // NOI18N

        ImageLabel.setName("ImageLabel"); // NOI18N

        filler1.setName("filler1"); // NOI18N

        javax.swing.GroupLayout MoreDetailsPanelLayout = new javax.swing.GroupLayout(MoreDetailsPanel);
        MoreDetailsPanel.setLayout(MoreDetailsPanelLayout);
        MoreDetailsPanelLayout.setHorizontalGroup(
            MoreDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MoreDetailsPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(MoreDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Author)
                    .addComponent(Language))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MoreDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LanguageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(AuthorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(ProImage)
                .addGap(28, 28, 28)
                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        MoreDetailsPanelLayout.setVerticalGroup(
            MoreDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MoreDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MoreDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MoreDetailsPanelLayout.createSequentialGroup()
                        .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MoreDetailsPanelLayout.createSequentialGroup()
                        .addComponent(AuthorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LanguageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
            .addGroup(MoreDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(MoreDetailsPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(ProImage)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        MoreDetailsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Author, AuthorLabel, Language, LanguageLabel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(MoreDetailsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResultsTabedPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewSearchButton)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(NewSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ResultsTabedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MoreDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NewSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewSearchButtonActionPerformed
       showMyTweetsPageAgain();
  
    }//GEN-LAST:event_NewSearchButtonActionPerformed

    private void AllResultsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllResultsTableMousePressed
        showFollowers(); // TODO add your handling code here:
        showTweetDeails();
}//GEN-LAST:event_AllResultsTableMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable AllResultsTable;
    public static javax.swing.JLabel Author;
    public static javax.swing.JLabel AuthorLabel;
    private javax.swing.JTable FollowersTable;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JLabel Language;
    public static javax.swing.JLabel LanguageLabel;
    public static javax.swing.JPanel MoreDetailsPanel;
    private javax.swing.JButton NewSearchButton;
    private javax.swing.JLabel ProImage;
    public static javax.swing.JTabbedPane ResultsTabedPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
 private Image image = null;
  DefaultTableModel Followersmodel=new DefaultTableModel();
 JavaAccess AccessObj = new JavaAccess();
    private void showMyTweetsPageAgain() {
       StartPageFrame.ShowPanel.removeAll();
       StartPageFrame.ShowPanel.add(new MyTweets());
       StartPageFrame.ShowPanel.setTitleAt(0, "My Tweets");
    }

    public void showImage(String AuthorName)
    {

        try {

	        // Read from a URL
	        URL url = new URL(AccessObj.getImageURL(AuthorName));
	        image = ImageIO.read(url);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
            ImageLabel.setIcon(new ImageIcon(image));
    }
    private void showTweetDeails() {
    

            //TweetDetails details = new TweetDetails(null,true);
            showImage((String)AllResultsTable.getValueAt(AllResultsTable.getSelectedRow(), 1));
            AuthorLabel.setText((String)AllResultsTable.getValueAt(AllResultsTable.getSelectedRow(), 1));
            LanguageLabel.setText(AccessObj.getLanguage((String)AllResultsTable.getValueAt(AllResultsTable.getSelectedRow(), 1)));
            
    }
    private void showFollowers()
    {
       int RowCount=0;
        int i=0;
      int AuthorId=0;

        Vector Fid=new Vector();
     try
        {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           Connection connection=java.sql.DriverManager.getConnection(database);
           Statement statement=connection.createStatement();
           ResultSet getAuthorId=statement.executeQuery("select * from Author where AuthorName='"+(String)AllResultsTable.getValueAt(AllResultsTable.getSelectedRow(), 1)+"'");
           while(getAuthorId.next())
              {
                AuthorId=Integer.parseInt( getAuthorId.getString("AuthorID"));
                
                //TweetDetails.AuthorStatusLabel.setText(getAuthorId.getString("Status"));
            }
           ResultSet getFollowerId=statement.executeQuery("select FollowerID from FollowedBy where AuthorID="+AuthorId+"");
          
            Followersmodel=new DefaultTableModel(new String[]{"Follower","Status"}, 0);
           while(getFollowerId.next())
           {
               Fid.add(getFollowerId.getInt("FollowerID"));
               
            }
           for(int j=0;j<Fid.size();j++)
           {
               ResultSet rs=statement.executeQuery("select * from Followers where FollowerID="+Fid.get(j)+"");
               

          while(rs.next())
          {
              Object obj[]={rs.getString("FollowerName"),rs.getString("FollowerStatus")};
               Followersmodel.addRow(obj);
               RowCount++;
            }
           
       }
    for(int k=RowCount;k<25;k++)
           {
              Object ob[]={"","",""};
               Followersmodel.addRow(ob);
           }
            FollowersTable.setModel(Followersmodel);
           //FollowersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
           //FollowersTable.getColumnModel().getColumn(1).setPreferredWidth(450);
           
           connection.close();
       }
    catch(Exception e){e.printStackTrace();
          JOptionPane.showMessageDialog(null,"Error","Try Again",JOptionPane.ERROR_MESSAGE);
       }
  


}
}