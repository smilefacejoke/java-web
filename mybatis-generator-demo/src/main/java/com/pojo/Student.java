package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 54350
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private Integer sid;

    private String name;

    private String sex;

    private Integer age;

    private String addr;

    private Integer cid;

    private static final long serialVersionUID = 1L;


}