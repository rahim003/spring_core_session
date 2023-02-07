package peaksoft.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.HibernateConfiguration;
import peaksoft.models.Project;
import peaksoft.repositories.ProjectRepo;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public class ProjectRepository implements ProjectRepo {
    private final EntityManagerFactory entityManagerFactory = HibernateConfiguration.createEntityManagerFactory();

    @Override
    public void save(Project project) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void saveAll(List<Project> projects) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Project project : projects) {
            entityManager.persist(project);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Project> findAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final List<Project> selectCFromCountryC = entityManager.createQuery("from Project ", Project.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectCFromCountryC;
    }

    @Override
    public Project findById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final Project id1 = entityManager.createQuery("select  c from Project c where c=:id", Project.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void deleteById(Long id) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Project c where c.id=?1").setParameter(1, id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete  from Project ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Project update(Long id, Project project) {
        return null;
    }
}
