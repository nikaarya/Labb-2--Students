package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public void createSubject(Subject subject) {
        entityManager.persist(subject);
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
}
