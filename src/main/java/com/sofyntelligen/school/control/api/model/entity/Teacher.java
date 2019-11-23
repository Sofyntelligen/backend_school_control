package com.sofyntelligen.school.control.api.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_teacher", nullable = false)
    private String id;

    @Column(name = "enrollment", nullable = false)
    private String enrollment;

    @Column(name = "professionOrOccupation", nullable = false)
    @Size(min = 1, max = 80)
    private String professionOrOccupation;

    private List<Matter> listMatter;

}
