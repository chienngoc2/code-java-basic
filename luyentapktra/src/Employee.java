/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void updateSalary() {
        if (this.seniority >= 3 && this.seniority <=5) {
            this.salary = this.salary + 0.3 *this.salary;
        }
        else if(this.seniority >= 6 && this.seniority <=10) {
            this.salary = this.salary + 0.5 *this.salary;
        }
        else if(this.seniority >=10) {
            this.salary = this.salary + 1 *this.salary;
        }
        
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        if (seniority <= 0) {
            this.seniority = 1;

        }
    }
    @Override
    public String toString(){
        return this.id+","+this.name+","+String.format("%.2f", this.salary)+","+this.seniority;
    }
}
