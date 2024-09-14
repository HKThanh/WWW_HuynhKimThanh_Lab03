package business;

import data.ConnectDB;
import models.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseProcess {
    private final List<Student> students;
    private Connection con = null;

    public BaseProcess() {
        students = new ArrayList<>();
    }

    public List<Student> getAll() {
        //TODO: Get all students from database
        con = ConnectDB.connect();
        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM student";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student add(Student student) {
        students.add(student);
        return student;
    }
}
