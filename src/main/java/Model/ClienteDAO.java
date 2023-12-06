package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Plinio Vilela
 */
public class ClienteDAO extends DAO {
    private static ClienteDAO instance;

    private ClienteDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static ClienteDAO getInstance() {
        return (instance==null?(instance = new ClienteDAO()):instance);
    }

// CRUD    
    public Cliente create(String nome, String end, String cep, String email, String telefone, Boolean ativo) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO cliente (nome, endereco, cep, email, telefone, ativo) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, end);
            stmt.setString(3, cep);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            stmt.setBoolean(6, ativo);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("cliente","id"));
    }
    

    private Cliente buildObject(ResultSet rs) {
        Cliente cliente = null;
        try {
            int id = rs.getInt("id");
            cliente = new Cliente(id, rs.getString("nome"), rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("telefone"), rs.getBoolean("ativo"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }

        return cliente;
    }


    // Generic Retriever
    public List retrieve(String query) {
        List<Cliente> clientes = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                clientes.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return clientes;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM cliente");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM cliente WHERE id = " + lastId("cliente","id"));
    }

    // RetrieveById
    public Cliente retrieveById(int id) {
        List<Cliente> clientes = this.retrieve("SELECT * FROM cliente WHERE id = " + id);
        return (clientes.isEmpty()?null:clientes.get(0));
    }

     public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM cliente WHERE nome LIKE '%" + nome + "%'");
    }    
     
    public List retrieveBySimilarCelular(String celular) {
        return this.retrieve("SELECT * FROM cliente WHERE telefone LIKE '%" + celular + "%'");
    }  
    
    public List retrieveBySimilarEmail(String email) {
        return this.retrieve("SELECT * FROM cliente WHERE email LIKE '%" + email + "%'");
    } 
    
    public List retrieveByIdCustomFilter(String filter){
        return this.retrieve("SELECT * FROM cliente" + filter);
    }
        
    public void update(Cliente cliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE cliente SET nome=?, endereco=?, cep=?, email=?, telefone=?, ativo=? WHERE id=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setBoolean(6, cliente.getAtivo());
            stmt.setInt(7, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    // Delete   
    public void delete(Cliente cliente) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM cliente WHERE id = ?");
            stmt.setInt(1, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
