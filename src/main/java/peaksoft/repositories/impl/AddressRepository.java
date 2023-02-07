package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.HibernateConfiguration;
import peaksoft.enums.CountryName;
import peaksoft.models.Address;
import peaksoft.models.Country;
import peaksoft.repositories.AddressRepo;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public class AddressRepository implements AddressRepo {
    private final EntityManagerFactory entityManagerFactory = HibernateConfiguration.createEntityManagerFactory();

    @Override
    public void save(Address address, Long countryId) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Country singleResult = entityManager.createQuery("select a from Country  a where a.id=?1", Country.class).setParameter(1, countryId).getSingleResult();
        address.setCountry(singleResult);
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void saveAll(List<Address> addresses, List<Long> countriesId) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (int i = 0; i < addresses.size(); i++) {
            Address address = addresses.get(i);
            Long countryId = countriesId.get(i);
            Country country = entityManager.find(Country.class, countryId);
            address.setCountry(country);
            entityManager.persist(address);

        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Address> findAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final List<Address> selectCFromCountryC = entityManager.createQuery("from Country ", Address.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectCFromCountryC;

    }

    @Override
    public Address findById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Address id1 = entityManager.createQuery("select  c from Country c where c=:id", Address.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void deleteById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Address c where c.id=?1").setParameter(1, id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Address ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Address update(Long id, Address address) {
        return null;
    }

    @Override
    public List<Address> findByCountry(CountryName countryName) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final List<Address> resultList = entityManager.createQuery("select a from Address  a join Country c on a.id=c.id where c.countryName=?1", Address.class).setParameter(1, countryName).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }
}
