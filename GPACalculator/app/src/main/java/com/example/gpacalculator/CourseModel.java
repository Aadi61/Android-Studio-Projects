package com.example.gpacalculator;

public class CourseModel {
    private String credits;
    private String grade;
    private String [] creditSpinner;
    private String[] gradeSpinner;
    private int creditSpinnerSelection;
    private int gradeSpinnerSelection;
    public CourseModel(int creditSpinnerSelection ){
        this.creditSpinnerSelection=creditSpinnerSelection;
    }
    public CourseModel(String credits,String grade,String[] creditSpinner, String[] gradeSpinner, int creditSpinnerSelection,int gradeSpinnerSelection) {
    this.credits=credits;
    this.grade=grade;
    this.creditSpinner=creditSpinner;
    this.gradeSpinner=gradeSpinner;
    this.creditSpinnerSelection=creditSpinnerSelection;
    this.gradeSpinnerSelection=gradeSpinnerSelection;
    }
    public String getCredits(){
        return credits;
    }
    public String getGrade(){
        return grade;
    }
    public String[] getCreditSpinner(){
        return creditSpinner;
    }
    public String[] getGradeSpinner(){
        return gradeSpinner;
    }
    public int getCreditSpinnerSelection(){
        return creditSpinnerSelection;
    }

    public int getGradeSpinnerSelection() {
        return gradeSpinnerSelection;
    }

    public void setCreditSpinnerSelection(int creditSpinnerSelection) {
        this.creditSpinnerSelection = creditSpinnerSelection;
    }

    public void setGradeSpinnerSelection(int gradeSpinnerSelection) {
        this.gradeSpinnerSelection = gradeSpinnerSelection;
    }

}