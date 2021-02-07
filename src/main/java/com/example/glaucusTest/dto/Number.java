package com.example.glaucusTest.dto;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "number")
@DynamicUpdate(value = true)
public class Number implements Serializable {


    @Id
    @GeneratedValue(strategy = AUTO)
	private Long id;
    private Integer count;
   


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
