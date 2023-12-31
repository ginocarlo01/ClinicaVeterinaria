package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author Plinio Vilela
 */
public class ConsultaDAO extends DAO {
    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static ConsultaDAO getInstance() {
        return (instance==null?(instance = new ConsultaDAO()):instance);
    }

// CRUD    
    public Consulta create(Date data, String horario, String comentario, int id_animal, int id_vet, int id_tratamento, boolean terminado) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (data, horario, comentario, id_animal, id_vet, id_tratamento, terminado) VALUES (?,?,?,?,?,?,?)");
            java.sql.Date sqlDate = new java.sql.Date(data.getTime());

            stmt.setDate(1, sqlDate);
            stmt.setString(2, horario);
            stmt.setString(3, comentario);
            stmt.setInt(4, id_animal);
            stmt.setInt(5, id_vet);
            stmt.setInt(6, id_tratamento);
            stmt.setBoolean(7, terminado);
            
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consulta","id"));
    }
    

    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            consulta = new Consulta(rs.getInt("id"),rs.getDate("data"), rs.getString("horario"), rs.getString("comentario"), rs.getInt("id_animal"), rs.getInt("id_vet"), rs.getInt("id_tratamento"), rs.getBoolean("terminado"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta order by data, horario");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consulta WHERE id = " + lastId("consulta","id"));
    }

    // RetrieveById
    public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE id = " + id);
        return (consultas.isEmpty()?null:consultas.get(0));
    }
    
    
    
   
    public List<String> retrieveHorarioByIdVetAndDate(int id_vet, Date data) {
    java.sql.Date sqlData = new java.sql.Date(data.getTime());
    List<String> horarios = new ArrayList<>();
    
    ResultSet rs = getResultSet("SELECT horario FROM consulta WHERE id_vet = " + id_vet + " AND data = '" + sqlData + "'");
    
    try {
        while (rs.next()) {
            horarios.add(rs.getString("horario"));
        }
    } catch (SQLException e) {
        System.err.println("Exception: " + e.getMessage());
    }
    
    return horarios;
}
    
    public List retrieveByIdCustomFilter(String filter){
        return this.retrieve("SELECT * FROM consulta" + filter);
    }
    
    public List retrieveByIdVet(int id_vet) {
        return this.retrieve("SELECT * FROM consulta WHERE id_vet = " + id_vet);
    }    
    
    public List retrieveByIdAnimal(int id_animal) {
        return this.retrieve("SELECT * FROM consulta WHERE id_animal = " + id_animal);
    } 

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM consulta WHERE nome LIKE '%" + nome + "%'");
    }    
        
    // Updade
    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET data=?, horario=?, comentario=?, id_animal=?, id_vet=?, id_tratamento=?, terminado=? WHERE id=?");
            
            java.sql.Date sqlData = new java.sql.Date(consulta.getData().getTime());
            stmt.setDate(1, sqlData);
            stmt.setString(2, consulta.getHorario());
            stmt.setString(3, consulta.getComentario());
            stmt.setInt(4, consulta.getIdAnimal());
            stmt.setInt(5, consulta.getIdVeterinario());
            stmt.setInt(6, consulta.getIdTratamento());
            stmt.setBoolean(7, consulta.getTerminado());
            stmt.setInt(8, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    // Delete   
    public void delete(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
