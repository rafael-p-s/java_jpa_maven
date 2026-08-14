package Teste.desafio;

import Infra.DAO;
import modelo.composicao.Gerente;
import modelo.composicao.Vendedor;

public class NovoFuncionario {
    static void main(String[] args) {
        Gerente gerente1 = new Gerente("Rafael", 12000.00);
        Vendedor vendedor1 = new Vendedor("Eithor", 2500.00, 250.00, 100.00);

        DAO<Gerente> daoG = new DAO<>(Gerente.class);
        DAO<Vendedor> daoV = new DAO<>(Vendedor.class);

        daoG.incluirAtomico(gerente1);
        daoV.incluirAtomico(vendedor1);

        daoG.fechar();
        daoV.fechar();
    }
}
