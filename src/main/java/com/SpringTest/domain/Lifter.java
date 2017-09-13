package com.SpringTest.domain;



import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Lifters")
public class Lifter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="weightClass", nullable=false)
    private int weightClass;


    @Column(name="name", nullable=false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightClass() {

        return weightClass;
    }

    public void setWeightClass(int weightClass) {
        this.weightClass = weightClass;
    }

    protected Lifter() {}

    public Lifter(int weightClass,String name)
    {
        this.weightClass= weightClass;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format("Lifter[id=%d, weightClass='%d', name='%s']",
                id , weightClass, name);
    }




}
