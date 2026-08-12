package modelo.basico.produto;

import java.util.List;

public class ObterProduto {
    static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.ObterTodos();

        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() +
                    " NOME: " + produto.getNome() +
                    " Preço: " + produto.getPreco());
        }

    }
}
