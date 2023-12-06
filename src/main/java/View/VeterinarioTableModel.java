package View;

import java.util.List;
import Model.Veterinario;
import Model.VeterinarioDAO;

/**
 *
 * @author ginoc
 */
public class VeterinarioTableModel extends GenericTableModel {

    public VeterinarioTableModel(List vDados) {
        super(vDados, new String[]{"Nome", "E-mail", "Telefone", "Ativo"});

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
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return veterinario.getNome();
            case 1:
                return veterinario.getEmail();
            case 2:
                return veterinario.getTelefone();
            case 3:
                return veterinario.getAtivo();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                veterinario.setNome((String) aValue);
                break;
            case 1:
                veterinario.setEmail((String) aValue);
                break;
            case 2:
                veterinario.setTelefone((String) aValue);
                break;
            case 3:
                veterinario.setAtivo((Boolean) aValue);
                break;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }

        VeterinarioDAO.getInstance().update(veterinario);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 3) return false;
        return true;
    }
}