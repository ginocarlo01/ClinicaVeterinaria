package View;

import java.util.List;
import Model.Animal;
import Model.AnimalDAO;
import Model.Especie;
import Model.EspecieDAO;

/**
 *
 * @author ginoc
 */
public class EspecieTableModel extends GenericTableModel {

    public EspecieTableModel(List vDados) {
        super(vDados, new String[]{"Nome"});

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Especie especie = (Especie) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return especie.getNome();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Especie especie = (Especie) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                especie.setNome((String) aValue);
                break;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        EspecieDAO.getInstance().update(especie);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}