package com.entiy;

public class TeacherCompetitionVos
{
    private int id;

    private int userId;

    private String title;

    private String content;

    private String startTime;

    private String endTime;

    private int signup;

    private String target;

    private String type;

    private String createTime;

    private String updateTime;

    private int deleted;

    private int aimCompetition;

    private int state;

    private int checked;

    private int schoolId;

    private Teacher teacher;

    private String aimCompetitionName;

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
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }
    public String getStartTime(){
        return this.startTime;
    }
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }
    public String getEndTime(){
        return this.endTime;
    }
    public void setSignup(int signup){
        this.signup = signup;
    }
    public int getSignup(){
        return this.signup;
    }
    public void setTarget(String target){
        this.target = target;
    }
    public String getTarget(){
        return this.target;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
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
    public void setDeleted(int deleted){
        this.deleted = deleted;
    }
    public int getDeleted(){
        return this.deleted;
    }
    public void setAimCompetition(int aimCompetition){
        this.aimCompetition = aimCompetition;
    }
    public int getAimCompetition(){
        return this.aimCompetition;
    }
    public void setState(int state){
        this.state = state;
    }
    public int getState(){
        return this.state;
    }
    public void setChecked(int checked){
        this.checked = checked;
    }
    public int getChecked(){
        return this.checked;
    }
    public void setSchoolId(int schoolId){
        this.schoolId = schoolId;
    }
    public int getSchoolId(){
        return this.schoolId;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public Teacher getTeacher(){
        return this.teacher;
    }
    public void setAimCompetitionName(String aimCompetitionName){
        this.aimCompetitionName = aimCompetitionName;
    }
    public String getAimCompetitionName(){
        return this.aimCompetitionName;
    }
}