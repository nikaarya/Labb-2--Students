package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String mainSubject;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Subject> subjects = new HashSet<>();

    public Teacher(String firstName, String lastName, String mainSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainSubject = mainSubject;
    }

    public Teacher() {}

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    @JsonbTransient
    public Set<Subject> getSubjects() {
        return subjects;
    }

}


