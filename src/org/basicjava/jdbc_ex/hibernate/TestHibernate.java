package org.basicjava.jdbc_ex.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.internal.EntityManagerFactoryRegistry;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.sql.ordering.antlr.Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

/**
 * User: Maxim
 * Date: 09.10.13
 * Time: 19:29
 */
public class TestHibernate {
    public static void main(String[] args){
        testJpa();
    }

    public static void testJpa(){
        //Properties properties = new Properties();
        //properties.put("org.hibernate.tutorial.jpa", "./persistence2.xml");
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("acme", properties);

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory( "org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new Employee("Anrey2", "Egorov", Date.valueOf("1990-01-01"),"xxx") );
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        String query = "from Employee";
        List<Employee> result = entityManager.createQuery( query, Employee.class ).getResultList();
        for (Employee emp : result ) {
            System.out.println(emp);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static void testHibernate(){
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Employee employee = (Employee)session.load( Employee.class, 1);

        session.beginTransaction();

        Employee newEmp = new Employee("Anrey2", "Egorov", Date.valueOf("1990-01-01"),"xxx");
        Employee newEmp2 = new Employee("Anrey", "Egorov", Date.valueOf("1990-01-01"),"xxx");
        //newEmp.setId(10);
        //session.saveOrUpdate(newEmp);
        //session.save(newEmp);
        List<Employee> list = session.createSQLQuery("select id, firstname, lastname, birth_date, cell_phone from employee").
                addEntity(Employee.class).list();

        for (Employee emp: list){
            System.out.println(emp);
        }


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        //System.out.println(employee);

    }
}
