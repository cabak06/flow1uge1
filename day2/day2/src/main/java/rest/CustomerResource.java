/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import dbFacade.CustomerFacade;
import static dbFacade.CustomerFacade.emf;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author cahit
 */
@Path("customer")
public class CustomerResource {

    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CustomerResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello from my second WebService";
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)

    public String list() {

       
        List<Customer> allCus = facade.getAllCustomers();

        return new Gson().toJson(allCus);
    }
    
    
@GET
@Path("/random")
@Produces(MediaType.APPLICATION_JSON)

public String random(){
    
    List<Customer> m = facade.getAllCustomers();
    Random random = new Random();
    int x = random.nextInt(m.size());
    return new Gson().toJson(m.get(x));
}


@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public String findCustomer(@PathParam("id") int id) {
       Customer s = facade.findCustomer(id);
       return new Gson().toJson(s);
        
    }


    /**
     * PUT method for updating or creating an instance of CustomerResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
