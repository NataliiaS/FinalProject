package org.sourceit.entities;

public class SpecialitySubject extends Entity {

    private long professionSubject;
    private long subjectId;
    private String subject;
    private String profession;

    public long getProfessionSubject() {
        return professionSubject;
    }

    public void setProfessionSubject(long professionSubject) {
        this.professionSubject = professionSubject;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject (String subject){
        this.subject = subject;
    }

    public String getProfession(){
        return profession;
    }

    public void setProfession(String profession){
        this.profession = profession;
    }
}
