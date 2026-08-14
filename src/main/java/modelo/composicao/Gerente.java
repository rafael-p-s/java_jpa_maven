package modelo.composicao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gerente")
public class Gerente extends Funcionario2 {

    public Gerente() {
    }

    public Gerente(String nome, Double salario) {
        super(nome, salario);
    }
}
