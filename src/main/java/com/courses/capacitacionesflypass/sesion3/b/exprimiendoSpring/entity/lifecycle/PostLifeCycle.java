package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.entity.lifecycle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class PostLifeCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserLifeCycle author;


    @PostLoad
    public void postLoad() {

    }

    @PostPersist
    public void postPersist() {

    }

    @PostRemove
    public void postRemove() {

    }

    @PostUpdate
    public void postUpdate() {

    }

    @PrePersist
    public void prePersist() {

    }

    @PreRemove
    public void preRemove() {

    }

    @PreUpdate
    public void preUpdate() {

    }
}
