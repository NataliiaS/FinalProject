package org.sourceit.util;

import org.sourceit.command.ICommand;
import org.sourceit.command.impl.applicant.*;
import org.sourceit.command.impl.applicant_result.*;
import org.sourceit.command.impl.profession.*;
import org.sourceit.command.impl.speciality_subject.*;
import org.sourceit.command.impl.subject.*;

import java.util.HashMap;
import java.util.Map;

/**
 * You must finish implementation of this class.
 * Add following commands:
 * -- ApplicantCommand(finish implementation)
 * -- AddApplicantCommand
 * -- SaveApplicantCommand
 * -- DeleteApplicantCommand
 * -- EditApplicantCommand
 * <p>
 * TODO: And your task is add similar classes for Subject, SpecialitySubject, ApplicantResult
 */
public enum Chooser {

    INSTANCE;

    private Map<String, ICommand> commandMap = new HashMap<>();

    private Chooser() {

        // commands for profession
        commandMap.put("professions", new ProfessionCommand());
        commandMap.put("addProfession", new AddProfessionCommand());
        commandMap.put("saveProfession", new SaveProfessionCommand());
        commandMap.put("deleteProfession", new DeleteProfessionCommand());
        commandMap.put("editProfession", new EditProfessionCommand());

        // commands for applicants
        commandMap.put("applicants", new ApplicantCommand());
        commandMap.put("addApplicant", new AddApplicantCommand());
        commandMap.put("saveApplicant", new SaveApplicantCommand());
        commandMap.put("deleteApplicant", new DeleteApplicantCommand());
        commandMap.put("editApplicant", new EditApplicantCommand());

        // commands for speciality subject
        commandMap.put("specialitySubjects", new SpecialitySubjectCommand());
        commandMap.put("addSpecialitySubject", new AddSpecialitySubjectCommand());
        commandMap.put("saveSpecialitySubjects", new SaveSpecialitySubjectCommand());
        commandMap.put("deleteSpecialitySubject", new DeleteSpecialitySubjectCommand());
        commandMap.put("editSpecialitySubject", new EditSpecialitySubjectCommand());

        // commands for subject
        commandMap.put("subjects", new SubjectCommand());
        commandMap.put("addSubject", new AddSubjectCommand());
        commandMap.put("saveSubject", new SaveSubjectCommand());
        commandMap.put("deleteSubject", new DeleteSubjectCommand());
        commandMap.put("editSubject", new EditSubjectCommand());

        // commands for applicant results
        commandMap.put("applicantResults", new ApplicantResultCommand());
        commandMap.put("addApplicantResult", new AddApplicantResultCommand());
        commandMap.put("saveApplicantResult", new SaveApplicantResultCommand());
        commandMap.put("deleteApplicantResult", new DeleteApplicantResultCommand());
        commandMap.put("editApplicantResult", new EditApplicantResultCommand());
    }

    public ICommand chooseCommand(String command) {
        return commandMap.get(command);
    }

}
