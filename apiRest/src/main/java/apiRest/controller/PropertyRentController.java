package apiRest.controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import apiRest.dao.PropertyRentDAO;
import apiRest.dao.PropertyRentHibernateDAO;
import apiRest.entities.PropertyRent;
 
@Path("/properties")
public class PropertyRentController {
 
    PropertyRentDAO propertyrentDAO = new PropertyRentHibernateDAO();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PropertyRent> getAllProducts() {
        return propertyrentDAO.findAll();
    }
 
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyRent getById(@PathParam("id") int id) {
        return propertyrentDAO.find(id);
    }
 
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyRent getByName(@QueryParam("titulo") String titulo) {
        return propertyrentDAO.findByName(titulo);
    }
 
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addProduct(@FormParam("titulo") String titulo,
    		@FormParam("endereco") String endereco,
    		@FormParam("metrosTerreno") String metrosTerreno,
    		@FormParam("metrosContruido") String metrosContruido,
    		@FormParam("quantQuartos") int quantQuartos,
    		@FormParam("quantBanheiros") int quantBanheiros,
    		@FormParam("quantGaragem") int quantGaragem,
    		@FormParam("preco") double preco) {
        PropertyRent propertyrent = new PropertyRent(0, titulo, endereco, metrosTerreno, metrosContruido, quantQuartos, quantBanheiros, quantGaragem, preco);
        propertyrentDAO.save(propertyrent);
    }
 
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateProduct(@PathParam("id") int id,
    		@FormParam("titulo") String titulo,
    		@FormParam("endereco") String endereco,
    		@FormParam("metrosTerreno") String metrosTerreno,
    		@FormParam("metrosContruido") String metrosContruido,
    		@FormParam("quantQuartos") int quantQuartos,
    		@FormParam("quantBanheiros") int quantBanheiros,
    		@FormParam("quantGaragem") int quantGaragem,
            @FormParam("preco") double preco) {
        PropertyRent propertyrent = new PropertyRent(id, titulo, endereco, metrosTerreno, metrosContruido, quantQuartos, quantBanheiros, quantGaragem, preco);
        propertyrentDAO.save(propertyrent);
    }
 
    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id) {
    	propertyrentDAO.delete(id);
    }
}
