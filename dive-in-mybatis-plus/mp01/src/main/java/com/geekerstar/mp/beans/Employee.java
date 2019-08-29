package com.geekerstar.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author geekerstar
 * @date 2018/12/11
 * description
 */

/**
 * MybatisPlus会默认使用实体类的类名到数据中找对应的表
 */
@TableName(value = "tbl_employee")
public class Employee {
    /**
     * @TableId
     *      value:指定表中的主键列的列名，如果实体属性名与列名一致，可以省略不指定
     *      type:指定主键策略
     */
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false)
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
