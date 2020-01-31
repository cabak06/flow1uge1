/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animal;
import java.util.ArrayList;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author cahit
 */
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
   // @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
      return "Hello from my first WebService";
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    
@GET
@Path("/random")
@Produces(MediaType.APPLICATION_JSON)

public String random(){
    
    ArrayList<Animal> m =list();
    Random random = new Random();
    int x = random.nextInt(m.size());
    return new Gson().toJson(m.get(x));

}

public ArrayList<Animal> list(){
ArrayList<Animal> liste = new ArrayList();
liste.add(new Animal("Dog",1,"howl"));
liste.add(new Animal("Kitty",1,"miaavv"));
liste.add(new Animal("Cow",1,"Muuuh"));
liste.add(new Animal("Goat",1,"meeeeeeeeeeeeeee"));
        return liste;
}




}
