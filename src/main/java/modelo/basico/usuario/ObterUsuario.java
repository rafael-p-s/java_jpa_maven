package modelo.basico.usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ObterUsuario {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy_maven");
             EntityManager em = emf.createEntityManager();) {

            Usuario usuario = em.find(Usuario.class, 1L);
            System.out.println("Usuário: " + usuario.getNome());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
