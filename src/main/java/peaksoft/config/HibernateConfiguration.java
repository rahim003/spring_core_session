package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import peaksoft.models.Address;
import peaksoft.models.Country;
import peaksoft.models.Programmer;
import peaksoft.models.Project;

import java.util.Properties;

/**
 * ~ @created 06/02/2023
 * ~ @project_name IntelliJ IDEA
 * ~ @author kurbanov
 **/
public class HibernateConfiguration {

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/session");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "123123");

        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Country.class);
        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory createEntityManagerFactory() {
        final SessionFactory sessionFactory1 = getSessionFactory();
        return sessionFactory1.unwrap(EntityManagerFactory.class);

    }
}


