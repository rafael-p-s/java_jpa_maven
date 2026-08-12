package modelo.basico.produto;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produtos")
// schema = "curso_java" ->schema serve para informar o banco que vai usar isso. Não e´muito usado
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(nullable = false, scale = 2)
    private Double preco;

    // Construtor Padrão
    public Produto() {

    }

    public Produto(String nome, Double preco) {
        super();
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
