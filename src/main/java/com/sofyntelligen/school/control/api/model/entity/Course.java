package com.sofyntelligen.school.control.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sofyntelligen.school.control.api.model.dto.enums.TypeCourse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_course", nullable = false)
    private String id;

    @Column(name = "date_approval", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateApproval;

    @Column(name = "key_course", nullable = false, unique = true)
    private String keyCourse;

    @Column(name = "type_course", nullable = false)
    private TypeCourse typeCourse;

    @Column(name = "name", nullable = false)
    private String nameCourse;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", orphanRemoval = true)
    @JsonIgnore
    private Set<Matter> setMatter;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "setCourse")
    @JsonIgnore
    private Set<Student> setStudent;

}
