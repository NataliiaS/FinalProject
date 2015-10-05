package org.sourceit.db;

import org.sourceit.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public enum ApplicantDBProvider {

    INSTANCE;

    private Connection connection;

    private ApplicantDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root", "toor");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }

    public Applicant getApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;
        Applicant applicant = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM applicant WHERE applicant_id=?");
            preparedStatement.setInt(1, (int) applicantId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setProfessionId(resultSet.getInt("profession_id"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicant;
    }

    public List<Applicant> getApplicants() throws Exception {

        Statement statement = null;
        List<Applicant> applicants = new ArrayList<>();

        try {
            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM applicant");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM applicant JOIN profession ON applicant.PROFESSION_ID=profession.PROFESSION_ID");
            Applicant applicant = null;
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setProfessionName(resultSet.getString("profession_name"));
                applicant.setId(resultSet.getInt("applicant_id"));
                applicants.add(applicant);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return applicants;
    }

    public void saveApplicant(Applicant applicant) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicant.getId() < 1) {
                preparedStatement = connection.prepareStatement("INSERT INTO applicant (profession_id, last_name, first_name, entrance_year) VALUES (?, ?, ?, ?) ");

                preparedStatement.setInt(1, (int) applicant.getProfessionId());
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setString(3, applicant.getFirstName());
                preparedStatement.setInt(4, (int) (applicant.getEntranceYear()));
            } else {
                preparedStatement = connection.prepareStatement("UPDATE applicant SET entrance_year=?, last_name=?, first_name=?, profession_id=? WHERE applicant_id=?");

                preparedStatement.setInt(5, (int) applicant.getId());
                preparedStatement.setInt(4, (int) applicant.getProfessionId());
                preparedStatement.setString(2, applicant.getLastName());
                preparedStatement.setString(3, applicant.getFirstName());
                preparedStatement.setInt(1, (int) (applicant.getEntranceYear()));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant WHERE applicant_id=?");

            preparedStatement.setInt(1, (int) applicantId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Profession getProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;
        Profession profession = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM profession WHERE profession_id=?");
            preparedStatement.setInt(1, (int) professionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return profession;
    }

    public List<Profession> getProfessions() throws Exception {
        Statement statement = null;

        List<Profession> professions = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM profession");
            Profession profession = null;
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
                professions.add(profession);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return professions;
    }

    public void saveProfession(Profession profession) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (profession.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO profession (profession_name) VALUES (?) ");

                preparedStatement.setString(1, profession.getProfessionName());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE profession SET profession_name=? WHERE profession_id=?");

                preparedStatement.setString(1, profession.getProfessionName());
                preparedStatement.setInt(2, (int) profession.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM profession WHERE profession_id=?");

            preparedStatement.setInt(1, (int) professionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public SpecialitySubject getSpecialitySubject(long spSdId) throws Exception {
        PreparedStatement preparedStatement = null;
        SpecialitySubject specialitySubject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM speciality_subject WHERE sp_sb_id=?");
            preparedStatement.setInt(1, (int) spSdId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                specialitySubject.setId(resultSet.getInt("sp_sb_id"));
                specialitySubject.setProfessionSubject(resultSet.getInt("profession_id"));
                specialitySubject.setProfessionSubject(resultSet.getInt("subject_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return specialitySubject;
    }

    public List<SpecialitySubject> getSpecialitySubjects () throws Exception {
        Statement statement = null;

        List<SpecialitySubject> specialitySubjects = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM speciality_subject JOIN subject ON speciality_subject.SUBJECT_ID=subject.SUBJECT_ID JOIN profession ON speciality_subject.profession_id=profession.profession_id");
            SpecialitySubject specialitySubject = null;
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                specialitySubject.setId(resultSet.getInt("sp_sb_id"));
                specialitySubject.setProfession(resultSet.getString("profession_name"));
                specialitySubject.setSubject(resultSet.getString("subject_name"));
                specialitySubjects.add(specialitySubject);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return specialitySubjects;
    }

    public void saveSpecialitySubjects(SpecialitySubject specialitySubject) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (specialitySubject.getId() < 1) {
                preparedStatement = connection.prepareStatement("INSERT INTO speciality_subject (profession_id, subject_id) VALUES (?, ?) ");

                preparedStatement.setInt(1, (int) (specialitySubject.getProfessionSubject()));
                preparedStatement.setInt(2, (int) (specialitySubject.getSubjectId()));
            } else {
                preparedStatement = connection.prepareStatement("UPDATE speciality_subject SET profession_id=?, subject_id=? WHERE sp_sb_id=?");

                preparedStatement.setInt(3, (int) (specialitySubject.getId()));
                preparedStatement.setInt(1, (int) (specialitySubject.getProfessionSubject()));
                preparedStatement.setInt(2, (int) (specialitySubject.getSubjectId()));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteSpecialitySubject(long spSdId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM speciality_subject WHERE sp_sb_id=?");

            preparedStatement.setInt(1, (int) spSdId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    public Subject getSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;
        Subject subject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM subject WHERE subject_id=?");
            preparedStatement.setInt(1, (int) subjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return subject;
    }

    public List<Subject> getSubjects() throws Exception {
        Statement statement = null;

        List<Subject> subjects = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subject");
            Subject subject = null;
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
                subjects.add(subject);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return subjects;
    }

    public void saveSubject(Subject subject) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (subject.getId() < 1) {
                preparedStatement = connection.prepareStatement("INSERT INTO subject (subject_name) VALUES (?) ");

                preparedStatement.setString(1, subject.getSubjectName());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE subject SET subject_name=? WHERE subject_id=?");

                preparedStatement.setString(1, subject.getSubjectName());
                preparedStatement.setInt(2, (int) subject.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM subject WHERE subject_id=?");

            preparedStatement.setInt(1, (int) subjectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public ApplicantResult getApplicantResult(long applicantResultId) throws Exception {
        PreparedStatement preparedStatement = null;
        ApplicantResult applicantResult = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM applicant_result WHERE applicant_result_id=?");
            preparedStatement.setInt(1, (int) applicantResultId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setId(resultSet.getInt("applicant_result_id"));
                applicantResult.setSubjectId(resultSet.getInt("subject_id"));
                applicantResult.setMark(resultSet.getInt("mark"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicantResult;
    }

    public List<ApplicantResult> getApplicantResults() throws Exception {

        Statement statement = null;
        List<ApplicantResult> applicantResults = new ArrayList<>();

        try {
            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM applicant_result");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM applicant_result JOIN subject ON applicant_result.SUBJECT_ID=subject.SUBJECT_ID JOIN applicant ON applicant_result.APPLICANT_ID=applicant.APPLICANT_ID");
            ApplicantResult applicantResult = null;
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setMark(resultSet.getInt("mark"));
                applicantResult.setSubject(resultSet.getString("subject_name"));
                applicantResult.setApplicantFirstName(resultSet.getString("first_name"));
                applicantResult.setApplicantLastName(resultSet.getString("last_name"));
                applicantResult.setId(resultSet.getInt("applicant_result_id"));
                applicantResults.add(applicantResult);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return applicantResults;
    }

    public void saveApplicantResult(ApplicantResult applicantResult) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicantResult.getId() < 1) {
                preparedStatement = connection.prepareStatement("INSERT INTO applicant_result (mark, subject_id, applicant_id) VALUES (?, ?, ?) ");

                preparedStatement.setInt(1, applicantResult.getMark());
                preparedStatement.setInt(2, (int) applicantResult.getSubjectId());
                preparedStatement.setInt(3, (int) applicantResult.getApplicantId());

            } else {
                preparedStatement = connection.prepareStatement("UPDATE applicant_result SET mark=?, subject_id=?, applicant_id=? WHERE applicant_result_id=?");

                preparedStatement.setInt(4, (int) applicantResult.getId());
                preparedStatement.setInt(2, (int) applicantResult.getSubjectId());
                preparedStatement.setInt(3, (int) applicantResult.getApplicantId());
                preparedStatement.setInt(1, (applicantResult.getMark()));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicantResult(long applicantResultId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant_result WHERE applicant_result_id=?");

            preparedStatement.setInt(1, (int) applicantResultId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}
