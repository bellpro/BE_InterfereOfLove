package com.example.loveadviser.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Count {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long count_id;

    @OneToOne
    private Article article;

    @Column
    private int greenCount;

    @Column
    private int redCount;
}
