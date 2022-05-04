package model;

public class StudentMarks implements Comparable<StudentMarks>{
    String studentId;
    String studentFName;
    String studentSName;
    int ct1;
    int ct2;
    int ct3;
    double moduleMark;

    public StudentMarks(){
        this.studentId = "";
        this.studentFName = "";
        this.studentSName = "";
        this.ct1 = 0;
        this.ct2 = 0;
        this.ct3 = 0;
        this.moduleMark = calculateModuleMark();
    }

    public StudentMarks(double moduleMarkData) {
        this.moduleMark = moduleMarkData;
    }

    public String getStudentID() {
        return this.studentId;
    }

    public void setStudentID(String studentID) {
        this.studentId = studentID;
    }

    public String getFName() {
        return this.studentFName;
    }

    public void setFName(String givenName) {
        this.studentFName = givenName;
    }

    public String getSName() {
        return this.studentSName;
    }

    public void setSName(String lastname) {
        this.studentSName = lastname;
    }

    public int getCT1() {
        return this.ct1;
    }

    public void setCT1(int CT1) {
        this.ct1 = CT1;
    }

    public int getCT2() {
        return this.ct2;
    }

    public void setCT2(int CT2) {
        this.ct2 = CT2;
    }

    public int getCT3() {
        return this.ct3;
    }

    public void setCT3(int CT3) {
        this.ct3 = CT3;
    }

    public double getModuleMark() {
        return this.moduleMark;
    }

    public void setModuleMark(double moduleMark) {
        this.moduleMark = moduleMark;
    }

    public double calculateModuleMark(){
        double mm = ((this.ct1*0.3) + (this.ct2*0.3) + (this.ct3*0.4));
        return mm;
    }

    public String CSVFormat(){
        String outputStr = this.studentId + "," + this.studentFName + "," + this.studentSName + "," + this.moduleMark;
        return outputStr;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "Student ID: '" + this.studentId + '\'' +
                ", Student Name: '" + this.studentFName + "' '" + this.studentSName + '\'' +
                ", module mark: '" + this.moduleMark + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentMarks anEntry) {
        return this.studentId.compareToIgnoreCase(anEntry.getStudentID());
    }
}
