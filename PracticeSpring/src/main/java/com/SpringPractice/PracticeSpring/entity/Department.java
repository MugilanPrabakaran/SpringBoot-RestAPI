package com.SpringPractice.PracticeSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data /*used to initilize all getter ,setter , constructor and hashcode*/
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)

    public long departmentId;
    /*Hibernet Validation Annotation*/
    @NotBlank(message = "Please add name")
//    @Size(max = 10 , min = 8)
//    @Length(max = 12,min = 1)
//    @Positive
//    @Negative
    public String departmentName;
    public String departmentAddress;

    public String departmentCode;


}
