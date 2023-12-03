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
        super(vDados, new String[]{"Data", "Hora", "Cliente", "Animal", "Veterinario", "Obs", "Exame", "Finalizada?"});

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return Date.class;
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
                return consulta.getData();
            case 1:
                return consulta.getHorario();
            case 2:
                animal = AnimalDAO.getInstance().retrieveById(consulta.getIdAnimal());
                return ClienteDAO.getInstance().retrieveById(animal.getIdCliente()).getNome();
            case 3:
                animal = AnimalDAO.getInstance().retrieveById(consulta.getIdAnimal());
                return animal.getNome();
            case 4:
                return VeterinarioDAO.getInstance().retrieveById(consulta.getIdVeterinario()).getNome();
            case 5:
                return consulta.getComentario();
            case 6:
                Exame exame = ExameDAO.getInstance().retrieveByIdConsulta(consulta.getId());
                if(exame != null){
                   return exame.getNome();
                }
                return ""; 
            case 7:
                return consulta.getTerminado();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                try {
                    Date date = dateFormat.parse((String) aValue);
                    consulta.setData(date);
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case 1:  
                consulta.setHorario((String)aValue);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                consulta.setComentario((String)aValue);
                break;
            case 6:
                ExameDAO.getInstance().create((String)aValue, consulta.getId());
                break;
            case 7:
                consulta.setTerminado((boolean)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        ConsultaDAO.getInstance().update(consulta);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if((columnIndex < 2) || (columnIndex > 4)){
            return true;
        }
        else{
            return false;
        }
        
        
    }
}