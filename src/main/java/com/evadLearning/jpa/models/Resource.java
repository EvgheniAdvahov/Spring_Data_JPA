package com.evadLearning.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int size;
    private String url;
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
