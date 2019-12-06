/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dummy.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author exkapp
 */
@Path("dummy")
public class DummyResource {
    
    private IDAO miDao = new daoTacos();
    
    
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DummyResource
     */
    public DummyResource() {
    }
  

    /**
     * Retrieves representation of an instance of org.dummy.api.DummyResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Taco> getJson() throws SQLException {
        //TODO return proper representation object
        ResultSet res = miDao.readAll();
        List<Taco> listaTacos = new ArrayList<>();
        while(res.next()){
            Taco taco = new Taco();
            taco.setId_taco(res.getString(1));
            taco.setNombre(res.getString(2));
            taco.setPrecio(res.getString(3));
            listaTacos.add(taco);
        }
        return listaTacos;
    }

    /**
     * PUT method for updating or creating an instance of DummyResource
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(Taco taco) {
        System.out.println("Entrando POST");
         if (miDao.insert(taco))
             return "OK";
         else
             return "Fail";
    }
    
    
}
