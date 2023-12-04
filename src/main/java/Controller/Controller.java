/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import org.jdatepicker.JDatePicker;
import java.awt.Component;
import javax.swing.table.DefaultTableCellRenderer;
import Model.ExameDAO;
import Model.Exame;
import Model.EspecieDAO;
import Model.Veterinario;
import Model.VeterinarioDAO;
import Model.Cliente;
import Model.Consulta;
import Model.Especie;
import Model.ClienteDAO;
import Model.AnimalDAO;
import Model.Animal;
import Model.ConsultaDAO;
import View.EspecieTableModel;
import View.ConsultaTableModel;
import View.VeterinarioTableModel;
import View.GenericTableModel;
import View.ClienteTableModel;
import View.AnimalTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.table.TableColumn;

/**
 *
 * @author ginoc
 */
public class Controller {
    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado = null;
    private static Veterinario veterinarioSelecionado = null;
    private static Consulta consultaSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField veterinarioSelecionadoTextField = null;
    
    public static void jRadioButtonClientesSelecionado(JTable table){
        setTableModel(table, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
    }
    
    public static void updateTabelaClientes(JTable table, List data){
        setTableModel(table, new ClienteTableModel(data));
    }
    
    public static void updateTabelaVeterinario(JTable table, List data){
        setTableModel(table, new VeterinarioTableModel(data));
    }
    
    public static void updateTabelaEspecie(JTable table, List data){
        setTableModel(table, new EspecieTableModel(data));
    }
    
    public static void updateTabelaAnimais(JTable table, List data) {
        setTableModel(table, new AnimalTableModel(data));
        

        JComboBox<String> especiesBox = new JComboBox<>();
        List<Especie> especies = EspecieDAO.getInstance().retrieveAll();
        for (Especie especie : especies) {
            especiesBox.addItem(especie.getNome()); // Substitua 'getNome()' pelo método que retorna o nome do animal
            table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(especiesBox));
        }

        JComboBox<Integer> yearComboBox = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= currentYear - 50; i--) {
            yearComboBox.addItem(i);
        }

        TableColumn yearColumn = table.getColumnModel().getColumn(1);
        yearColumn.setCellEditor(new DefaultCellEditor(yearComboBox));

