package Model;

/**
 *
 * @author Plinio Vilela
 */
public class Especie {
    private int id;
    private String nome;

    public Especie(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Especie{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
