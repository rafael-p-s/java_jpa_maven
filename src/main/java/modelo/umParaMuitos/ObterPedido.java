package modelo.umParaMuitos;

import Infra.DAO;

public class ObterPedido {
    static void main(String[] args) {
        DAO<Pedidos> dao = new DAO<>(Pedidos.class);

        // Essa aqui só pega a informação.
        Pedidos pedidos = dao.obterID(3L);

        // essa segunda parte, pedidos.getItens(), é que faz a consulta.
        for (ItemPedido itemPedido : pedidos.getItens()) {
            System.out.println(itemPedido.getQuantidade());
        }

        dao.fechar();

    }
}
