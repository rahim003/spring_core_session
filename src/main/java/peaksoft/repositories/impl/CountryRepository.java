package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import peaksoft.config.HibernateConfiguration;
import peaksoft.models.Country;
import peaksoft.repositories.CountryRepo;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
@Transactional
public class CountryRepository implements CountryRepo {
    private final EntityManagerFactory entityManagerFactory = HibernateConfiguration.createEntityManagerFactory();


    @Override
    public void save(Country country) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void saveAll(List<Country> countries) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Country country : countries) {
            entityManager.persist(country);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Country> findAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final List<Country> selectCFromCountryC = entityManager.createQuery("from Country ", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectCFromCountryC;
    }

    @Override
    public Country findById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Country id1 = entityManager.createQuery("select  c from Country c where c=:id", Country.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void deleteById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Country c where c.id=?1").setParameter(1, id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Country ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Country update(Long id, Country country) {
        return null;
    }
}
