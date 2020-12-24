package co.company.spring.dao;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Emp {
	//@JsonProperty(value = "empId")
    String employeeId;   
	String firstName;
	String lastName;
	String email;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape=Shape.STRING)
	/* @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss") */
	Date hireDate;	
	String jobId;	
	String departmentId;
	@JsonIgnore Integer salary;
	@JsonIgnore String msg;
}
