package com.example.springbootToHibernate.service;

import com.example.springbootToHibernate.dao.StudentDao;
import com.example.springbootToHibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void insertStudentRecord(Student student) {
        studentDao.insertStudentRecord(student);
    }

    public String insertData(Student student) {
         return  studentDao.insertData(student);
    }

    public List getData() {
        return studentDao.getData();
    }

    public Student getDataById(int id) {
        return studentDao.getDataById(id);
    }

    public Student updateDataById(int id, Student student) {
        return studentDao.updateDataById(id,student);
    }

    public Student deleteById(int id) {
        return studentDao.deleteById(id);
    }
}
