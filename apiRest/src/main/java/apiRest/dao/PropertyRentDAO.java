package apiRest.dao;

import java.util.List;

import apiRest.entities.PropertyRent;

public interface PropertyRentDAO {
		
	 	public void save(PropertyRent entity);
	 
	    public void delete(int id);
	 
	    public PropertyRent find(int id);
	 
	    public List<PropertyRent> findAll();
	    
	    public PropertyRent findByName(String str);
	 
	    public List<PropertyRent> findAllByName(String str);
}

