package pojo;

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
    private String cname;

    public Student(int sid, String name, String sex, int age, String addr, int cid) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
        this.cid = cid;
    }
}
