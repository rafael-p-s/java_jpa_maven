package modelo.basico.produto;

import Infra.DAO;

public class NovoProduto {
    static void main(String[] args) {
        DAO<Produto> dao = new DAO<>(Produto.class);

        Produto produto = new Produto("Monitor 23", 789.99);
        dao.incluirAtomico(produto);

    }
}

