package Model;
import java.util.Date;

public class Consulta {
    private int id;
    private Date data;
    private String horario;
    private String comentario;
    private int id_animal;
    private int id_vet;
    private int id_tratamento;
    private int terminado;

    public Consulta(int id, Date data, String horario, String comentario, int id_animal, int id_vet, int id_tratamento, int terminado) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.comentario = comentario;
        this.id_animal = id_animal;
        this.id_vet = id_vet;
        this.id_tratamento = id_tratamento;
        this.terminado = terminado;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdAnimal() {
        return id_animal;
    }

    public void setIdAnimal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getIdVeterinario() {
        return id_vet;
    }

    public void setIdVeterinario(int id_vet) {
        this.id_vet = id_vet;
    }

    public int getIdTratamento() {
        return id_tratamento;
    }

    public void setIdTratamento(int id_tratamento) {
        this.id_tratamento = id_tratamento;
    }

    public int getTerminado() {
        return terminado;
    }

    public void setTerminado(int terminado) {
        this.terminado = terminado;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", data=" + data +
                ", horario='" + horario + '\'' +
                ", comentario='" + comentario + '\'' +
                ", id_animal=" + id_animal +
                ", id_vet=" + id_vet +
                ", id_tratamento=" + id_tratamento +
                ", terminado=" + terminado +
                '}';
    }
}
