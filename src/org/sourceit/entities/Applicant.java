package org.sourceit.entities;

public class Applicant extends Entity {

    private long professionId;
    private String lastName;
    private String firstName;
    private long entranceYear;
    private String professionName;

    public Applicant() {
    }

    public Applicant(long professionId, String lastName, String firstName, long entranceYear) {
        this.professionId = professionId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.entranceYear = entranceYear;
    }

    public long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(long entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "professionId=" + professionId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", entranceYear=" + entranceYear +
                '}';
    }
}
