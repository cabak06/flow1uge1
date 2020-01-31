
package entity;

import java.time.Instant;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityTested {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Customer c1 = new Customer("Niels","Bohr");
        Customer c2 = new Customer("Albert","Einstein");
        Customer c3 = new Customer("Stephen","Hawkings");
        Customer c4 = new Customer("Leonardo","Davinci");
        
        try{
         
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.getTransaction().commit();
            
            
        }finally{
        
            em.close();
        }
        
    }


    
}
