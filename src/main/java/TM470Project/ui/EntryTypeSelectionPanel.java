/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TM470Project.ui;

import TM470Project.EntryType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static TM470Project.ui.MainFrame.getWindow;

/**
 *
 * @author Joao
 */
public class EntryTypeSelectionPanel extends javax.swing.JPanel {

    private List<JButton> buttons;
    private HashMap<JButton, EntryType> buttonHashMap;
    private EntryType selectedType;

    /**
     * Creates new form EntryTypeSelectionPanel
     */
    public EntryTypeSelectionPanel() {
        buttons = new ArrayList<>();
        buttonHashMap = new HashMap<>();

        initComponents();
        updateListing();

        // TODO fix scroll to actually scroll down but only if there are things there (e.g if button 7 is visible, scroll down to x distance)
    }

    /**
     * first time set up for EntryTypeSelectionPanel.
     * Adds every type button to a controllable List and sets visibility to false.
     * Then forms associations between buttons and EntryTypes and makes only associated buttons visible.
     */
    public void updateListing(){
        buttons.clear();

        buttons.add(type1);
        buttons.add(type2);
        buttons.add(type3);
        buttons.add(type4);
        buttons.add(type5);
        buttons.add(type6);
        buttons.add(type7);
        buttons.add(type8);
        buttons.add(type9);
        buttons.add(type10);
        buttons.add(type11);
        buttons.add(type12);
        buttons.add(type13);
        buttons.add(type14);
        buttons.add(type15);
        buttons.add(type16);
        buttons.add(type17);
        buttons.add(type18);
        buttons.add(type19);
        buttons.add(type20);

        //make all buttons invisible
        for(JButton button : buttons){
            button.setVisible(false);
        }

        //create associations between button and EntryType
        if(CreateEntryPanel.getTypesList().isPresent()){
            for(int i = 0; i < CreateEntryPanel.getTypesList().get().size(); i++){
                buttonHashMap.put(buttons.get(i), (EntryType) CreateEntryPanel.getTypesList().get().get(i));
            }
        }
        updateButtonVisibility();
    }

    /**
     * Updates button visibility and access when modifying name, creating new types or deleting existing ones
     */
    public void updateButtonVisibility(){
        for(JButton button : buttons){
            if(buttonHashMap.containsKey(button)){
                button.setVisible(true);
                button.setText(buttonHashMap.get(button).getName());
            }
        }
    }

    /**
     * Defines selected type as the type associated with the button press to be used by the EditTypePanel
     * and changes screen to EditTypePanel
     * @param button the button being pressed
     */
    public void typeButtonPress(JButton button){
        selectedType = buttonHashMap.get(button);
        getWindow().getEditTypePanel().updateFields();
        getWindow().changeScreen("EDIT TYPE");
    }

