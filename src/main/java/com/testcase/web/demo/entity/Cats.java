package com.testcase.web.demo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cats_table")
@Data
@NoArgsConstructor
public class Cats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer votes;

    @Column
    private boolean participate;
}
