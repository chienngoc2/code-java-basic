



public class Generics {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {

        // Sử dụng lớp Person<T> với kiểu Integer
        Person<Integer> person1 = new Person<>(1, 20);  
        System.out.println("Thong tin person1: " + person1.getId() + "-" + person1.getAge());  

        // Sử dụng lớp Person<T> với kiểu Double
        Person<Double> personDouble = new Person<>(1.5, 35);  
        System.out.println("Thong tin personDouble: " + personDouble.getId() + "-" + personDouble.getAge());  

        // Sử dụng lớp Person<T> với kiểu String
        Person<String> personString = new Person<>("2", 40);  
        System.out.println("Thong tin personString: " + personString.getId() + "-" + personString.getAge());  
    }  
}


    
    

