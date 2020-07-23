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

        String insertStudent = "insert into Student (Junaid,BE,101,9874561230)"+"(select name, degree, roll, phone from Student)";
        Query query = session.createQuery(insertStudent);
        query.executeUpdate();

        String updateStudent = "update Student s set s.degree = 'BSC' " + "where id = 1";
        Query query1 = session.createQuery(updateStudent);
        query1.executeUpdate();

        String deleteStudent = "delete from Student s where id = 5";
        Query query2 = session.createQuery(deleteStudent);
        query2.executeUpdate();

        transaction.commit();
        session.close();
    }
}
