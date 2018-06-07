package com.kuznetsov.entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subjects", schema = "quiz")
public class SubjectsEntity {

    @Id
    private Integer id;
    @NaturalId
    private String subject;

    public SubjectsEntity() {
    }

    public SubjectsEntity(Integer id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectsEntity that = (SubjectsEntity) o;
        return id == that.id &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, subject);
    }
}
