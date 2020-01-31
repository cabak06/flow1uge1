package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

    public CustomerDTO getCustomerByID(int id){
     EntityManager em = emf.createEntityManager();
     
     
          try {
            CustomerDTO customerDTO = em.find(CustomerDTO.class, id);
            return customerDTO;
        } finally {
            em.close();
        }
    }
    
        public List<CustomerDTO> getEmployeesByName(String name) {
        EntityManager em = emf.createEntityManager();
        
        try{
        TypedQuery<CustomerDTO> query = em.createQuery("Select c from CustomerDTO c Where c.name = :name", CustomerDTO.class);
        query.setParameter("name", name);
        return query.getResultList();
        } catch (Exception ex){
            return new ArrayList();
        }
       }
    
          
        public BankCustomer addCustomer(String firstName,String lastName,String accountNumber,double balance,int customerRanking,String internalInfo){
           
           EntityManager em = emf.createEntityManager();
           BankCustomer bk = new BankCustomer(firstName,lastName,accountNumber,balance,customerRanking,internalInfo);  
           
            try {
            em.getTransaction().begin();
            em.persist(bk);
            em.getTransaction().commit();
            return bk;
        } finally {
            em.close();
        }
            
        }
        
    
       public List<BankCustomer> getAllBankCustomers(){
           
       EntityManager em = emf.createEntityManager();
       
       try {
            TypedQuery<BankCustomer> query = em.createQuery("Select e from BankCustomer e", BankCustomer.class);
            return query.getResultList();
        } finally {
            em.close();
        } 
           
           
       }
        
        
        
}
