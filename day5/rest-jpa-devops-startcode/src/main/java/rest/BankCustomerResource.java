package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CustomerDTO;

import entities.BankCustomer;
import utils.EMF_Creator;
import facades.FacadeExample;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("bankcustomer")
public class BankCustomerResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    FacadeExample facade = FacadeExample.getFacadeExample(emf);
            
            
            

    
    
//    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
//                "pu",
//                "jdbc:mysql://localhost:3307/startcode",
//                "dev",
//                "ax2",
//                EMF_Creator.Strategy.CREATE);
//    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "Hello BankCustomer";
    }
   
    
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        long count = facade.getRenameMeCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }

    
    
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    
    public String findCustomerByIdDTO(@PathParam("id") int id) {
       CustomerDTO s = facade.getCustomerByID(id);
       
       return new Gson().toJson(s);
        
    }
    
    
       
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    
    public String getAllBankCustomers(){
        
    List<BankCustomer> list = facade.getAllBankCustomers();
    return new Gson().toJson(list);  
    }
    
    
    
    
    
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    
//    public String findCustomerByIdDTO(@PathParam("id") int id) {
//        
//       CustomerDTO dto = facade.getCustomerByID(id);
//               
//              
//       return new Gson().toJson(dto);
//        
//    }
    
    
    
    
    
    
 
}
