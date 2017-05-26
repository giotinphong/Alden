package com.project.sonnguyen.alden.data;

/**
 * Created by sonnguyen on 5/22/17.
 */

public class StudentInformation {
    private String Name;
    private String Bithday;
    private String Classname;
    private String Teacher;
    private String Parentname;
    private String Parentnumber;
    private String Teachernumber;
    private int Numofclass;
    private String Studentcode;
    private String Avatarurl;

    public String getAvatarurl() {
        return Avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        Avatarurl = avatarurl;
    }

    public String getStudentcode() {
        return Studentcode;
    }

    public void setStudentcode(String studentcode) {
        Studentcode = studentcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBithday() {
        return Bithday;
    }

    public void setBithday(String bithday) {
        Bithday = bithday;
    }

    public String getClassname() {
        return Classname;
    }

    public void setClassname(String classname) {
        Classname = classname;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getParentname() {
        return Parentname;
    }

    public void setParentname(String parentname) {
        Parentname = parentname;
    }

    public String getParentnumber() {
        return Parentnumber;
    }

    public void setParentnumber(String parentnumber) {
        Parentnumber = parentnumber;
    }

    public String getTeachernumber() {
        return Teachernumber;
    }

    public void setTeachernumber(String teachernumber) {
        Teachernumber = teachernumber;
    }

    public int getNumofclass() {
        return Numofclass;
    }

    public void setNumofclass(int numofclass) {
        Numofclass = numofclass;
    }



    public StudentInformation() {
    }
}
