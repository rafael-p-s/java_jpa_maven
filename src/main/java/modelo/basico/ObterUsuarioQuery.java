package modelo.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ObterUsuarioQuery {
    static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy_maven");
             EntityManager em = emf.createEntityManager();) {

            // Esse "Usuario" não é a tabela, mas sim a Classe que vamos estar usando
            String jpql = "select u from Usuario u";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setMaxResults(5); // Essa busca não limita, mas usando essa linha ele me passa só a qtd informada.

            List<Usuario> usuarios = query.getResultList(); // Aqui efetiva a consulta e coloca dentro de usuários

            for (Usuario usuario : usuarios) {
                System.out.println("Código: " + usuario.getId() + " Nome: " + usuario.getNome() + " Email: " + usuario.getEmail());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
