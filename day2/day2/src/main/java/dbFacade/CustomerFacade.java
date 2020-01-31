package dbFacade;

import entity.Customer;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CustomerFacade {
    

    public static EntityManagerFactory emf;
    public static CustomerFacade instance;

    public CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {

        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }

        return instance;
    }

//find customer on id
    public Customer findCustomer(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

//add customer
    public Customer addCustomer(String forName, String lastName) {
        Customer customer = new Customer(forName, lastName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

    //get all Customers
    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("Select c from Customer c", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

//get number of customers
    public int getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        int number = getAllCustomers().size();
        return number;

    }

//find customer by last name
    public List<Customer> findByLastName(String lastName) {
        EntityManager em = emf.createEntityManager();

        try{
        TypedQuery<Customer> query = em.createQuery("Select c from Customer c Where c.lastName = :lastName", Customer.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
        } catch (Exception ex){
            return new ArrayList();
        }

    }

}
