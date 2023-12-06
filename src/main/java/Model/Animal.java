package Model;

/**
 *
 * @author Gino Grippo
 */
public class Animal {
    private int id;
    private String nome;
    private int anoNasc;
    private String sexo;
    private int id_especie;
    private int id_tratamento;
    private int id_cliente;
    private Boolean ativo;

    public Animal(int id, String nome, int anoNasc, String sexo, int id_especie, int id_cliente, int id_tratamento, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.sexo = sexo;
        this.id_especie = id_especie;
        this.id_cliente = id_cliente;
        this.id_tratamento = id_tratamento;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public Boolean getAtivo() {
        return ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdEspecie() {
        return id_especie;
    }

    public void setIdEspecie(int id_especie) {
        this.id_especie = id_especie;
    }

    public int getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getIdTratamento() {
        return id_tratamento;
    }

    public void setIdTratamento(int id_tratamento) {
        this.id_tratamento = id_tratamento;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoNasc=" + anoNasc +
                ", sexo='" + sexo + '\'' +
                ", id_especie=" + id_especie +
                ", id_cliente=" + id_cliente +
                ", id_tratamento=" + id_tratamento +
                '}';
    }
}
