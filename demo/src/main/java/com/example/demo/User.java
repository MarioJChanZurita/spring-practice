package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "users")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name="name", columnNames = "name")
        }
)
public class User {

    @Id
    @GeneratedValue(
        generator = "user_generator",
        strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
        name = "user_generator",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @Column(
        name = "id",
        updatable = false,
        nullable = false
    )
    private Long id;

    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "CHARACTER VARYING (50)"
    )
    private String name;
    
    public User() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
