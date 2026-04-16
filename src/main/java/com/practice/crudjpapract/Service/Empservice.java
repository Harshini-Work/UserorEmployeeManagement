package com.practice.crudjpapract.Service;
import com.practice.crudjpapract.Exception.BadRequestException;
import com.practice.crudjpapract.DTO.EmployeeInfoDTO;
import com.practice.crudjpapract.Entity.Employeeinfo;
import com.practice.crudjpapract.Exception.ResponseNotFoundException;
import com.practice.crudjpapract.Repo.detailrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Empservice {
    @Autowired
    private  detailrepo repo;
    public List<Employeeinfo> add( List<Employeeinfo> emplist){
        return repo.saveAll(emplist);
    }
    public Employeeinfo getbyid(Long id ){

       return repo.findById(id).orElseThrow(()->new ResponseNotFoundException("User not found with id: "+id));
    }
    public List<Employeeinfo> getall(){
        List <Employeeinfo> list = repo.findAll();
        if(list.isEmpty()) throw new ResponseNotFoundException("empty");
        else{ repo.findAll();}
        return list;
    }
    public List<Employeeinfo> getlocation(String location){
        return repo.findByLocation(location);
    }
    public Employeeinfo updatebyid(Long id,Employeeinfo newdata){
        Employeeinfo exsist = repo.findById(id).orElse(null);
        if(exsist!=null){
            exsist.setName(newdata.getName());
            exsist.setLocation(newdata.getLocation());
            return repo.save(exsist);
        }
        return null;
    }
    public String deleteid(Long id ){
           repo.deleteById(id);
           return " Deleted";

    }
    public EmployeeInfoDTO enter(EmployeeInfoDTO empdto){
        /* change from dto to entity */
        Employeeinfo changetoentity = new Employeeinfo();
        changetoentity.setName(empdto.getName());
        changetoentity.setEmail(empdto.getEmail());
        changetoentity.setPassword(empdto.getPassword());
        if(repo.existsByEmail(empdto.getEmail())) throw new BadRequestException("Email already exist");
        // save to db
        repo.save(changetoentity);
        //entity to dto
        EmployeeInfoDTO changetodto = new EmployeeInfoDTO(changetoentity.getName(), changetoentity.getEmail());
        return changetodto;
    }

}
