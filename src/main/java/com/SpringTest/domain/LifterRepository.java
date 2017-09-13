package com.SpringTest.domain;


import java.util.List;
import org.springframework.data.repository.CrudRepository;


    public interface LifterRepository extends CrudRepository<Lifter,Integer>
    {
        List<Lifter> findByName(String name);
    }

