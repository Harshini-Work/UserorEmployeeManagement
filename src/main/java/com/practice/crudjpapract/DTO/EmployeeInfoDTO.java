package com.practice.crudjpapract.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class EmployeeInfoDTO {
 @NotNull(message = "should not be null")
 @Email(message = "should be correct format")
 private String email;
 @Size(min = 3 ,message = "Should contain atleast 3 words")
 private String name;

 @NotBlank(message = "should not be blank")
 @Size(min=8,max=12,message = "password should contain 8 to 12 characters")
 @Pattern(
         regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%&^+_=]).*$",
         message = "Password must contain at least one digit, one uppercase, one lowercase, and one special character"

 )
 @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
 private String password;

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public EmployeeInfoDTO(String name, String email) {
  this.name = name;
  this.email=email;
 }
}
