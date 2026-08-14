package Teste.consulta;

import Infra.DAO;
import modelo.consulta.NotaFilme;
import modelo.muitosParaMuitos.Filme;

public class ObterMediaFilmes {
    static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<NotaFilme>(NotaFilme.class);
        NotaFilme nota = dao.consultarUm("obterMediaGeral");
        System.out.println(nota.getMedia());

        dao.fechar();

    }
}
