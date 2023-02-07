package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.HibernateConfiguration;
import peaksoft.enums.CountryName;
import peaksoft.models.Address;
import peaksoft.models.Programmer;
import peaksoft.repositories.ProgrammerRepo;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public class ProgrammerRepository implements ProgrammerRepo {
    private final EntityManagerFactory entityManagerFactory = HibernateConfiguration.createEntityManagerFactory();

    @Override
    public void save(Programmer programmer, Long addressId) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Address singleResult = entityManager.createQuery("select a from Address  a where a.id=?1", Address.class).setParameter(1, addressId).getSingleResult();
        programmer.setAddress(singleResult);
        entityManager.persist(programmer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void saveAll(List<Programmer> programmers, List<Long> addressesId) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (int i = 0; i < programmers.size(); i++) {
            final Programmer programmer = programmers.get(i);
            final Long aLong = addressesId.get(i);
            final Address singleResult = entityManager.createQuery("select a from Address  a where a.id=?1", Address.class).setParameter(1, aLong).getSingleResult();
            programmer.setAddress(singleResult);
            entityManager.persist(programmer);
            entityManager.getTransaction().commit();
            entityManager.close();
        }

    }

    @Override
    public List<Programmer> findAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final List<Programmer> selectCFromCountryC = entityManager.createQuery("from Programmer ", Programmer.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectCFromCountryC;
    }

    @Override
    public Programmer findById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Programmer id1 = entityManager.createQuery("select  c from Programmer c where c=:id", Programmer.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void deleteById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Programmer c where c.id=?1").setParameter(1, id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Programmer ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Programmer update(Long id, Programmer programmer) {
        return null;
    }

    @Override
    public List<Programmer> findByProgrammerCountry(CountryName country) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final List<Programmer> country1 = entityManager.createQuery("select p from Programmer p join Address a join Country c on p.id=a.id and a.id=c.id where c.countryName=:country", Programmer.class).setParameter("country", country).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return country1;
    }
}
