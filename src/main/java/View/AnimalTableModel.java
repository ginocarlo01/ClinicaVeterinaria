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
public class AnimalTableModel extends GenericTableModel {

    public AnimalTableModel(List vDados) {
        super(vDados, new String[]{"Nome", "Ano de nascimento", "Sexo", "Espécie", "Ativo"});

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getAnoNasc();
            case 2:
                return animal.getSexo();

            case 3:
                Especie species = EspecieDAO.getInstance().retrieveById(animal.getIdEspecie());
                if (species != null) {
                    return species.getNome();
                }
                return "";
            case 4:
                return animal.getAtivo();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                animal.setNome((String) aValue);
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
            case 4:
                animal.setAtivo((Boolean) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        AnimalDAO.getInstance().update(animal);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 4) return false;
        return true;
    }
}