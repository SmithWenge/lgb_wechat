package com.lgb.wechat.arc.util.api.json.cj;

public class RestStudentScoreInfo {
    private String studentCardNum;
    private String stuName;
    private String stuScore;
    private String courseName;

    public String getStudentCardNum() {
        return studentCardNum;
    }

    public void setStudentCardNum(String studentCardNum) {
        this.studentCardNum = studentCardNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuScore() {
        return stuScore;
    }

    public void setStuScore(String stuScore) {
        this.stuScore = stuScore;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("姓名 : ").append(getStuName()).append(".\n")
                .append("学号 : ").append(getStudentCardNum()).append(".\n")
                .append("课程名 : ").append(getCourseName()).append(".\n")
                .append("成绩 : ").append(getStuScore()).append(".\n");

        return builder.toString();
    }
}
