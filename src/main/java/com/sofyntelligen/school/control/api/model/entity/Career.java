package com.sofyntelligen.school.control.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_career")
public class Career {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_career", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "key_career", nullable = false, unique = true)
    private String keyCareer;

    @Column(name = "total_credits", nullable = false)
    private Integer totalCredits;

    @Column(name = "description", nullable = false)
    private String desciption;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "setCareer")
    @JsonIgnore
    private Set<Student> setStudent;

}
