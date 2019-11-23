package com.sofyntelligen.school.control.api.model.entity;

import com.sofyntelligen.school.control.api.model.dto.enums.TypeCourse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @Column(name = "keyCourse", nullable = false)
    private String keyCourse;

    @Column(name = "typeCourse", nullable = false)
    private TypeCourse typeCourse;

    @Column(name = "nameCourse", nullable = false)
    private String nameCourse;

    private List<Matter> listMatter;

}
