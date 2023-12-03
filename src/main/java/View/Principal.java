/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.Controller;
import java.util.ArrayList;
import java.util.Calendar;
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
        
        Controller.painelConsultasSelected(ConsultasTable);
        
        MesBox.addItem("Mês");
        AnoBox.addItem("Ano");
        DiaBox.addItem("Dia");
        
        for (int i = 1; i <= 12; i++) {
            MesBox.addItem(String.valueOf(i));
        }
        
        for (int i = 1; i <= 31; i++) {
            DiaBox.addItem(String.valueOf(i));
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        AnoBox.addItem(String.valueOf(currentYear));
        AnoBox.addItem(String.valueOf(currentYear + 1));
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
        BuscaTxt = new javax.swing.JLabel();
        BuscaInput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        MainTable = new javax.swing.JTable();
        ConsultasPanel2 = new javax.swing.JPanel();
        NewConsultaBtn = new javax.swing.JButton();
        ApagaConsultaBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ConsultasTable = new javax.swing.JTable();
        DiaBox = new javax.swing.JComboBox<>();
        MesBox = new javax.swing.JComboBox<>();
        AnoBox = new javax.swing.JComboBox<>();
        VetFilter = new javax.swing.JToggleButton();
        AnimalFilter = new javax.swing.JToggleButton();
        TirarFiltros = new javax.swing.JButton();

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
                        .addGap(48, 48, 48)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnimalInput)
                            .addComponent(NameInput)))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(VeterinarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(VeterinarioInput)))
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(NomeTxt))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AnimalText)
                            .addComponent(AnimalInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(VeterinarioText)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(VeterinarioInput, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
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
                        .addGap(18, 18, 18)
                        .addComponent(BtnCadVet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCadEsp))
                    .addGroup(CadastrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnTodos)
                        .addGap(12, 12, 12)
                        .addComponent(BtnNovo)
                        .addGap(134, 134, 134)
                        .addComponent(BuscaTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 314, Short.MAX_VALUE))
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
        ConsultasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConsultasTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ConsultasTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(ConsultasTable);

        DiaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        DiaBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DiaBoxItemStateChanged(evt);
            }
        });

        MesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        MesBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MesBoxItemStateChanged(evt);
            }
        });

        AnoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        AnoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AnoBoxItemStateChanged(evt);
            }
        });

        VetFilter.setText("Filtrar Veterinario");
        VetFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VetFilterActionPerformed(evt);
            }
        });

        AnimalFilter.setText("Filtrar Animal");
        AnimalFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AnimalFilterItemStateChanged(evt);
            }
        });
        AnimalFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalFilterActionPerformed(evt);
            }
        });

        TirarFiltros.setText("Tirar Filtros");
        TirarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TirarFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultasPanel2Layout = new javax.swing.GroupLayout(ConsultasPanel2);
        ConsultasPanel2.setLayout(ConsultasPanel2Layout);
        ConsultasPanel2Layout.setHorizontalGroup(
            ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultasPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(ConsultasPanel2Layout.createSequentialGroup()
                        .addComponent(NewConsultaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApagaConsultaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(VetFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AnimalFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DiaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AnoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TirarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ConsultasPanel2Layout.setVerticalGroup(
            ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultasPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultasPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewConsultaBtn)
                    .addComponent(ApagaConsultaBtn)
                    .addComponent(DiaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VetFilter)
                    .addComponent(AnimalFilter)
                    .addComponent(TirarFiltros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        ClinicaPanel.addTab("Consultas", ConsultasPanel2);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClinicaPanel, javax.swing.GroupLayout.Alignment.TRAILING))
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
                /*if((Controller.getClienteSelecionado() == null) || (Controller.getAnimalSelecionado() == null) || (Controller.getVeterinarioSelecionado() == null)){
                    JOptionPane.showMessageDialog(this, "Selecione um cliente, um animal e um veterinario");
                    ClinicaPanel.setSelectedIndex(0);
                }
                else{
                    Controller.painelConsultasSelected(ConsultasTable);
                }*/
                break;
    }
    }//GEN-LAST:event_ClinicaPanelStateChanged

    private void ConsultasTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultasTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ConsultasTableMouseClicked

    private void ConsultasTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultasTableMousePressed
        Controller.setSelected(((GenericTableModel)ConsultasTable.getModel()).getItem(ConsultasTable.getSelectedRow()));
    }//GEN-LAST:event_ConsultasTableMousePressed

    private void DiaBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DiaBoxItemStateChanged
        Controller.filtroAplicado(ConsultasTable, VetFilter, AnimalFilter, DiaBox, MesBox, AnoBox);
        
    }//GEN-LAST:event_DiaBoxItemStateChanged

    private void VetFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VetFilterActionPerformed
        if(!Controller.FiltroVetSelecionado()){
            JOptionPane.showMessageDialog(this, "Selecione um veterinario");
            VetFilter.setSelected(false);
        }
        else{
            
            Controller.filtroAplicado(ConsultasTable, VetFilter, AnimalFilter, DiaBox, MesBox, AnoBox);
        }
   
    }//GEN-LAST:event_VetFilterActionPerformed

    private void AnimalFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalFilterActionPerformed
        
    }//GEN-LAST:event_AnimalFilterActionPerformed

    private void AnimalFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AnimalFilterItemStateChanged
        if(AnimalFilter.isSelected()){
            if(!Controller.FiltroAnimalSelecionado()){
            JOptionPane.showMessageDialog(this, "Selecione um animal");
            AnimalFilter.setSelected(false);
            }
            else{
                Controller.filtroAplicado(ConsultasTable, VetFilter, AnimalFilter, DiaBox, MesBox, AnoBox);
            }
        }
        else{
            Controller.filtroAplicado(ConsultasTable, VetFilter, AnimalFilter, DiaBox, MesBox, AnoBox);
        }
    }//GEN-LAST:event_AnimalFilterItemStateChanged

    private void MesBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MesBoxItemStateChanged
        Controller.filtroAplicado(ConsultasTable, VetFilter, AnimalFilter, DiaBox, MesBox, AnoBox);
    }//GEN-LAST:event_MesBoxItemStateChanged

    private void AnoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AnoBoxItemStateChanged
        Controller.filtroAplicado(ConsultasTable, VetFilter, AnimalFilter, DiaBox, MesBox, AnoBox);
    }//GEN-LAST:event_AnoBoxItemStateChanged

    private void TirarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TirarFiltrosActionPerformed
        VetFilter.setSelected(false);
        AnimalFilter.setSelected(false);
        DiaBox.setSelectedItem("Dia");
        MesBox.setSelectedItem("Mês");
        AnoBox.setSelectedItem("Ano");
        Controller.filtroAplicado(ConsultasTable, VetFilter, AnimalFilter, DiaBox, MesBox, AnoBox);
    }//GEN-LAST:event_TirarFiltrosActionPerformed

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
    private javax.swing.JToggleButton AnimalFilter;
    private javax.swing.JTextField AnimalInput;
    private javax.swing.JLabel AnimalText;
    private javax.swing.JComboBox<String> AnoBox;
    private javax.swing.JButton ApagaConsultaBtn;
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
    private javax.swing.JComboBox<String> DiaBox;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JTable MainTable;
    private javax.swing.JComboBox<String> MesBox;
    private javax.swing.JTextField NameInput;
    private javax.swing.JButton NewConsultaBtn;
    private javax.swing.JLabel NomeTxt;
    private javax.swing.JButton TirarFiltros;
    private javax.swing.JToggleButton VetFilter;
    private javax.swing.JTextField VeterinarioInput;
    private javax.swing.JLabel VeterinarioText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
