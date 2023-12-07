package View;

import java.util.List;
import Model.Consulta;
import Model.Animal;
import Model.Exame;
import Model.ConsultaDAO;
import Model.AnimalDAO;
import Model.ClienteDAO;
import Model.VeterinarioDAO;
import Model.ExameDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ginoc
 */
public class ConsultaTableModel extends GenericTableModel {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public ConsultaTableModel(List vDados) {
        super(vDados, new String[]{"Dia", "Mês", "Ano", "Hora", "Cliente", "Animal", "Veterinario", "Obs", "Exame", "Finalizada?"});

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
            case 8:
                return String.class;
            case 9:
                return Boolean.class;  
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);
        Animal animal;
        
        switch (columnIndex) {
            case 0:
                return consulta.getDia();
            case 1:
                return consulta.getMes();
            case 2:
                return consulta.getAno();
            case 3:
                return consulta.getHorario();
            case 4:
                animal = AnimalDAO.getInstance().retrieveById(consulta.getIdAnimal());
                return ClienteDAO.getInstance().retrieveById(animal.getIdCliente()).getNome();
            case 5:
                animal = AnimalDAO.getInstance().retrieveById(consulta.getIdAnimal());
                return animal.getNome();
            case 6:
                return VeterinarioDAO.getInstance().retrieveById(consulta.getIdVeterinario()).getNome();
            case 7:
                return consulta.getComentario();
            case 8:
                Exame exame = ExameDAO.getInstance().retrieveByIdConsulta(consulta.getId());
                if(exame != null){
                   return exame.getNome();
                }
                return ""; 
            case 9:
                return consulta.getTerminado();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }
    
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                
                consulta.setDia((String)aValue);
                break;
            case 1:
                consulta.setMes((String)aValue);
                break;
            case 2:
                consulta.setAno((String)aValue);
            case 3:  
                if (!tryParseInt((String)aValue)) {
                    consulta.setHorario((String)aValue);
                }
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                consulta.setComentario((String)aValue);
                break;
            case 8:
                ExameDAO.getInstance().create((String)aValue, consulta.getId());
                break;
            case 9:
                consulta.setTerminado((boolean)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        ConsultaDAO.getInstance().update(consulta);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if((columnIndex < 3) || (columnIndex > 6)){
            return true;
        }
        else{
            return false;
        }
        
        
    }
}