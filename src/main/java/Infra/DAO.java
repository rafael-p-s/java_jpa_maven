package Infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAO<E> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    // Quando a classe for carregada ele irá carregar aqui primeiro, necessário cuidado.
    static {
        try {
            emf = Persistence
                    .createEntityManagerFactory("udemy_maven");
        } catch (Exception e) {
            // logar -> log4j -> api para ajudar a criar logs de inicialização
            e.printStackTrace();
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    /*
    Retorna a própria classe.
    public DAO<E> teste() {
        return this;
    }*/

    public DAO<E> abrirTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    // Incluir Geral
    public DAO<E> incluirAtomico(E entidade) {
        return this.abrirTransaction().incluir(entidade).fecharTransaction();
    }

    // Vai servir para buscar informações no banco, porém exibir com limite na tela
    public List<E> obterTodosRegistros(int qtde, int deslocamento) {
        if (classe == null) {
            throw new UnsupportedOperationException("Null Class");
        }

        String jpql = "select e from " + classe.getName() + " e"; // sempre precisa desse "e" no final
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    // Buscar Cliente específico
    public E obterID(Object id) {
        return em.find(classe, id);
    }

    // Caso eu queria passar tudo, sem tratamento de tamanho a ser passado
    public List<E> ObterTodos() {
        return this.obterTodosRegistros(10, 0);
    }

    // Aqui só fechar o Manager
    // Não será fechado o EntityManagerFactory pois ele está como static
    public void fechar() {
        em.close();
    }

    public List<E> consultar(String nomeConsulta, Object... params) {
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }
}
