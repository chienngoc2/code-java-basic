/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ADMIN
 */
public class Person<T> {
    
    private T id;  
    private Integer age;  

    public Person(T id, Integer age) {  
        this.id = id;  
        this.age = age;  
    }  

    public T getId() {  
        return id;  
    }  

    public Integer getAge() {  
        return age;  
    }  
}
