package com.entiy;

public class Teacher
{
    private int id;

    private int userId;

    private String school;

    private String depart;

    private String teacherNo;

    private String teacherName;

    private String createTime;

    private String updateTime;

    private String professional;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return this.userId;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public String getSchool(){
        return this.school;
    }
    public void setDepart(String depart){
        this.depart = depart;
    }
    public String getDepart(){
        return this.depart;
    }
    public void setTeacherNo(String teacherNo){
        this.teacherNo = teacherNo;
    }
    public String getTeacherNo(){
        return this.teacherNo;
    }
    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }
    public String getTeacherName(){
        return this.teacherName;
    }
    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }
    public String getCreateTime(){
        return this.createTime;
    }
    public void setUpdateTime(String updateTime){
        this.updateTime = updateTime;
    }
    public String getUpdateTime(){
        return this.updateTime;
    }
    public void setProfessional(String professional){
        this.professional = professional;
    }
    public String getProfessional(){
        return this.professional;
    }
}
