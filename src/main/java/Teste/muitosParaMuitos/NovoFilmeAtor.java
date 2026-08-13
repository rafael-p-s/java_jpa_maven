package Teste.muitosParaMuitos;

import Infra.DAO;
import modelo.muitosParaMuitos.Ator;
import modelo.muitosParaMuitos.Filme;

public class NovoFilmeAtor {
    static void main(String[] args) {
        Filme filmeA = new Filme("Star wars ep4", 8.9);
        Filme filmeB= new Filme("O Fugitivo", 8.1);

        Ator atorA = new Ator("Harrison Ford");
        Ator atorB = new Ator("Carrie Fisher");

        filmeA.adicionarAtor(atorA);
        filmeA.adicionarAtor(atorB);

        filmeB.adicionarAtor(atorA);

        DAO<Filme> dao = new DAO<>(Filme.class);
        dao.incluirAtomico(filmeA);

    }
}
