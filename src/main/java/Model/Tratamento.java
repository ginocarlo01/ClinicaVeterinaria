package Model;
import java.util.Date;

public class Tratamento {
    private int id;
    private Date dataFinalTratamento;
    private Date dataInicialTratamento;

    public Tratamento(int id, Date dataInicialTratamento, Date dataFinalTratamento) {
        this.id = id;
        this.dataInicialTratamento = dataInicialTratamento;
        this.dataFinalTratamento = dataFinalTratamento;
    }

    public int getId() {
        return id;
    }

    public Date getDataInicialTratamento() {
        return dataInicialTratamento;
    }

    public void setDataInicialTratamento(Date dataInicialTratamento) {
        this.dataInicialTratamento = dataInicialTratamento;
    }

    public Date getDataFinalTratamento() {
        return dataFinalTratamento;
    }

    public void setDataFinalTratamento(Date dataFinalTratamento) {
        this.dataFinalTratamento = dataFinalTratamento;
    }

    @Override
    public String toString() {
        return "Tratamento{" +
                "id=" + id +
                ", dataInicialTratamento=" + dataInicialTratamento +
                ", dataFinalTratamento=" + dataFinalTratamento +
                '}';
    }
}
