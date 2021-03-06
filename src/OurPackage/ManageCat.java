/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ManageCat.java
 *
 * Created on Mar 18, 2011, 12:01:57 AM
 */

package OurPackage;

import OurPackage.Map;
import OurPackage.JavaAccess;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author sherif
 */
public class ManageCat extends javax.swing.JPanel {

    /** Creates new form ManageCat */
    public ManageCat() {
        initComponents();
        //showCat();
       
    }

    //Functions________________________________________________________________
    public void addCat()
    {
        boolean Found = false;
        String CatName = JOptionPane.showInputDialog("Category name");
        if(CatName != null )
            {
            for(int i = 0; i < CatModel.size();i++)
            {
                if(CatName.equals(CatModel.elementAt(i)))
                {
                    Found = true;
                }
            }
            
            if(!Found)
            {
                CatModel.add(CatModel.size(),CatName);
                AccessObj.insertInCat(CatName);
            }
         else
            {
                JOptionPane.showMessageDialog(null,"Error The inserted category already exists","Try Again",JOptionPane.ERROR_MESSAGE);
            }
            }
    }

    public void deleteCat()
    {
        
        
        if(CatList.getSelectedIndex() != 0)
        {
            AccessObj.deleteFromCat((String)CatList.getSelectedValue());
            CatModel.remove(CatList.getSelectedIndex());
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Can't Delete The General Category","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void sendItem()
    {
       
        if(!CatModel.isEmpty())
        {
           for(int i = 0; i < CatModel.size();i++)
           {
               Map.initCombo(CatModel.elementAt(i));
              
           }
        }
    }

    public void showCat()
    {
        Vector CatVector = new Vector();
        CatVector = AccessObj.getFromCat();
       
        for(int i = 0; i < CatVector.size();i++)
        {
            CatModel.addElement(CatVector.elementAt(i));
           
           
        }
    }
    
      public void setLookAndFeel()
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception excep) {
        }
    }
    //__________________________________________________________________________
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CatList = new javax.swing.JList(CatModel);
        AddCatButton = new javax.swing.JButton();
        DeleteCatButton = new javax.swing.JButton();
        CatLabel = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ManageCat.class);
        setBackground(resourceMap.getColor("Manage Categories.background")); // NOI18N
        setName("Manage Categories"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        CatList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CatList.setName("CatList"); // NOI18N
        jScrollPane1.setViewportView(CatList);

        AddCatButton.setText(resourceMap.getString("AddCatButton.text")); // NOI18N
        AddCatButton.setName("AddCatButton"); // NOI18N
        AddCatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCatButtonActionPerformed(evt);
            }
        });

        DeleteCatButton.setText(resourceMap.getString("DeleteCatButton.text")); // NOI18N
        DeleteCatButton.setName("DeleteCatButton"); // NOI18N
        DeleteCatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCatButtonActionPerformed(evt);
            }
        });

        CatLabel.setText(resourceMap.getString("CatLabel.text")); // NOI18N
        CatLabel.setName("CatLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddCatButton)
                            .addComponent(DeleteCatButton)))
                    .addComponent(CatLabel))
                .addContainerGap(451, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddCatButton, DeleteCatButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddCatButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteCatButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddCatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCatButtonActionPerformed
        // TODO add your handling code here:
        addCat();
    }//GEN-LAST:event_AddCatButtonActionPerformed

    private void DeleteCatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCatButtonActionPerformed
        // TODO add your handling code here:
        deleteCat();
    }//GEN-LAST:event_DeleteCatButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCatButton;
    private javax.swing.JLabel CatLabel;
    private javax.swing.JList CatList;
    private javax.swing.JButton DeleteCatButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public static DefaultListModel CatModel = new DefaultListModel();
    JavaAccess AccessObj = new JavaAccess();  
}