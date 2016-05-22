package com.lgb.wechat.arc.util.api.json.kc;

public class RestNowStudentCourseInfo {
    private String studentName;
    private String departmentName;
    private String majorName;
    private String courseName;
    private String courseRoom;
    private String courseTime;
    private int courseId;
    private String studentCardNum;

    public void setStudentCardNum(String studentCardNum) {
        this.studentCardNum = studentCardNum;
    }

    public String getStudentCardNum() {

        return studentCardNum;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {

        return courseId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getStudentName() {

        return studentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public String getCourseTime() {
        return courseTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("姓名 : ").append(getStudentName()).append(".\n")
                .append("学号 : ").append(getStudentCardNum()).append(".\n")
                .append("系名 : ").append(getDepartmentName()).append(".\n")
                .append("专业 : ").append(getMajorName()).append(".\n")
                .append("课程名 : ").append(getCourseName()).append(".\n")
                .append("上课教室 : ").append(getCourseRoom()).append(".\n")
                .append("上课时间 : ").append(getCourseTime()).append(".\n");

        return builder.toString();
    }
}
