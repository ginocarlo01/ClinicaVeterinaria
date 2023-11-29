package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author Plinio Vilela
 */
public class TratamentoDAO extends DAO {
    private static TratamentoDAO instance;

    private TratamentoDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static TratamentoDAO getInstance() {
        return (instance==null?(instance = new TratamentoDAO()):instance);
    }

// CRUD    
    public Tratamento create(Date dataInicialTratamento, Date dataFinalTratamento) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO tratamento (dataInicialTratamento, dataFinalTratamento) VALUES (?,?)");
            java.sql.Date sqlDataFinalTratamento = new java.sql.Date(dataInicialTratamento.getTime());
            java.sql.Date sqlDataInicialTratamento = new java.sql.Date(dataFinalTratamento.getTime());

            stmt.setDate(1, sqlDataFinalTratamento);
            stmt.setDate(2, sqlDataInicialTratamento);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("tratamento","id"));
    }
    

    private Tratamento buildObject(ResultSet rs) {
        Tratamento tratamento = null;
        try {
            tratamento = new Tratamento(rs.getInt("id"), rs.getDate("dataFinalTratamento"), rs.getDate("dataInicialTratamento"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamento;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Tratamento> tratamentos = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                tratamentos.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return tratamentos;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM tratamento");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM tratamento WHERE id = " + lastId("tratamento","id"));
    }

    // RetrieveById
    public Tratamento retrieveById(int id) {
        List<Tratamento> tratamentos = this.retrieve("SELECT * FROM tratamento WHERE id = " + id);
        return (tratamentos.isEmpty()?null:tratamentos.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM tratamento WHERE nome LIKE '%" + nome + "%'");
    }    
        
    // Updade
public void update(Tratamento tratamento) {
    try {
        PreparedStatement stmt;
        stmt = DAO.getConnection().prepareStatement("UPDATE tratamento SET dataInicialTratamento=?, dataFinalTratamento=? WHERE id=?");
        
        // Converter as datas de java.util.Date para java.sql.Date
        java.sql.Date sqlDataInicialTratamento = new java.sql.Date(tratamento.getDataInicialTratamento().getTime());
        java.sql.Date sqlDataFinalTratamento = new java.sql.Date(tratamento.getDataFinalTratamento().getTime());

        stmt.setDate(1, sqlDataInicialTratamento);
        stmt.setDate(2, sqlDataFinalTratamento);
        stmt.setInt(3, tratamento.getId());

        executeUpdate(stmt);
    } catch (SQLException e) {
        System.err.println("Exception: " + e.getMessage());
    }
}

    
    // Delete   
    public void delete(Tratamento tratamento) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM tratamento WHERE id = ?");
            stmt.setInt(1, tratamento.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

}
