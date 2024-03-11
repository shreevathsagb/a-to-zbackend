package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int crno;

    @OneToMany(mappedBy = "classroom")
    @JsonIgnore
    private List<StudentEntity> students;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrno() {
        return crno;
    }

    public void setCrno(int crno) {
        this.crno = crno;
    }

    @JsonIgnore
    public List<StudentEntity> getStudents() {
        return students;
    }
}
