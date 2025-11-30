
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyArrayList extends ArrayList<Student> {

    public Student findHighestGPAStudent() {
        Student max = this.get(0);
        for (Student p : this) {
            if (max.getGpa() < p.getGpa()) {
                max = p;
            }
        }
        return max;
    }

    public String calculateAverageGPA() {
        double sum = 0.0;
        double a = 0.0;
        int count = 0;
        for (Student s : this) {
            sum += s.getGpa();
            count++;
        }
        a = sum / count;
        return String.format("%.2f", a);

    }

    public void sortStudentsByGPA() {
        Collections.sort(this, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int d = Double.compare(s1.getGpa(), s2.getGpa());
                return d;
            }
        });
    }

    public Student findStudentById(int id) { // no usages  
        Student student = null;
        for (int i = 0; i < size(); i++) {
            Student s = get(i);
            if (s.getId() == id) {
                student = s;
                break;
            }
        }
        return student;
    }

    public void updateStudentGradeById(int id, double gpa) { // no usages  
        Student student = null;
        for (int i = 0; i < size(); i++) {
            Student s = get(i);
            if (s.getId() == id) {
                student = s;
                break;
            }
        }
        if (student != null) {
            student.setGpa(gpa);
        }
    }

    public void upperCaseAllNames() { // no usages  
        for (int i = 0; i < size(); i++) {
            Student student = get(i);
            String newName = student.getName().toUpperCase();
            student.setName(newName);
        }
    }
    
    public void sortStudentsByGPADescending(){
        this.sort(new Comparator<Student>(){
            @Override
            public int compare(Student s1,Student s2){
                int result = Double.compare(s2.getGpa(), s1.getGpa());
                return result;
            }
        });
    }
}
