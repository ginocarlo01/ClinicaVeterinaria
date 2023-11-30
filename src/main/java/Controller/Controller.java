/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.EspecieDAO;
import Model.VeterinarioDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.AnimalDAO;
import Model.Animal;
import View.EspecieTableModel;
import View.VeterinarioTableModel;
import View.GenericTableModel;
import View.ClienteTableModel;
import View.AnimalTableModel;
import java.util.ArrayList;
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
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    
    public static void jRadioButtonClientesSelecionado(JTable table){
        setTableModel(table, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
    }
    
    public static boolean jRadioButtonAnimalSelecionado(JTable table){
        if(getClienteSelecionado() != null){
            setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByIdCliente(Controller.getClienteSelecionado().getId())));
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
    
    public static void setTextFields(JTextField cliente, JTextField animal){
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
    }
    
    public static void setTableModel(JTable table, GenericTableModel tableModel){
        table.setModel(tableModel);
    }
    
    public static Cliente getClienteSelecionado(){
        return clienteSelecionado;
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
        ((GenericTableModel) table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(nome));
    }
    }
    
    public static Cliente adicionaCliente(String nome, String end, String cep, String email, String telefone){
        return ClienteDAO.getInstance().create(nome, end, cep, email, telefone);
    }

}
