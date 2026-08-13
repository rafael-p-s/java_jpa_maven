package Teste.umparaum;

import Infra.DAO;
import modelo.umparaum.Assento;
import modelo.umparaum.Cliente;

public class NovoClienteAssento1 {
    static void main(String[] args) {
        /*
         * Como o assento está dentro de cliente,
         * vou precisar então criar primeiro o Assento
         * para depois criar Cliente.
         * Para que o ID do Assento conste em Cliente.
         * */
        Assento assento = new Assento("16C");
        Cliente cliente = new Cliente("Ana", assento);

        DAO<Object> dao = new DAO<>();

        /*
        * Mas caso a ordem seja CLiente 1°
        * para depois vir Assento,
        * o próprio Hibernate faz a alteração depois,
        * PORÉM é um processo a mais que ele precisa fazer
        * caso seja mantido na ordem correta é menos processamento.
        * */
        dao.abrirTransaction()
                .incluir(assento)
                .incluir(cliente)
                .fecharTransaction()
                .fechar();

        /*
        * Mas caso seja feito em transações diferentes:
        * dao.abrirTransaction()
                .incluir(cliente)
                .fecharTransaction()
                .fechar();
          dao.abrirTransaction()
                .incluir(assento)
                .fecharTransaction()
                .fechar();

         * Irá dar erro.
        * */
    }
}
