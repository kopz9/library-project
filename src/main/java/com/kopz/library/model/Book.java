package com.kopz.library.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;




@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}
