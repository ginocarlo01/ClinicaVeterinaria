/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.Controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
/**
 *
 * @author gino
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    private void clearComponents(){
        ButtonGroup.add(BtnCadCli);
        ButtonGroup.add(BtnCadAni);
        ButtonGroup.add(BtnCadEsp);
        ButtonGroup.add(BtnCadVet);
        NameInput.setText("");
        AnimalInput.setText("");
        BuscaInput.setText("");
        VeterinarioInput.setText("");
        BtnCadCli.setSelected(true);
        //controller seta tabela de cliente
        //Controller.setTableModel(MainTable, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
        Controller.jRadioButtonClientesSelecionado(MainTable);
        
        //controller guarda animal e cliente selecionados (vazio até agora
        Controller.setTextFields(NameInput, AnimalInput, VeterinarioInput);
        
        //Controller.setTableModel(ConsultasTable, new ConsultaTableModel(Controller.);
    }
    
    public Principal() {
        initComponents();
        clearComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MainPanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        NomeTxt = new javax.swing.JLabel();
        AnimalText = new javax.swing.JLabel();
        VeterinarioText = new javax.swing.JLabel();
        NameInput = new javax.swing.JTextField();
        AnimalInput = new javax.swing.JTextField();
        VeterinarioInput = new javax.swing.JTextField();
        ClinicaPanel = new javax.swing.JTabbedPane();
        Cadastros = new javax.swing.JPanel();
        BtnCadCli = new javax.swing.JRadioButton();
        BtnCadAni = new javax.swing.JRadioButton();
        BtnCadEsp = new javax.swing.JRadioButton();
        BtnCadVet = new javax.swing.JRadioButton();
        BtnTodos = new javax.swing.JButton();
        BtnNovo = new javax.swing.JButton();
        BtnApaga = new javax.swing.JButton();
        BuscaTxt = new javax.swing.JLabel();
        BuscaInput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        MainTable = new javax.swing.JTable();
        ConsultasPanel2 = new javax.swing.JPanel();
        NewConsultaBtn = new javax.swing.JButton();
        ApagaConsultaBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ConsultasTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Header.setName(""); // NOI18N

        NomeTxt.setText("Cliente");

        AnimalText.setText("Animal");

        VeterinarioText.setText("Veterinario");

        NameInput.setEditable(false);
        NameInput.setText("Insira seu nome");
        NameInput.setVerifyInputWhenFocusTarget(false);
        NameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameInputActionPerformed(evt);
            }
        });

        AnimalInput.setEditable(false);
        AnimalInput.setText("jTextField1");

        VeterinarioInput.setEditable(false);
        VeterinarioInput.setText("jTextField1");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NomeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AnimalText, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                            .addComponent(AnimalInput)))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(VeterinarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(VeterinarioInput)))
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(NomeTxt)
                        .addGap(18, 18, 18)
                        .addComponent(AnimalText))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(NameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AnimalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VeterinarioText)
                    .addComponent(VeterinarioInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ClinicaPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ClinicaPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ClinicaPanelStateChanged(evt);
            }
        });
        ClinicaPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ClinicaPanelFocusGained(evt);
            }
        });
        ClinicaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ClinicaPanelMousePressed(evt);
            }
        });

        BtnCadCli.setText("Cadastro Clientes");
        BtnCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadCliActionPerformed(evt);
            }
        });

        BtnCadAni.setText("Cadastro Animais");
        BtnCadAni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadAniActionPerformed(evt);
            }
        });

        BtnCadEsp.setText("Cadastro Espécies");
        BtnCadEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadEspActionPerformed(evt);
            }
        });

        BtnCadVet.setText("Cadastro Veterinario");
        BtnCadVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadVetActionPerformed(evt);
            }
        });

        BtnTodos.setText("Todos");
        BtnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTodosActionPerformed(evt);
            }
        });

        BtnNovo.setText("Novo");
        BtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovoActionPerformed(evt);
            }
        });

        BtnApaga.setText("Apaga");
        BtnApaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApagaActionPerformed(evt);
            }
        });

        BuscaTxt.setText("Busca");

        BuscaInput.setText("jTextField2");
        BuscaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaInputActionPerformed(evt);
            }
        });
        BuscaInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscaInputKeyTyped(evt);
            }
        });

        MainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        MainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(MainTable);

        javax.swing.GroupLayout CadastrosLayout = new javax.swing.GroupLayout(Cadastros);
        Cadastros.setLayout(CadastrosLayout);
        CadastrosLayout.setHorizontalGroup(
            CadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastrosLayout.createSequentialGroup()
                .addGroup(CadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CadastrosLayout.createSequentialGroup()
                        .addComponent(BtnCadCli)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCadAni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCadEsp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCadVet))
                    .addGroup(CadastrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnTodos)
                        .addGap(12, 12, 12)
                        .addComponent(BtnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(BtnApaga)
                        .addGap(44, 44, 44)
                        .addComponent(BuscaTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 278, Short.MAX_VALUE))
            .addGroup(CadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        CadastrosLayout.setVerticalGroup(
            CadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastrosLayout.createSequentialGroup()
                .addGroup(CadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCadCli)
                    .addComponent(BtnCadAni)
                    .addComponent(BtnCadEsp)
                    .addComponent(BtnCadVet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTodos)
                    .addComponent(BtnNovo)
                    .addComponent(BtnApaga)
                    .addComponent(BuscaTxt)
                    .addComponent(BuscaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        ClinicaPanel.addTab("Cadastros", Cadastros);

        ConsultasPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ConsultasPanel2FocusGained(evt);
            }
        });
        ConsultasPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConsultasPanel2MousePressed(evt);
            }
        });

        NewConsultaBtn.setText("Novo");
        NewConsultaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewConsultaBtnActionPerformed(evt);
            }
        });

        ApagaConsultaBtn.setText("Apaga");
        ApagaConsultaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagaConsultaBtnActionPerformed(evt);
            }
        });

        ConsultasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(ConsultasTable);

        javax.swing.GroupLayout ConsultasPanel2Layout = new javax.swing.GroupLayout(ConsultasPanel2);
        ConsultasPanel2.setLayout(ConsultasPanel2Layout);
        ConsultasPanel2Layout.setHorizontalGroup(
            ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultasPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultasPanel2Layout.createSequentialGroup()
                        .addComponent(NewConsultaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ApagaConsultaBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))
                .addContainerGap())
        );
        ConsultasPanel2Layout.setVerticalGroup(
            ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultasPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewConsultaBtn)
                    .addComponent(ApagaConsultaBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        ClinicaPanel.addTab("Consultas", ConsultasPanel2);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ClinicaPanel)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClinicaPanel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameInputActionPerformed

    private void BtnCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadCliActionPerformed
        Controller.jRadioButtonClientesSelecionado(MainTable);
        BuscaInput.setText("");
        //Controller.setTableModel(MainTable, new ClientTableModel(ClienteDAO.getInstance().retrieveAll()));
    }//GEN-LAST:event_BtnCadCliActionPerformed

    private void BtnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTodosActionPerformed
        Controller.getAllData(MainTable);
        BuscaInput.setText("");
        /*if(MainTable.getModel() instanceof ClienteTableModel){
           Controller.jRadioButtonClientesSelecionado(MainTable);
           //ou
            //((GenericTableModel)MainTable.getModel()).addListOfItems(Controller.getAllClients());
            
            BuscaInput.setText("");
        }*/
    }//GEN-LAST:event_BtnTodosActionPerformed

    private void BtnCadAniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadAniActionPerformed
        BuscaInput.setText("");
        if(!Controller.jRadioButtonAnimalSelecionado(MainTable)){
            JOptionPane.showMessageDialog(this, "Selecione um cliente!");
            BtnCadCli.setSelected(true);
            Controller.jRadioButtonClientesSelecionado(MainTable);
            Controller.setTextFields(NameInput, AnimalInput, VeterinarioInput);
        }
        /*
        if(Controller.getClienteSelecionado() != null){
            Controller.setTableModel(MainTable, new AnimalTableModel(AnimalDAO.getInstance().retrieveAll()));
        }
        else{
            Controller.setTableModel(MainTable, new AnimalTableModel(new ArrayList()));
            JOptionPane.showMessageDialog(this, "Selecione um cliente.");
        
        */
    }//GEN-LAST:event_BtnCadAniActionPerformed

    private void MainTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainTableMousePressed
        Controller.setSelected(((GenericTableModel)MainTable.getModel()).getItem(MainTable.getSelectedRow()));
    }//GEN-LAST:event_MainTableMousePressed

    private void BtnCadEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadEspActionPerformed
        BuscaInput.setText("");
        Controller.jRadioButtonEspecieSelecionado(MainTable);
    }//GEN-LAST:event_BtnCadEspActionPerformed

    private void BtnCadVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadVetActionPerformed
        BuscaInput.setText("");
        Controller.jRadioButtonVeterinarioSelecionado(MainTable);
    }//GEN-LAST:event_BtnCadVetActionPerformed

    private void BuscaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscaInputActionPerformed

    private void BuscaInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscaInputKeyTyped
        
        Controller.updateDataBySimilarName(MainTable, BuscaInput.getText());
        /*if(MainTable.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)MainTable.getModel()).addListOfItems(Controller.getClientsBySimilarName(BuscaInput.getText()));
        }*/
    }//GEN-LAST:event_BuscaInputKeyTyped

    private void BtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoActionPerformed
        Controller.createNewData(MainTable);
        
    }//GEN-LAST:event_BtnNovoActionPerformed

    private void BtnApagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApagaActionPerformed
        Controller.apagaBtn(MainTable);
    }//GEN-LAST:event_BtnApagaActionPerformed

    private void ClinicaPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClinicaPanelMousePressed
        
    }//GEN-LAST:event_ClinicaPanelMousePressed

    private void NewConsultaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewConsultaBtnActionPerformed
         if(!Controller.createNewData(ConsultasTable)){
             JOptionPane.showMessageDialog(this, "Selecione um cliente, um animal e um veterinario");
         }
    }//GEN-LAST:event_NewConsultaBtnActionPerformed

    private void ApagaConsultaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagaConsultaBtnActionPerformed
        if(!Controller.apagaConsulta(ConsultasTable)){
             JOptionPane.showMessageDialog(this, "Selecione uma consulta");
         }
    }//GEN-LAST:event_ApagaConsultaBtnActionPerformed

    private void ConsultasPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultasPanel2MousePressed
        System.out.println("Pressionou Consultas");
    }//GEN-LAST:event_ConsultasPanel2MousePressed

    private void ClinicaPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ClinicaPanelFocusGained
        
    }//GEN-LAST:event_ClinicaPanelFocusGained

    private void ConsultasPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ConsultasPanel2FocusGained
        
    }//GEN-LAST:event_ConsultasPanel2FocusGained

    private void ClinicaPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ClinicaPanelStateChanged
        JTabbedPane tabbedPane = (JTabbedPane) evt.getSource();
        int selectedIndex = tabbedPane.getSelectedIndex();

        switch (selectedIndex) {
            case 0:
                break;
            case 1:
                if((Controller.getClienteSelecionado() == null) || (Controller.getAnimalSelecionado() == null) || (Controller.getVeterinarioSelecionado() == null)){
                    JOptionPane.showMessageDialog(this, "Selecione um cliente, um animal e um veterinario");
                    ClinicaPanel.setSelectedIndex(0);
                }
                else{
                    Controller.painelConsultasSelected(ConsultasTable);
                }
                break;
    }
    }//GEN-LAST:event_ClinicaPanelStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnimalInput;
    private javax.swing.JLabel AnimalText;
    private javax.swing.JButton ApagaConsultaBtn;
    private javax.swing.JButton BtnApaga;
    private javax.swing.JRadioButton BtnCadAni;
    private javax.swing.JRadioButton BtnCadCli;
    private javax.swing.JRadioButton BtnCadEsp;
    private javax.swing.JRadioButton BtnCadVet;
    private javax.swing.JButton BtnNovo;
    private javax.swing.JButton BtnTodos;
    private javax.swing.JTextField BuscaInput;
    private javax.swing.JLabel BuscaTxt;
    private javax.swing.ButtonGroup ButtonGroup;
    private javax.swing.JPanel Cadastros;
    private javax.swing.JTabbedPane ClinicaPanel;
    private javax.swing.JPanel ConsultasPanel2;
    private javax.swing.JTable ConsultasTable;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JTable MainTable;
    private javax.swing.JTextField NameInput;
    private javax.swing.JButton NewConsultaBtn;
    private javax.swing.JLabel NomeTxt;
    private javax.swing.JTextField VeterinarioInput;
    private javax.swing.JLabel VeterinarioText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
