
import java.util.Comparator;

public class IDComparator implements Comparator<Student> {

    @Override
    public int compare(Student studentOne, Student studentTwo) {
        if (studentOne.getId() > studentTwo.getId()) {
            return 1;
        } else if (studentOne.getId() < studentTwo.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
