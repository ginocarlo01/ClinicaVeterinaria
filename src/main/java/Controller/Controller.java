/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author ginoc
 */
public class Controller {
    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado = null;
    private static Veterinario veterinarioSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField veterinarioSelecionadoTextField = null;
    
    public static void jRadioButtonClientesSelecionado(JTable table){
        setTableModel(table, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
    }
    
    public static boolean jRadioButtonAnimalSelecionado(JTable table){
        if(getClienteSelecionado() != null){
            System.out.println(getClienteSelecionado().getId());
            setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByIdCliente(getClienteSelecionado().getId())));
            return true;
        }
        else{
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
    
    public static void painelConsultasSelected(JTable table){
        setTableModel(table, new ConsultaTableModel(ConsultaDAO.getInstance().retrieveAll()));
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
    
    public static Cliente adicionaCliente(String nome, String end, String cep, String email, String telefone){
        return ClienteDAO.getInstance().create(nome, end, cep, email, telefone);
    }
    
    public static Consulta adicionaConsulta(){
        return ConsultaDAO.getInstance().create(Calendar.getInstance().getTime(), "8", "", animalSelecionado.getId(), veterinarioSelecionado.getId(), 0, 0);
    }
    
    public static Animal adicionaAnimalAoClienteSelecionado(){
        return AnimalDAO.getInstance().create("", 0, "", 0, 0, clienteSelecionado.getId());
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
                
                ((GenericTableModel)table.getModel()).addItem(adicionaConsulta());
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
    
    public static void apagaBtn(JTable table){
        if(table.getSelectedRow() >= 0){
            Object item = ((GenericTableModel) table.getModel()).getItem(table.getSelectedRow());
            ((GenericTableModel) table.getModel()).removeItem(table.getSelectedRow());
            if(table.getModel() instanceof ClienteTableModel){
                apagaCliente(getClienteSelecionado());
            }
            else if (table.getModel() instanceof AnimalTableModel){
                AnimalDAO.getInstance().delete(animalSelecionado);
            }
            else if (table.getModel() instanceof Veterinario){
                VeterinarioDAO.getInstance().delete(veterinarioSelecionado);
            }
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
