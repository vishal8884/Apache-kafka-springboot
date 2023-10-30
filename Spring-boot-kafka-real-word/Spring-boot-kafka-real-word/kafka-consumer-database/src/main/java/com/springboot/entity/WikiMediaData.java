package com.springboot.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "wikimedia")
@Getter
@Setter
public class WikiMediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(length = 20971520)
    private String wikiEventData;
}
