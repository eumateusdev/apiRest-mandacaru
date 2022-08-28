package apiRest;

import java.util.List;

import apiRest.dao.PropertyRentDAO;
import apiRest.dao.PropertyRentHibernateDAO;
import apiRest.entities.PropertyRent;

public class Main {

	public static void main(String[] args) {
		PropertyRentDAO propertyrentDAO = new PropertyRentHibernateDAO();
		 
        PropertyRent propertyrent = new PropertyRent(0, "Chácara à venda","Proximo a barragem, sem n°, Zona Rural", "4155m2", "655m2", 6, 8, 0, 3900000.0);
 
        // Add 
        propertyrentDAO.save(propertyrent);
 
        // Find 
        PropertyRent auxPropertyRent = propertyrentDAO.find(1);
        System.out.println(auxPropertyRent);
 
        // Find by Name 
        PropertyRent auxPropertyRent2 = propertyrentDAO.findByName("Chácara à venda");
        System.out.println(auxPropertyRent2);
 
        // Find All 
        List<PropertyRent> list = propertyrentDAO.findAll();
        System.out.println(list);
 
        // Find All by Name 
        list = propertyrentDAO.findAllByName("Chácara à venda");
        System.out.println(list);
 
        // Update 
        PropertyRent auxPropertyRent3 = propertyrentDAO.find(1);
        auxPropertyRent3.setTitulo("Casa no Centro");
        auxPropertyRent3.setEndereco("Rua Felipe Santiago, 520, Centro, Russas");
        auxPropertyRent3.setMetrosTerreno("175m2");
        auxPropertyRent3.setMetrosContruido("130m2");
        auxPropertyRent3.setQuantQuartos(3);
        auxPropertyRent3.setQuantBanheiros(2);
        auxPropertyRent3.setQuantGaragem(1);
        auxPropertyRent3.setPreco(178512.0);
        propertyrentDAO.save(auxPropertyRent3);
        System.out.println(auxPropertyRent3);
 
        // Delete
        //productDAO.delete(4);
    	}

	}

