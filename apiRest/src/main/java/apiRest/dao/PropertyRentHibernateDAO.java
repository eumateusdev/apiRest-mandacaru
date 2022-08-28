package apiRest.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import apiRest.entities.PropertyRent;
 
public class PropertyRentHibernateDAO implements PropertyRentDAO {
 
    static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("apiRest");
    static EntityManager entityManager;
 
    @Override
    public void save(PropertyRent entity) {
        entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
 
        if (entity.getId() == 0) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
 
        entityManager.getTransaction().commit();
        entityManager.close();
    }
 
    @Override
    public void delete(int id) {
        entityManager = sessionFactory.createEntityManager();
        PropertyRent properties = entityManager.find(PropertyRent.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(properties);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
 
    @Override
    public PropertyRent find(int id) {
        entityManager = sessionFactory.createEntityManager();
        PropertyRent properties = entityManager.find(PropertyRent.class, id);
        entityManager.close();
 
        return properties;
    }
 
    @Override
    public List<PropertyRent> findAll() {
        entityManager = sessionFactory.createEntityManager();
        List<PropertyRent> properties = entityManager.createQuery("from propertyrent", PropertyRent.class).getResultList();
        entityManager.close();
 
        return properties;
    }
 
    @Override
    public PropertyRent findByName(String str) {
        entityManager = sessionFactory.createEntityManager();
        PropertyRent properties = null;
 
        try {
        	properties = entityManager.createQuery("from propertyrent where titulo=?1", PropertyRent.class).setParameter(1, str)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
        entityManager.close();
 
        return properties;
    }
 
    @Override
    public List<PropertyRent> findAllByName(String str) {
        entityManager = sessionFactory.createEntityManager();
        List<PropertyRent> properties = null;
 
        try {
        	properties = entityManager.createQuery("from propertyrent where titulo=?1", PropertyRent.class)
                    .setParameter(1, str).getResultList();
        } catch (Exception e) {
            return null;
        }
        entityManager.close();
 
        return properties;
    }
 
}
