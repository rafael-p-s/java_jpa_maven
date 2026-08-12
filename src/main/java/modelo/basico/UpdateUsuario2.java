package modelo.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateUsuario2 {
    static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy_maven");
             EntityManager em = emf.createEntityManager();) {

            em.getTransaction().begin();
            // Vou informar qual ID quero pegar
            Usuario usuario = em.find(Usuario.class, 1);
            System.out.println("Pego Usuario: " + usuario.getId() + " Nome: " + usuario.getNome() + " Email: " + usuario.getEmail());

            usuario.setNome("Leonardo Alterado");
            usuario.setEmail("leonardo@uol.com");

            /*em.merge(usuario);*/

            em.getTransaction().commit();
            System.out.println("Usuario atualizado com sucesso!");
            System.out.println("Pego Usuario: " + usuario.getId() + " Nome: " + usuario.getNome() + " Email: " + usuario.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
