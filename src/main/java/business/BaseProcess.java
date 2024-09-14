package business;

import data.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseProcess {
    private final List<Student> students;
    EntityManager em = ConnectDB.connect();

    public BaseProcess() {
        students = new ArrayList<>();
    }

    public List<Student> getAll() {
        //TODO: Get all students from database
        Query query = em.createQuery("SELECT s FROM student s");

        return (List<Student>) query.getResultList().stream().collect(Collectors.toList());
    }

    public Student getById(long id) {
        Query query = em.createQuery("SELECT s FROM student s WHERE s.id = :id");

        query.setParameter("id", id);
        return (Student) query.getSingleResult();
    }

    public Student add(Student student) {
        students.add(student);
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        return student;
    }
}
