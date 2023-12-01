package View;

import java.util.List;
import Model.Consulta;
import Model.Animal;
import Model.AnimalDAO;
import Model.ClienteDAO;
import Model.VeterinarioDAO;
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
        super(vDados, new String[]{"Data", "Hora", "Cliente", "Animal", "Veterinario", "Obs", "Fim"});

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
                return int.class;  
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
                Calendar cal = Calendar.getInstance();
                try{
                    cal.setTime(dateFormat.parse((String)aValue));
                }
                catch(ParseException ex){
                    Logger.getLogger(ConsultaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                consulta.setData(cal);
                break;
            case 1:
                animal.setAnoNasc((Integer) aValue);
                break;
            case 2:
                animal.setSexo((String) aValue);
                break;
            case 3:
                Especie species = EspecieDAO.getInstance().retrieveByName((String) aValue);
                if (species == null) {
                    species = EspecieDAO.getInstance().create((String) aValue);
                    animal.setIdEspecie(species.getId());
                    
                } else {
                    animal.setIdEspecie(species.getId());
                }
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        AnimalDAO.getInstance().update(animal);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}