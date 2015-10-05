package org.sourceit.entities;

public class ApplicantResult extends Entity {

    private long applicantId;
    private long subjectId;
    private int mark;
    private String subject;
    private String applicantFirstName;
    private String applicantLastName;

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getApplicantFirstName(){
        return applicantFirstName;
    }
    public void setApplicantFirstName(String applicantFirstName){
        this.applicantFirstName = applicantFirstName;
    }
    public String getApplicantLastName(){
        return applicantLastName;
    }
    public void setApplicantLastName (String applicantLastName){
        this.applicantLastName = applicantLastName;
    }
}
