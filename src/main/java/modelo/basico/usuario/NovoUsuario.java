package modelo.basico.usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NovoUsuario {
    static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy_maven");
        EntityManager em = emf.createEntityManager();){
            Usuario novoUsuario = new Usuario("teste", "teste@teste.com.br");

            em.getTransaction().begin(); // irá começar o processo de criação
            em.persist(novoUsuario); // irá criar o novo usuário;
            em.getTransaction().commit(); // irá finalizar a criação.
            System.out.println("Usuario adicionado com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
