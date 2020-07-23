package com.HibernatePractice;

import com.HibernatePractice.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class App
{
    public static void main( String[] args )
    {
        Configuration  configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*String insertStudent = "insert into Student (Junaid,BE,101,9874561230)"+"(select name, degree, roll, phone from Student)";
        Query query = session.createQuery(insertStudent);
        int result = query.executeUpdate();*/

        String hql = "update Student set degree = :degreeName " + "where id = :studentId";
        Query query = session.createQuery(hql);
        query.setParameter("degreeName", "BSC");
        query.setParameter("studentId", 3);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