    /**
     * This method is called from within the constructor to updateListing the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        returnButton = new javax.swing.JButton();
        scrollBar = new javax.swing.JScrollBar();
        type1 = new javax.swing.JButton();
        type2 = new javax.swing.JButton();
        type5 = new javax.swing.JButton();
        type4 = new javax.swing.JButton();
        type6 = new javax.swing.JButton();
        type3 = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        type7 = new javax.swing.JButton();
        type8 = new javax.swing.JButton();
        type9 = new javax.swing.JButton();
        type10 = new javax.swing.JButton();
        type11 = new javax.swing.JButton();
        type12 = new javax.swing.JButton();
        type13 = new javax.swing.JButton();
        type14 = new javax.swing.JButton();
        type15 = new javax.swing.JButton();
        type16 = new javax.swing.JButton();
        type17 = new javax.swing.JButton();
        type18 = new javax.swing.JButton();
        type19 = new javax.swing.JButton();
        type20 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        returnButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnButton.setText("<");
        returnButton.setToolTipText("Return to the previous screen.");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        scrollBar.setAutoscrolls(true);

        type1.setText("<<anEntryType>>");
        type1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type1ActionPerformed(evt);
            }
        });

        type2.setText("<<anEntryType>>");
        type2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type2ActionPerformed(evt);
            }
        });

        type5.setText("<<anEntryType>>");
        type5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type5ActionPerformed(evt);
            }
        });

        type4.setText("<<anEntryType>>");
        type4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type4ActionPerformed(evt);
            }
        });

        type6.setText("<<anEntryType>>");
        type6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type6ActionPerformed(evt);
            }
        });

        type3.setText("<<anEntryType>>");
        type3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type3ActionPerformed(evt);
            }
        });

        newButton.setText("New");
        newButton.setToolTipText("Create new entry type.");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        type7.setText("<<anEntryType>>");
        type7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type7ActionPerformed(evt);
            }
        });

        type8.setText("<<anEntryType>>");
        type8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type8ActionPerformed(evt);
            }
        });

        type9.setText("<<anEntryType>>");
        type9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type9ActionPerformed(evt);
            }
        });

        type10.setText("<<anEntryType>>");
        type10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type10ActionPerformed(evt);
            }
        });

        type11.setText("<<anEntryType>>");
        type11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type11ActionPerformed(evt);
            }
        });

        type12.setText("<<anEntryType>>");
        type12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type12ActionPerformed(evt);
            }
        });

        type13.setText("<<anEntryType>>");
        type13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type13ActionPerformed(evt);
            }
        });

        type14.setText("<<anEntryType>>");
        type14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type14ActionPerformed(evt);
            }
        });

        type15.setText("<<anEntryType>>");
        type15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type15ActionPerformed(evt);
            }
        });

        type16.setText("<<anEntryType>>");
        type16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type16ActionPerformed(evt);
            }
        });

        type17.setText("<<anEntryType>>");
        type17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type17ActionPerformed(evt);
            }
        });

        type18.setText("<<anEntryType>>");
        type18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type18ActionPerformed(evt);
            }
        });

        type19.setText("<<anEntryType>>");
        type19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type19ActionPerformed(evt);
            }
        });

        type20.setText("<<anEntryType>>");
        type20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(returnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newButton))
                    .addComponent(type1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(type2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type5, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type8, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type9, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type11, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type12, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type14, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type15, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type17, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type18, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(type20, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(type1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void type1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type1ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type1ActionPerformed

    private void type2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type2ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type2ActionPerformed

    private void type5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type5ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type5ActionPerformed

    private void type4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type4ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type4ActionPerformed

    private void type6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type6ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type6ActionPerformed

    private void type3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type3ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type3ActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        //update listings
        getWindow().getCreateEntryPanel().populateTypeComboBox();
        getWindow().getEntryTypeSelectionPanel().updateListing();
        //return to previous screen
        getWindow().changeScreen("CREATE ENTRY");
    }//GEN-LAST:event_returnButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        getWindow().changeScreen("CREATE TYPE");
    }//GEN-LAST:event_newButtonActionPerformed

    private void type7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type7ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type7ActionPerformed

    private void type8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type8ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type8ActionPerformed

    private void type9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type9ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type9ActionPerformed

    private void type10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type10ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type10ActionPerformed

    private void type11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type11ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type11ActionPerformed

    private void type12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type12ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type12ActionPerformed

    private void type13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type13ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type13ActionPerformed

    private void type14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type14ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type14ActionPerformed

    private void type15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type15ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type15ActionPerformed

    private void type16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type16ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type16ActionPerformed

    private void type17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type17ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type17ActionPerformed

    private void type18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type18ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type18ActionPerformed

    private void type19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type19ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type19ActionPerformed

    private void type20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type20ActionPerformed
        typeButtonPress((JButton)evt.getSource());
    }//GEN-LAST:event_type20ActionPerformed

    public EntryType getSelectedType(){
        return selectedType;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton newButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JScrollBar scrollBar;
    private javax.swing.JButton type1;
    private javax.swing.JButton type10;
    private javax.swing.JButton type11;
    private javax.swing.JButton type12;
    private javax.swing.JButton type13;
    private javax.swing.JButton type14;
    private javax.swing.JButton type15;
    private javax.swing.JButton type16;
    private javax.swing.JButton type17;
    private javax.swing.JButton type18;
    private javax.swing.JButton type19;
    private javax.swing.JButton type2;
    private javax.swing.JButton type20;
    private javax.swing.JButton type3;
    private javax.swing.JButton type4;
    private javax.swing.JButton type5;
    private javax.swing.JButton type6;
    private javax.swing.JButton type7;
    private javax.swing.JButton type8;
    private javax.swing.JButton type9;
    // End of variables declaration//GEN-END:variables
}
