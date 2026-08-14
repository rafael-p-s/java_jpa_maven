package Teste.desafio;

import Infra.DAO;
import modelo.composicao.Gerente;
import modelo.composicao.Vendedor;

import java.util.List;

public class ObterFuncionarios {
    static void main(String[] args) {
        DAO<Gerente> daoG = new DAO<>(Gerente.class);
        DAO<Vendedor> daoV = new DAO<>(Vendedor.class);

        List<Gerente> gerente = daoG.ObterTodos();
        List<Vendedor> vendedores = daoV.ObterTodos();

        for (Gerente gerente1 : gerente) {
            System.out.println("Nome: " + gerente1.getNome() +
                    " Salario: " + gerente1.getSalario());
        }

        for (Vendedor vendedor1 : vendedores) {
            System.out.println("Nome: " + vendedor1.getNome() +
                    " Salario: " + vendedor1.getSalario() +
                    " Bonificação: " + vendedor1.getValorBonificacao() +
                    " Comissão: " + vendedor1.getComissao());
        }

        daoG.fechar();
        daoV.fechar();
    }
}
