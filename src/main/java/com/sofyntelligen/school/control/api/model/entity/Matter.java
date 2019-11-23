package com.sofyntelligen.school.control.api.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @Column(name = "keyMatter", nullable = false)
    private String keyMatter;

    @Column(name = "nameMatter", nullable = false)
    private String nameMatter;

    @Column(name = "numberCredit", nullable = false)
    private Integer numberCredit;

    @Column(name = "decriptionMatter", nullable = false)
    private String decriptionMatter;

}
