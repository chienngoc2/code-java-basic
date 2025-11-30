
import java.util.Comparator;


public class GpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student studentOne, Student studentTwo) {
        if (studentOne.getGpa() > studentTwo.getGpa()) {
            return 1;
        } else if (studentOne.getGpa() < studentTwo.getGpa()) {
            return -1;
        } else {
            return 0;
        }
    }
}