        JComboBox<String> sexBox = new JComboBox<>();
        sexBox.addItem("Macho");
        sexBox.addItem("Fêmea");
        TableColumn sexColumn = table.getColumnModel().getColumn(2);
        sexColumn.setCellEditor(new DefaultCellEditor(sexBox));
        
    
    }
    
    public static boolean jRadioButtonAnimalSelecionado(JTable table) {
    if (getClienteSelecionado() != null) {
        setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByIdCliente(getClienteSelecionado().getId())));

        JComboBox<String> especiesBox = new JComboBox<>();
        List<Especie> especies = EspecieDAO.getInstance().retrieveAll();
        for (Especie especie : especies) {
            especiesBox.addItem(especie.getNome()); // Substitua 'getNome()' pelo método que retorna o nome do animal
            table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(especiesBox));
        }

        JComboBox<Integer> yearComboBox = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= currentYear - 50; i--) {
            yearComboBox.addItem(i);
        }

        TableColumn yearColumn = table.getColumnModel().getColumn(1);
        yearColumn.setCellEditor(new DefaultCellEditor(yearComboBox));

        JComboBox<String> sexBox = new JComboBox<>();
        sexBox.addItem("Macho");
        sexBox.addItem("Fêmea");
        TableColumn sexColumn = table.getColumnModel().getColumn(2);
        sexColumn.setCellEditor(new DefaultCellEditor(sexBox));
        
        return true;
    } else {
        setTableModel(table, new AnimalTableModel(new ArrayList()));
        return false;
    }
}

    
    public static void jRadioButtonEspecieSelecionado(JTable table){
        setTableModel(table, new EspecieTableModel(EspecieDAO.getInstance().retrieveAll()));
    }
    
    public static void jRadioButtonVeterinarioSelecionado(JTable table){
        setTableModel(table, new VeterinarioTableModel(VeterinarioDAO.getInstance().retrieveAll()));
    }
    
    public static void painelConsultasSelected(JTable table) {
        // Set the table model after setting the cell editor
        setTableModel(table, new ConsultaTableModel(ConsultaDAO.getInstance().retrieveAll()));

        JComboBox<String> yearComboBox = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        yearComboBox.addItem(String.valueOf(currentYear));
        yearComboBox.addItem(String.valueOf(currentYear + 1));

        // Adicionar JComboBox à coluna 0
        TableColumn yearColumn = table.getColumnModel().getColumn(2);
        yearColumn.setCellEditor(new DefaultCellEditor(yearComboBox));

        JComboBox<String> monthComboBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(String.valueOf(i));
        }

        // Adicionar JComboBox à coluna 1
        TableColumn monthColumn = table.getColumnModel().getColumn(1);
        monthColumn.setCellEditor(new DefaultCellEditor(monthComboBox));

        JComboBox<String> dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }

        // Adicionar JComboBox à coluna 2
        TableColumn dayColumn = table.getColumnModel().getColumn(0);
        dayColumn.setCellEditor(new DefaultCellEditor(dayComboBox));

        String[] timeSlots = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
        JComboBox<String> timeComboBox = new JComboBox<>(timeSlots);

        // Set the cell editor for a coluna com índice 3
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(timeComboBox));
    }

    public static void updateTabelasConsulta(JTable table, List data) {
        // Set the table model after setting the cell editor
        setTableModel(table, new ConsultaTableModel(data));

        JComboBox<String> yearComboBox = new JComboBox<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        yearComboBox.addItem(String.valueOf(currentYear));
        yearComboBox.addItem(String.valueOf(currentYear + 1));

        // Adicionar JComboBox à coluna 0
        TableColumn yearColumn = table.getColumnModel().getColumn(2);
        yearColumn.setCellEditor(new DefaultCellEditor(yearComboBox));

        JComboBox<String> monthComboBox = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(String.valueOf(i));
        }

        // Adicionar JComboBox à coluna 1
        TableColumn monthColumn = table.getColumnModel().getColumn(1);
        monthColumn.setCellEditor(new DefaultCellEditor(monthComboBox));

        JComboBox<String> dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }

        // Adicionar JComboBox à coluna 2
        TableColumn dayColumn = table.getColumnModel().getColumn(0);
        dayColumn.setCellEditor(new DefaultCellEditor(dayComboBox));

        String[] timeSlots = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
        JComboBox<String> timeComboBox = new JComboBox<>(timeSlots);

        // Set the cell editor for a coluna com índice 3
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(timeComboBox));
    }
    
    public static void setTextFields(JTextField cliente, JTextField animal, JTextField veterinario){
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
        veterinarioSelecionadoTextField = veterinario;
    }
    
    public static void setTableModel(JTable table, GenericTableModel tableModel){
        table.setModel(tableModel);
    }
    
    public static Cliente getClienteSelecionado(){
        return clienteSelecionado;
    }
    
    public static Animal getAnimalSelecionado(){
        return animalSelecionado;
    }
    
    public static Veterinario getVeterinarioSelecionado(){
        return veterinarioSelecionado;
    }
    
    public static void updateHeader(){
        if(clienteSelecionado != null){
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
        }
        if(animalSelecionado != null){
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
        }
        if(veterinarioSelecionado != null){
            veterinarioSelecionadoTextField.setText(veterinarioSelecionado.getNome());
        }
        
    }
    
    public static void setSelected(Object selected){
        if(selected instanceof Cliente){
            clienteSelecionado = (Cliente)selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        }
        else if (selected instanceof Animal){
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
        }
        else if (selected instanceof Veterinario){
            veterinarioSelecionado = (Veterinario)selected;
            veterinarioSelecionadoTextField.setText(veterinarioSelecionado.getNome());
        }
        
        else if (selected instanceof Consulta){
            consultaSelecionado = (Consulta)selected;
        }
    }
    public static void updateHorarioConsulta(String newTime){
        consultaSelecionado.setHorario(newTime);
        ConsultaDAO.getInstance().update(consultaSelecionado);
    }
    public static void updateAvailableTimes(JTable table, JComboBox timeBox) {
    // Obtenha os horários disponíveis
    List<String> horariosDisponiveis = getTimeSlots();

    // Adicione um ItemListener temporário para a JComboBox
    ItemListener temporaryListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // Não faça nada aqui
        }
    };

    timeBox.addItemListener(temporaryListener);

    // Remova temporariamente todos os ItemListeners
    ItemListener[] listeners = timeBox.getItemListeners();
    for (ItemListener listener : listeners) {
        timeBox.removeItemListener(listener);
    }

    // Limpe e adicione os itens
    timeBox.removeAllItems();
    for (String horario : horariosDisponiveis) {
        System.out.println(horario);
        timeBox.addItem(horario);
    }

    // Adicione novamente todos os ItemListeners
    for (ItemListener listener : listeners) {
        timeBox.addItemListener(listener);
    }

    // Remova o ItemListener temporário
    timeBox.removeItemListener(temporaryListener);

    // Desmarque a seleção
    timeBox.setSelectedIndex(-1);
}



    
    public static List getTimeSlots(){
        Veterinario vetSelected = VeterinarioDAO.getInstance().retrieveById(consultaSelecionado.getIdVeterinario());
        Date dataSelected = consultaSelecionado.getData();
        //System.out.println("Veterinario Selecionado: " + vetSelected.getNome());
        // Lista padrão de horários
        String[] horariosPadroes = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};

        // Criar uma lista de horários disponíveis
        List<String> horariosDisponiveis = new ArrayList<>(Arrays.asList(horariosPadroes));

        // Lista de horários ocupados
        List<String> horariosOcupados = ConsultaDAO.getInstance().retrieveHorarioByIdVetAndDate(vetSelected.getId(), dataSelected);
        
        // Remover horários ocupados da lista de horários disponíveis
        horariosDisponiveis.removeAll(horariosOcupados);

        return horariosDisponiveis;
        
        
    }
    
    public static List<Object> getClientsBySimilarName(String nome){
        return ClienteDAO.getInstance().retrieveBySimilarName(nome);
    }
    
    public static List<Object> getVeterinarioBySimilarName(String nome){
        return VeterinarioDAO.getInstance().retrieveBySimilarName(nome);
    }
    
    
    public static void updateDataBySimilarName(JTable table, String nome) {
    if (table.getModel() instanceof ClienteTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(nome));
    } else if (table.getModel() instanceof VeterinarioTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveBySimilarName(nome));
    } else if (table.getModel() instanceof EspecieTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(EspecieDAO.getInstance().retrieveBySimilarName(nome));
    } else if (table.getModel() instanceof AnimalTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(getClienteSelecionado().getId(),nome));
    }
    }
    
    public static void updateDataBySimilarCelular(JTable table, String celular) {
    if (table.getModel() instanceof ClienteTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarCelular(celular));
    } else if (table.getModel() instanceof VeterinarioTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveBySimilarCelular(celular));
    } 
    }
    
    public static void updateEspecieComboBox(JComboBox comboBox){
        comboBox.removeAllItems();
        
        List<Especie> especies = EspecieDAO.getInstance().retrieveAll();
        
        comboBox.addItem("Espécie");
        
        for(Especie especie : especies){
            comboBox.addItem(especie.getNome());
        }
    }
    
   
    public static boolean FiltroAnimalSelecionado(){
        if(getAnimalSelecionado() != null){
            return true;
        }
        else{
            return false;
        }
    }
    
     public static boolean FiltroVetSelecionado(){
        if(getVeterinarioSelecionado() != null){
            return true;
        }
        else{
            return false;
        }
    }
     
     public static boolean filtroAplicadoEmCadastro(JTable table, JTextField nomeFilter, JTextField celularFilter, JTextField emailFilter, JComboBox sexoBox){
         System.out.println("FiltroSeraAplicado");
         if (table.getModel() instanceof ClienteTableModel) {
            String where = " where ";

            boolean addAnd = false;

            if (!"".equals(nomeFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "nome LIKE '%" + nomeFilter.getText() + "%'";
                
                addAnd = true;
                
            }
            
            if (!"".equals(celularFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "telefone LIKE '%" + celularFilter.getText() + "%'";
                addAnd = true;
                
            }
            
            if (!"".equals(emailFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "email LIKE '%" + emailFilter.getText() + "%'";
                addAnd = true;
                
            }
             
            if(!addAnd){
                where = "";
            }
            updateTabelaClientes(table,ClienteDAO.getInstance().retrieveByIdCustomFilter(where));
         }
         else if (table.getModel() instanceof VeterinarioTableModel){
             String where = " where ";

            boolean addAnd = false;

            if (!"".equals(nomeFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "nome LIKE '%" + nomeFilter.getText() + "%'";
                addAnd = true;
                
            }
            
            if (!"".equals(celularFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "telefone LIKE '%" + celularFilter.getText() + "%'";
                addAnd = true;
                
            }
            
            if (!"".equals(emailFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "email LIKE '%" + emailFilter.getText() + "%'";
                addAnd = true;
                
            }
             
            if(!addAnd){
                where = "";
            }
            
            updateTabelaVeterinario(table,VeterinarioDAO.getInstance().retrieveByIdCustomFilter(where));
         }
         else if (table.getModel() instanceof AnimalTableModel){
            String where = " where ";

            boolean addAnd = false;
            
            if (!"".equals(nomeFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "nome LIKE '%" + nomeFilter.getText() + "%'";
                addAnd = true;
                
            }
            
            if (!"Sexo".equals(sexoBox.getSelectedItem())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "sexo LIKE '%" + sexoBox.getSelectedItem() + "%'";
                addAnd = true;
                
            }
            
            if(!addAnd){
                where = "";
                where += " id_cliente = " + getClienteSelecionado().getId();
            }
            else{
                where += " and id_cliente = " + getClienteSelecionado().getId();
            }
            updateTabelaAnimais(table,AnimalDAO.getInstance().retrieveByIdCustomFilter(where));
         }
         else if (table.getModel() instanceof EspecieTableModel){
            String where = " where ";

            boolean addAnd = false;
            
            if (!"".equals(nomeFilter.getText())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += "nome LIKE '%" + nomeFilter.getText() + "%'";
                addAnd = true;
                
            }
            
          
            
            if(!addAnd){
                where = "";
            }
            
            updateTabelaEspecie(table,EspecieDAO.getInstance().retrieveByIdCustomFilter(where));
         }
        return true;
     }
     
     public static boolean filtroAplicado(JTable table, JToggleButton vetFilter, JToggleButton animalFilter, JComboBox diaBox, JComboBox mesBox, JComboBox anoBox){
         if (table.getModel() instanceof ConsultaTableModel) {
            String where = " where ";

            boolean addAnd = false;

            if (vetFilter.isSelected()) {
                if (addAnd) {
                    where += " and ";
                } 
                where += " id_vet = " + getVeterinarioSelecionado().getId();
                addAnd = true;
                
            }
            
            if (animalFilter.isSelected()) {
                if (addAnd) {
                    where += " and ";
                } 
                where += " id_animal = " + getAnimalSelecionado().getId();
                addAnd = true;
                
            }
            
            if (!"Dia".equals(diaBox.getSelectedItem())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += " day(data) = " + diaBox.getSelectedItem();
                addAnd = true;
                
            }

            if (!"Mês".equals(mesBox.getSelectedItem())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += " month(data) = " + mesBox.getSelectedItem();
                addAnd = true;
                
            }

            if (!"Ano".equals(anoBox.getSelectedItem())) {
                if (addAnd) {
                    where += " and ";
                } 
                where += " year(data) = " + anoBox.getSelectedItem();
                addAnd = true;
                
            }
             
            if(!addAnd){
                where = "";
            }
            //((GenericTableModel) table.getModel()).addListOfItems(ConsultaDAO.getInstance().retrieveByIdCustomFilter(where));
            //setTableModel(table, new ConsultaTableModel(ConsultaDAO.getInstance().retrieveByIdCustomFilter(where)));
            updateTabelasConsulta(table,ConsultaDAO.getInstance().retrieveByIdCustomFilter(where));
         }
        return true;
     }
     
    public static Cliente adicionaCliente(String nome, String end, String cep, String email, String telefone){
        return ClienteDAO.getInstance().create(nome, end, cep, email, telefone);
    }
    
    public static Consulta adicionaConsulta(){
        return ConsultaDAO.getInstance().create(Calendar.getInstance().getTime(), "-:--", "", animalSelecionado.getId(), veterinarioSelecionado.getId(), 0, 0);
    }
    
    public static Animal adicionaAnimalAoClienteSelecionado(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        return AnimalDAO.getInstance().create("", currentYear, "Fêmea", 0, 0, clienteSelecionado.getId());
    }
    
    public static Especie adicionaEspecie(){
        return EspecieDAO.getInstance().create("");
    }
    
    public static Veterinario adicionaVeterinario(){
        return VeterinarioDAO.getInstance().create("", "", "");
    }
   
    public static void getAllData(JTable table){
     if (table.getModel() instanceof ClienteTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveAll());
    } else if (table.getModel() instanceof VeterinarioTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveAll());
    } else if (table.getModel() instanceof EspecieTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(EspecieDAO.getInstance().retrieveAll());
    } else if (table.getModel() instanceof AnimalTableModel) {
        ((GenericTableModel) table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveByIdCliente(getClienteSelecionado().getId()));
    }
      
    }
    
    
    
    public static boolean createNewData(JTable table){
        if(table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaCliente("", "", "", "", ""));
        }
        else if(table.getModel() instanceof AnimalTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaAnimalAoClienteSelecionado());
        }
        else if(table.getModel() instanceof EspecieTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaEspecie());
        }
        else if(table.getModel() instanceof VeterinarioTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaVeterinario());
        }
        else if(table.getModel() instanceof ConsultaTableModel){
            if((clienteSelecionado != null) && (animalSelecionado != null) && (veterinarioSelecionado != null)){
                Consulta newConsulta = adicionaConsulta();
                ((GenericTableModel)table.getModel()).addItem(ConsultaDAO.getInstance().retrieveById(newConsulta.getId()));
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    public static void apagaCliente(Cliente cliente){
        List<Animal> animais = AnimalDAO.getInstance().retrieveByIdCliente(getClienteSelecionado().getId());
        for(Animal animal : animais){
            AnimalDAO.getInstance().delete(animal);
        }
        
        ClienteDAO.getInstance().delete(cliente);
    }
    
    public static boolean apagaBtn(JTable table){
        if(table.getSelectedRow() >= 0){
            Object item = ((GenericTableModel) table.getModel()).getItem(table.getSelectedRow());
            ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
            if(table.getModel() instanceof ClienteTableModel){
                apagaCliente(getClienteSelecionado());
                clienteSelecionado = null;
            }
            else if (table.getModel() instanceof AnimalTableModel){
                AnimalDAO.getInstance().delete(animalSelecionado);
                animalSelecionado = null;
            }
            else if (table.getModel() instanceof Veterinario){
                VeterinarioDAO.getInstance().delete(veterinarioSelecionado);
                veterinarioSelecionado = null;
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean apagaConsulta(JTable table){
        if(table.getSelectedRow() >= 0){
            Object item = ((GenericTableModel) table.getModel()).getItem(table.getSelectedRow());
            ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
            ConsultaDAO.getInstance().delete((Consulta)item);
            //TODO: APAGAR TODOS OS EXAMES DAQUELA CONSULTA
            List<Exame> exames = ExameDAO.getInstance().retrieveAllByIdConsulta(((Consulta)item).getId());
            for(Exame e : exames){
                ExameDAO.getInstance().delete(e);
            }
            return true;
        }
        return false;
    }
}
