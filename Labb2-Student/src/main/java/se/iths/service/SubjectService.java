package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        subject.addStudent(new Student("Nika", "Arya", "nika@elev.se", "0709876543"));
        subject.addStudent(new Student("Pelle", "Persson", "pelle@elev.se", "0709876544"));

        //subject.addTeacher(new Teacher("Annika", "Pettersson"));
        entityManager.persist(subject);
        return subject;
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT su FROM Subject su", Subject.class).getResultList();
    }

    public Subject getSubjectById(Long id) {
       return entityManager.find(Subject.class, id);
    }

    public void deleteSubject(Long id) {
        Subject foundSubject = entityManager.find(Subject.class, id);
        entityManager.remove(foundSubject);
    }
//    public List<Subject> getAllSubjectsStudentsAndTeachers() {
//
//        Query query = entityManager.createQuery("SELECT sub, stu, t FROM Subject sub, Student stu, Teacher t");
//        return query.getResultList();
//    }
}
