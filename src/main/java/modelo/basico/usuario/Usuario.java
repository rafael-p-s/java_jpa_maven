package modelo.basico.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Usando @Entity, ele passa a informação que o nome da Classe é o mesmo do Banco
@Entity
public class Usuario {
    // Dessa forma com @ID informo que o ID é a Primary Key
    // @GeneratedValue, irá criar o ID automaticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // por padrão o hibernat vai criar como padrão Varchar

    private String email;

    public Usuario() {
        // exigido pelo JPA/Hibernate
    }

    public Usuario(String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
