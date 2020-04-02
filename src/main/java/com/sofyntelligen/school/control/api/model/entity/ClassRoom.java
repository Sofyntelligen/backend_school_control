package com.sofyntelligen.school.control.api.model.entity;

import com.sofyntelligen.school.control.api.model.dto.enums.TypeClassRoom;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_class_room")
public class ClassRoom implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_class_room", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "key_class_room", nullable = false, unique = true)
    private String keyClassRoom;

    @Column(name = "type_class_room", nullable = false)
    private TypeClassRoom typeClassRoom;

    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "description", nullable = false)
    private String desciption;

}
