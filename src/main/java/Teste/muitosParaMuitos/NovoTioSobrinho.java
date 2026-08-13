package Teste.muitosParaMuitos;

import Infra.DAO;
import modelo.muitosParaMuitos.Sobrinho;
import modelo.muitosParaMuitos.Tio;

public class NovoTioSobrinho {
    static void main(String[] args) {
        Tio tio1 = new Tio("Rafael");
        Tio tio2 = new Tio("João");

        Sobrinho sobrinho1 = new Sobrinho("Eithor");
        Sobrinho sobrinho2 = new Sobrinho("Ana");

        tio1.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio1);

        tio1.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio1);

        tio2.getSobrinhos().add(sobrinho1);
        sobrinho1.getTios().add(tio2);

        tio2.getSobrinhos().add(sobrinho2);
        sobrinho2.getTios().add(tio2);

        DAO<Object> dao = new DAO<>();
        dao.abrirTransaction()
                .incluir(tio1)
                .incluir(tio2)
                .incluir(sobrinho1)
                .incluir(sobrinho2)
                .fecharTransaction()
                .fechar();
    }
}
