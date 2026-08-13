package Teste.umparaum;

import Infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class ObterClienteAssento {
    static void main(String[] args) {
        DAO<Cliente> daoCliente = new DAO<>(Cliente.class);

        Cliente cliente = daoCliente.obterID(1L);
        System.out.println("Assento: " + cliente.getId() + " Nome: " + cliente.getAssento().getNome());
        daoCliente.fechar();

        DAO<Assento> daoAssento = new DAO<>(Assento.class);
        Assento assento = daoAssento.obterID(2L);
        System.out.println("Assento: " + assento.getNome() + " Nome: " + assento.getCliente().getNome());
        daoAssento.fechar();

    }
}