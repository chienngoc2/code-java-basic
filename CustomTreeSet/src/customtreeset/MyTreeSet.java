/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customtreeset;

import java.util.Set;
import java.util.TreeSet;

class MyTreeSet extends TreeSet<Student> {
    

    // Phương thức tìm các sinh viên có GPA trên 3
    public Set<Student> getStudentsHaveGPAAbove3() {
        Set<Student> results = new TreeSet<>();
        for (Student s : this) {
            if (s.getGPA() > 3.0) {
                results.add(s);
            }
        }
        return results;
    }

    // Phương thức tìm sinh viên theo ID
    public Student findStudentById(int id) {
        for (Student s : this) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }}