/*
* Name: Meena Anwar
* netID: manwar20
* G#: 01327318
* Lecture section: 003
* Lab section: 206
 */ 

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Gradebook implements Comparator<StudentGrades> {
    private Collection<StudentGrades> grades;

    public Gradebook() {
        grades = new ArrayList<>();
    }

    public void addGrade(StudentGrades sg) {
        grades.add(sg);
    }

    public double average() {
        double total = 0;
        for (StudentGrades sg : grades) {
            total += sg.totalScore();
        }
        return total / grades.size();
    }

    public StudentGrades min() {
        StudentGrades minStudent = grades.iterator().next();
        for (StudentGrades sg : grades) {
            if (sg.totalScore() < minStudent.totalScore()) {
                minStudent = sg;
            }
        }
        return minStudent;
    }

    public StudentGrades max() {
        StudentGrades maxStudent = grades.iterator().next();
        for (StudentGrades sg : grades) {
            if (sg.totalScore() > maxStudent.totalScore()) {
                maxStudent = sg;
            }
        }
        return maxStudent;
    }

    public StudentGrades median() {
        ArrayList<StudentGrades> sortedGrades = new ArrayList<>(grades);
        sortedGrades.sort(this);
        int middleIndex = sortedGrades.size() / 2;
        return sortedGrades.get(middleIndex);
    }

    // Provided part
    public int compare(StudentGrades left, StudentGrades right) {
        return (int) (left.totalScore() - right.totalScore());
    }

    // Provided toString method
    public String toString() {
        String rv = "Grades: [ ";
        for (StudentGrades sg : grades) {
            rv += "(" + sg.getStudentName() + ": " + sg.letterGrade() + "), ";
        }
        rv += "]\n";
        rv += "Max: " + max() + ", Median: " + median() + ", Average: " + average() + ", Min: " + min();
        return rv;
    }
}
