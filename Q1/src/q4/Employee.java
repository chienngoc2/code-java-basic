/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;

/**
 *
 * @author ADMIN
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    private int seniority;

    public Employee() {
    }

    public Employee(int id, String name, double salary, int seniority) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.seniority = seniority;
    }

    public void setSeniority(int seniority) {
        if (seniority <= 0) {
            this.seniority = 1;
        }
      
    }
  
    
    @Override
    public String toString(){
        return  this.id +","+this.name+","+String.format("%.2f", this.salary)+","+this.seniority;
    }

    public void updateSalary() {
        if (this.getSeniority() >=3 && this.getSeniority() <=5 ) {
            this.salary = this.getSalary()+ 0.3 * this.getSalary();
        }
        else if(this.getSeniority() >=6 && this.getSeniority() <=10 ){
             this.salary = this.getSalary()+ 0.5 * this.getSalary();
        }
        else if(this.getSeniority() >=10 ){
            this.salary = this.getSalary()+  this.getSalary();
        }
                
    }

    public int getSeniority() {
        return seniority;
    }

    public double getSalary() {
        return salary;
    }
    
    
    
    
}
