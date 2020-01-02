package com.sofyntelligen.school.control.api.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
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
    private LocalDate dateIntegration;

    @Column(name = "key_matter", nullable = false, unique = true)
    private String keyMatter;

    @Column(name = "name", nullable = false)
    private String nameMatter;

    @Column(name = "number_credit", nullable = false)
    private Integer numberCredit;

    @Column(name = "decription", nullable = false)
    private String decriptionMatter;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_course_id")
    private Course course;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "setMatter")
    @JsonIgnore
    private Set<Teacher> setTeacher;

}
