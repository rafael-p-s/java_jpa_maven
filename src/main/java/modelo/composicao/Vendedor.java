package modelo.composicao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedor extends Funcionario2 {
    private Double valorBonificacao;
    private Double comissao;

    public Vendedor() {
    }

    public Vendedor(String nome, Double salario, Double valorBonificacao, Double comissao) {
        super(nome, salario);
        this.valorBonificacao = valorBonificacao;
        this.comissao = comissao;
    }

    public Double getValorBonificacao() {
        return valorBonificacao;
    }

    public void setValorBonificacao(Double valorBonificacao) {
        this.valorBonificacao = valorBonificacao;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
}
