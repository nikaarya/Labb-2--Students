package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher createNewTeacher(Teacher teacher) {

//        teacher.addSubject(new Subject("Math"));
//        teacher.addSubject(new Subject("English"));

        entityManager.persist(teacher);
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    public Teacher getTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public void deleteTeacher(Long id) {
        Teacher foundTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(foundTeacher);
    }
}
