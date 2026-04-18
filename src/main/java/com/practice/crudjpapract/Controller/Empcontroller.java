package com.practice.crudjpapract.Controller;

import com.practice.crudjpapract.DTO.EmployeeInfoDTO;
import com.practice.crudjpapract.Entity.Employeeinfo;
import com.practice.crudjpapract.Service.Empservice;
import com.practice.crudjpapract.sucess.SucessResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/data")
public class Empcontroller {
         @Autowired
         private Empservice empservice;
         @PostMapping("/add")
         public List<Employeeinfo> add(@RequestBody List<Employeeinfo> emplist){
             return empservice.add(emplist);
         }
         @GetMapping("/get/{id}")
         public Employeeinfo getbyid(@PathVariable Long id ){
             return empservice.getbyid(id);
         }
         @GetMapping("/getall")
         public List<Employeeinfo> getall(){
             return empservice.getall();
         }
         @GetMapping("/{location}")
         public List<Employeeinfo> getlocation(@PathVariable String location){
             return empservice.getlocation(location);
         }
         @PutMapping("/{id}")
         public Employeeinfo updatebyid(@PathVariable Long id,@RequestBody Employeeinfo newdata){
             return empservice.updatebyid(id ,newdata);
         }
         @DeleteMapping("/{id}")
         public String deleteid(@PathVariable Long id ){
          String deleted =empservice.deleteid(id);
             return (deleted!=null) ?"Deleted sucessfully":"not found";
         }
         @PostMapping
         public ResponseEntity<SucessResponse> enter(@Valid @RequestBody EmployeeInfoDTO empdto){
             EmployeeInfoDTO save = empservice.enter(empdto);

             return  ResponseEntity.status(HttpStatus.CREATED).body(new SucessResponse("Created Sucessfully",empdto));
         }
         @GetMapping
         public Page<EmployeeInfoDTO> getuser(@PageableDefault (size =5,sort="name",direction = Sort.Direction.ASC) Pageable pageable){
              return empservice.getuser(pageable);
         }
}
