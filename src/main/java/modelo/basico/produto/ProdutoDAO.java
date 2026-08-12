package modelo.basico.produto;

import Infra.DAO;

public class ProdutoDAO extends DAO<Produto> {
    public ProdutoDAO() {
        super(Produto.class);
    }
}
