
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cahit
 */
public class MakeTestData {
    
    
    public static void main(String[] args) {
        
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
     EntityManager em = emf.createEntityManager();  

     BankCustomer b1 = new BankCustomer("Hans","Hansen","A-Num456", 100000.00,4, "Good");
     BankCustomer b2 = new BankCustomer("Jens","Jensen","A-Num458", 10000.00,15, "Intermediate");
     BankCustomer b3 = new BankCustomer("Lars","Larsen","A-Num451", 2308.00,38, "Poor");
     BankCustomer b4 = new BankCustomer("Svend","Svendsen","A-Num452", 23.00,200, "Bad");
        
        
                     try{
         
            em.getTransaction().begin();
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.persist(b4);
          
            em.getTransaction().commit();
            
            
        }finally{
        
            em.close();
        }
     
     
        
    }
    
    
}
