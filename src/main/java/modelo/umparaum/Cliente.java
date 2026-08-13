package modelo.umparaum;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    /*
    // Essa forma está errada, pois está usando SQL dentro do OOP do java
    @Column(name = "assento_id")
    private Long assentoId;
    */

    // Esse é o relacionamento 1 para 1
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "assento_id", unique = true) // garante ter 1 assento e garante ñ ter 2 clientes no mesmo assento
    private Assento assento;

    public Cliente() {
    }

    public Cliente(String nome, Assento assento) {
        this.nome = nome;
        this.assento = assento;
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

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }
}
