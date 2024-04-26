/*
* Name: Meena Anwar
* netID: manwar20
* G#: 01327318
* Lecture section: 003
* Lab section: 206
 */ 


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentGrades{
    private double participation;
    private double midterm;
    private double finalExam;

    private Collection<Double> labs;
    private Collection<Double> exercises;
    private Collection<Double> projects;
    private List<Double> readings;

    private double participationWeight;
    private double readingsWeight;;
    private double labsWeight;
    private double exercisesWeight;;
    private double projectsWeight;
    private double midtermWeight;
    private double finalExamWeight;

    private String studentName;
    private String gNumber;

    public StudentGrades(String name, String gNumber, double[] weights){
        this.studentName = name;
        this.gNumber = gNumber;
        this.readings = new ArrayList<>();
        this.labs = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.projects = new ArrayList<>();
        setWeights(weights);
    }

    public double getParticipation(){
        return participation;
    }
    public void setParticipation(double participation) {
        this.participation = participation;
    }
    
    public double getMidterm(){
        return midterm;
    }
    public void setMidterm(double midterm){
        this.midterm= midterm;
    }
    public double getFinalExam(){
        return finalExam;
    }
    public void setFinalExam(double finalExam){
        this.finalExam = finalExam;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
   public String getGNumber() {
    return gNumber;
}

public void setGNumber(String gNumber) {
    this.gNumber = gNumber;
}

    public void addReading(double d) {
        readings.add(d);
    }

    public void addLab(double d) {
        labs.add(d);
    }

    public void addExercise(double d) {
        exercises.add(d);
    }

    public void addProject(double d) {
        projects.add(d);
    }
    public void setWeights(double[] weights) {
        this.participationWeight = weights[0];
        this.readingsWeight = weights[1];
        this.labsWeight = weights[2];
        this.exercisesWeight = weights[3];
        this.projectsWeight = weights[4];
        this.midtermWeight = weights[5];
        this.finalExamWeight = weights[6];
    }
    public double unweightedReadingsScore() {
        if (readings.size() < 16) {
            return 100; // Full credit if fewer than 16 items
        }
    
        List<Double> sortedReadings = new ArrayList<>(readings);
        Collections.sort(sortedReadings);
    
        double sum = 0;
        for (int i = 15; i < sortedReadings.size(); i++) {
            sum += sortedReadings.get(i); // Sum all readings starting from the 16th position
        }
    
        return sum / (sortedReadings.size() - 15); // Divide by the total number of scores minus 15
    }

    /*
     * method to calculate unweighted scores
     */
    
    public double unweightedLabsScore() {
        return calculateUnweightedScore(labs);
    }

    public double unweightedExercisesScore() {
        return calculateUnweightedScore(exercises);
    }

    public double unweightedProjectsScore() {
        return calculateUnweightedScore(projects);
    }

    private double calculateUnweightedScore(Collection<Double> scores) {
        if (scores.isEmpty()) {
            return 100;
        }
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }
    /*
     * method to check if final replaces midterm
     */
    
    public boolean finalReplacesMidterm() {
        return finalExam > midterm;
    }
    /*
     * method to check if final is passing
     */
    
    public boolean finalIsPassing() {
        return finalExam >= 60.0;
    }
    /*
     * method to calculate total score
     */
    
     public double totalScore() {
        double total = 0;
        total += participation * participationWeight;
        total += (unweightedReadingsScore() * readingsWeight);
        total += (unweightedLabsScore() * labsWeight);
        total += (unweightedExercisesScore() * exercisesWeight);
        total += (unweightedProjectsScore() * projectsWeight);
    
        // Check if final replaces midterm
        double effectiveMidterm = finalExam > midterm ? finalExam : midterm;
        total += effectiveMidterm * midtermWeight;
        total += finalExam * finalExamWeight;
    
        return total;
    }
    

    // Method to get letter grade
    public String letterGrade() {
        if (!finalIsPassing()) {
            return "F";
        }
        double score = totalScore();
        if (score >= 98) {
            return "A+";
        } else if (score >= 92) {
            return "A";
        } else if (score >= 90) {
            return "A-";
        } else if (score >= 88) {
            return "B+";
        } else if (score >= 82) {
            return "B";
        } else if (score >= 80) {
            return "B-";
        } else if (score >= 78) {
            return "C+";
        } else if (score >= 72) {
            return "C";
        } else if (score >= 70) {
            return "C-";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Override toString method
    @Override
    public String toString() {
        String rv = "Name: " + getStudentName() + "\n";
        rv += "G#: " + getGNumber() + "\n";
        rv += "Participation: " + getParticipation() + "\n";
        rv += "Readings: " + unweightedReadingsScore() + ", " + readings + "\n";
        rv += "Labs: " + unweightedLabsScore() + ", " + labs + "\n";
        rv += "Exercises: " + unweightedExercisesScore() + ", " + exercises + "\n";
        rv += "Projects: " + unweightedProjectsScore() + ", " + projects + "\n";
        rv += "Midterm: " + getMidterm() + "\n";
        rv += "Final Exam: " + getFinalExam() + "\n";
        rv += totalScore() + ", " + letterGrade() + "\n";
        return rv;
    }

}