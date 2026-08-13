package Teste.umParaMuitos;

import Infra.DAO;
import modelo.basico.produto.Produto;
import modelo.umParaMuitos.ItemPedido;
import modelo.umParaMuitos.Pedidos;

public class NovoPedido {
    static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        Pedidos pedidos = new Pedidos();
        Produto produto = new Produto("Geladeira", 2789.99);
        ItemPedido item = new ItemPedido(pedidos, produto, 10);

        dao.abrirTransaction()
                .incluir(produto)
                .incluir(pedidos)
                .incluir(item)
                .fecharTransaction()
                .fechar();
    }
}
