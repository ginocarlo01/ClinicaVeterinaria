package Model;
import java.util.Date;

public class Veterinario {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private Boolean ativo;

    public Veterinario(int id, String nome, String email, String telefone, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
