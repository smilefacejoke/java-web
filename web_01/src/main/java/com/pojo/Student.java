package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 54350
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int sid;
    private String name;
    private String sex;
    private int age;
    private String addr;
    private int cid;
}
