package Teste.consulta;

import Infra.DAO;
import modelo.muitosParaMuitos.Ator;
import modelo.muitosParaMuitos.Filme;

import java.util.List;

public class ObterFilmes {
    static void main(String[] args) {
        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.consultar("obterFilmesNotaMaiorQue", "nota", 8.5);
        for (Filme filme : filmes) {
            System.out.println(filme.getTitulo() + " ==> " + filme.getNota());
            for (Ator ator : filme.getAtores()) {
                System.out.println(ator.getNome());
            }
        }
    }
}
