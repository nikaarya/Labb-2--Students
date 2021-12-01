package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {
        Teacher teacher1 = new Teacher("Hanna", "Svensson", "Social science");
        Teacher teacher2 = new Teacher("Malin", "Persson", "Swedish");

        Student student1 = new Student("Nika", "Arya", "nika@elev.se", "0709876543");
        Student student2 = new Student("Pelle", "Persson", "pelle@elev.se", "0709876544");
        Student student3 = new Student("Per", "Andersson", "per@elev.se", "0701234567");

        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Science");

        subject1.addStudent(student1);
        subject1.addStudent(student2);
        subject1.setTeacher(teacher1);

        subject2.addStudent(student1);
        subject2.addStudent(student2);
        subject2.addStudent(student3);
        subject2.setTeacher(teacher2);

        entityManager.persist(subject1);
        entityManager.persist(teacher1);

        entityManager.persist(subject2);
        entityManager.persist(teacher2);

    }
}
