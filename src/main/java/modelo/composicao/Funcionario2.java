package modelo.composicao;

import jakarta.persistence.*;

@Entity
@Table(name = "Funcionarios2")
@Inheritance(strategy = InheritanceType.JOINED) // informa que é a tabela PAI para Herança
public class Funcionario2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Double salario;

    public Funcionario2() {}

    public Funcionario2(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
