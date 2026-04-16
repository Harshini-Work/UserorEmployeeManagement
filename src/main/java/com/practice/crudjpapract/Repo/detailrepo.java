package com.practice.crudjpapract.Repo;

import com.practice.crudjpapract.Entity.Employeeinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface detailrepo extends JpaRepository<Employeeinfo,Long> {

    List<Employeeinfo> findByLocation(String location);


    boolean existsByEmail(String email);
}
