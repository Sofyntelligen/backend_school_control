package com.sofyntelligen.school.control.api.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tbl_matter")
public class Matter implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_matter", nullable = false)
    private String id;

    @Column(name = "date_integracion", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateIntegration;

    @Column(name = "key_matter", nullable = false, unique = true)
    private String keyMatter;

    @Column(name = "name", nullable = false)
    private String nameMatter;

    @Column(name = "number_credit", nullable = false)
    private Integer numberCredit;

    @Column(name = "decription", nullable = false)
    private String decriptionMatter;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "setMatter")
    @JsonIgnore
    private Set<Course> course;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "setMatter")
    @JsonIgnore
    private Set<Teacher> setTeacher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateIntegration() {
        return dateIntegration;
    }

    public void setDateIntegration(LocalDate dateIntegration) {
        this.dateIntegration = dateIntegration;
    }

    public String getKeyMatter() {
        return keyMatter;
    }

    public void setKeyMatter(String keyMatter) {
        this.keyMatter = keyMatter;
    }

    public String getNameMatter() {
        return nameMatter;
    }

    public void setNameMatter(String nameMatter) {
        this.nameMatter = nameMatter;
    }

    public Integer getNumberCredit() {
        return numberCredit;
    }

    public void setNumberCredit(Integer numberCredit) {
        this.numberCredit = numberCredit;
    }

    public String getDecriptionMatter() {
        return decriptionMatter;
    }

    public void setDecriptionMatter(String decriptionMatter) {
        this.decriptionMatter = decriptionMatter;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    public Set<Teacher> getSetTeacher() {
        return setTeacher;
    }

    public void setSetTeacher(Set<Teacher> setTeacher) {
        this.setTeacher = setTeacher;
    }

    @Override
    public String toString() {
        return "Matter{" +
                "id='" + id + '\'' +
                ", dateIntegration=" + dateIntegration +
                ", keyMatter='" + keyMatter + '\'' +
                ", nameMatter='" + nameMatter + '\'' +
                ", numberCredit=" + numberCredit +
                ", decriptionMatter='" + decriptionMatter + '\'' +
                ", course=" + course +
                ", setTeacher=" + setTeacher +
                '}';
    }

}
