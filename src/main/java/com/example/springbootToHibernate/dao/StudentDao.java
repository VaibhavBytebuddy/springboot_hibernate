package com.example.springbootToHibernate.dao;

import com.example.springbootToHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    SessionFactory factory;

    public void insertStudentRecord(Student student) {
        Session session= factory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();

    }

    public String insertData(Student student) {
        Session session= factory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        return student.toString();
    }

    public List<Student> getData() {
        Session session = factory.openSession();
        session.beginTransaction();

        Query<Student> query = session.createQuery("from Student");
        List<Student> resultList = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return resultList;
    }

    public Student getDataById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Student result =session.get(Student.class,id);

        session.getTransaction().commit();
        session.close();
        return result;


    }


    public Student updateDataById(int id, Student student) {
        Session session = factory.openSession();
        session.beginTransaction();

        Student result = session.get(Student.class, id);

        if (result != null) {
            result.setName(student.getName());
            result.setAge(student.getAge());
            result.setCity(student.getCity());


        }

        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Student deleteById(int id) {

        Session session = factory.openSession();
        session.beginTransaction();

        Student result = session.get(Student.class, id);

        if (result!=null)
        {
            session.delete(result);
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }

//    public Student getDataByAge(int age) {
//        Session session = factory.openSession();
//        session.beginTransaction();
//
//        String hql_q="from Student where age=:age";
//        Query<Student> query = session.createQuery(hql_q, Student.class);
//        query.setParameter("age", age);
//
//        session.getTransaction().commit();
//        session.close();
//        return result;
//
//
//    }


}
