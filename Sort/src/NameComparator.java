import java.util.Comparator;
public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1,Student student2){
        String nameOne = student1.getName();
        String nameTwo = student2.getName();
        return nameOne.compareTo(nameTwo);
    }
}
