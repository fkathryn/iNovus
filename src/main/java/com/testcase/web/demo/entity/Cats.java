package com.testcase.web.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "cats_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String image;

    @Column
    @NonNull
    private String name;

    @Column
    private Integer votes;
}
