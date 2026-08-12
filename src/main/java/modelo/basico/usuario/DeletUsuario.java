package modelo.basico.usuario;

import jakarta.persistence.*;

import java.util.List;

public class DeletUsuario {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy_maven");
             EntityManager em = emf.createEntityManager()) {

            // Select
            selectUsuario(em);

            // Delet
            deletUsuario(em);

            // Select
            selectUsuario(em);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectUsuario(EntityManager em) {
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

        List<Usuario> usuarios = query.getResultList();

        for (Usuario usuario : usuarios) {
            System.out.println("Código: " + usuario.getId() + " Nome: " + usuario.getNome() + " Email: " + usuario.getEmail());
        }
        System.out.print("");
    }

    public static void deletUsuario(EntityManager em) {
        em.getTransaction().begin();

        String jpqlDelete = "Delete from Usuario u where u.id = :idUsuario";
        Query query = em.createQuery(jpqlDelete);
        query.setParameter("idUsuario", 4);

        int linhasAfetadass = query.executeUpdate();

        if (linhasAfetadass == 0) {
            System.out.println("Usuário não existe, necessário verificar!");
        } else {
            System.out.println("Usuário deletado com sucesso!");
        }

        em.getTransaction().commit();

        System.out.println("Deletado com sucesso!");
        System.out.print("");
    }
}

/*
Query query = em.createQuery(jpqlDelete);
int linhas = query.executeUpdate();

Aqui não existe "molde" nenhum porque não há objeto sendo devolvido.
Um DELETE/UPDATE não gera uma lista de Usuario — ele só informa quantas linhas foram afetadas.
Como não tem o que tipar, o retorno é o Query genérico (a interface "mãe", sem o parâmetro de tipo),
e o método que você chama é outro (executeUpdate() em vez de getResultList()).

Resumindo a régua mental:

-Query devolve entidades? → createQuery(jpql, Classe.class) → TypedQuery<T> →
getResultList() / getSingleResult()

-Query só faz uma ação (DELETE/UPDATE) e devolve um número? → createQuery(jpql) → Query → executeUpdate()
 */