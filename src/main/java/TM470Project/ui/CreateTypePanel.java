/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TM470Project.ui;

import TM470Project.EntryType;
import TM470Project.TM470ProjectRunner;

import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

import static TM470Project.ui.MainFrame.getWindow;

/**
 * Class representing the window panel for creating a new EntryType
 * @author Joao
 * v4 23/07/2023
 */
public class CreateTypePanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateTypePanel
     */
    public CreateTypePanel() {
        initComponents();
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
        nameLabel = new javax.swing.JLabel();
        unitLabel = new javax.swing.JLabel();
        kcalLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        kcalField = new javax.swing.JTextField();
        unitComboBox = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(246, 230));

        returnButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnButton.setText("<");
        returnButton.setToolTipText("Return to the previous screen.");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel.setText("Name");

        unitLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        unitLabel.setText("Unit of measure");

        kcalLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kcalLabel.setText("kcal per unit");

        nameField.setToolTipText("The name for the entry type.");

        kcalField.setToolTipText("The kilocalorie value per 1 unit of exercise.");

        unitComboBox.setEditable(true);
        unitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "metres", "kilometres", "yards", "miles", "seconds", "minutes", "reps", "sets" }));
        unitComboBox.setToolTipText("The metric by which to measure your entry type.");

        confirmButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.setToolTipText("Finalize your entry.");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleLabel.setText("Create Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(returnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(unitLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(unitComboBox, 0, 96, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kcalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kcalField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(confirmButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitLabel)
                    .addComponent(unitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kcalLabel)
                    .addComponent(kcalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(confirmButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method for saving Type and returning to the Entry Type Selection Panel
     * @param evt internal ActionEvent listener for the methods, used by generated code
     */
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        System.out.println("Confirm button pressed.");

        String typeName = nameField.getText().trim();
        String unit = unitComboBox.getSelectedItem().toString();
        // TODO edit unit declaration so that custom inputs are valid
        String kcal = kcalField.getText().trim();

        System.out.println("typeName: " + typeName + ", unit: " + unit + ", kcal: " + kcal);

        // check that all fields are filled out
        if(typeName.isEmpty() || unit.isEmpty() || kcalField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Error: input fields may have been left blank.");
            return;
        }

        //check that kcal is a valid numerical input
        double kcalDouble;
        try{
            kcalDouble = Double.parseDouble(kcal);
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error: input for calorie value must be a number.");
            System.out.println("kcal is not a number.");
            return;
            }
        System.out.println("kcal is a number.");

        //check if the type already exists (editing existing types is done in a different panel)
        try{
            if(TM470ProjectRunner.getController().findEntryTypeByName(typeName) == null){
                System.out.println("System Error"); //should never occur as triggers noResultException
            }
            else{
                //should always happen if a type exists, else catch block will trigger
                JOptionPane.showMessageDialog(null, "Error: Object with this name reference already exists. \n Please edit the existing type or use a different name.");
                System.out.println("entry type with this name already exists.");
            }
            return;
        }
        catch(NoResultException noResultException){
            //if no type with the same name exists, it is created
            EntryType entryType = new EntryType(typeName, unit, kcalDouble);
            TM470ProjectRunner.getController().saveEntryType(entryType);
            System.out.println("Created Entry Type object \n" + entryType);
        }
        //updates the list of available types
        getWindow().getCreateEntryPanel().populateTypeComboBox();
        getWindow().getEditEntryPanel().populateTypeComboBox();
        getWindow().getEntryTypeSelectionPanel().updateListing();
        //return to entry type selection panel
        getWindow().changeScreen("TYPE SELECTION");
    }//GEN-LAST:event_confirmButtonActionPerformed

    /**
     * Changes screen to Entry Type Selection Panel
     * @param evt internal ActionEvent listener for the methods, used by generated code
     */
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        //return to entry type selection panel
        getWindow().changeScreen("TYPE SELECTION");
    }//GEN-LAST:event_returnButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField kcalField;
    private javax.swing.JLabel kcalLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> unitComboBox;
    private javax.swing.JLabel unitLabel;
    // End of variables declaration//GEN-END:variables
}
