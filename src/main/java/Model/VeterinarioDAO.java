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
public class VeterinarioDAO extends DAO {
    private static VeterinarioDAO instance;

    private VeterinarioDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static VeterinarioDAO getInstance() {
        return (instance==null?(instance = new VeterinarioDAO()):instance);
    }

// CRUD    
    public Veterinario create(String nome, String email, String telefone, Boolean ativo) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO vet (nome, email, telefone, ativo) VALUES (?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.setBoolean(4, ativo);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("vet","id"));
    }
    

    private Veterinario buildObject(ResultSet rs) {
        Veterinario vet = null;
        try {
            vet = new Veterinario(rs.getInt("id"), rs.getString("nome"),rs.getString("email"), rs.getString("telefone"), rs.getBoolean("ativo"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return vet;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Veterinario> vets = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                vets.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return vets;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM vet");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM vet WHERE id = " + lastId("vet","id"));
    }

    // RetrieveById
    public Veterinario retrieveById(int id) {
        
        List<Veterinario> vets = this.retrieve("SELECT * FROM vet WHERE id = " + id);
        return (vets.isEmpty()?null:vets.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM vet WHERE nome LIKE '%" + nome + "%'");
    }    
    
    public List retrieveBySimilarCelular(String celular) {
        return this.retrieve("SELECT * FROM vet WHERE telefone LIKE '%" + celular + "%'");
    }   
    
    public List retrieveBySimilarEmail(String email) {
        return this.retrieve("SELECT * FROM vet WHERE email LIKE '%" + email + "%'");
    }  
    
    public List retrieveByIdCustomFilter(String filter){
        return this.retrieve("SELECT * FROM vet" + filter);
    }
        
    public void update(Veterinario vet) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE vet SET nome=?, email=?, telefone=?, ativo=? WHERE id=?");
            stmt.setString(1, vet.getNome());
            stmt.setString(2, vet.getEmail());
            stmt.setString(3, vet.getTelefone());
            stmt.setBoolean(4, vet.getAtivo());
            stmt.setInt(5, vet.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    // Delete   
    public void delete(Veterinario vet) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM vet WHERE id = ?");
            stmt.setInt(1, vet.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
