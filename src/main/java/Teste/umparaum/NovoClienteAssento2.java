package Teste.umparaum;

import Infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class NovoClienteAssento2 {
    static void main(String[] args) {
        Assento assento = new Assento("4D");
        Cliente cliente = new Cliente("Rafael", assento);

        // Por não fazer consulta não precisa passar nada dentro dos ()
        DAO<Cliente> dao = new DAO<>();

        dao.incluirAtomico(cliente);

    }
}
