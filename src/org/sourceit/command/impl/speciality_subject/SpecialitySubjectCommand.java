package org.sourceit.command.impl.speciality_subject;


import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.SpecialitySubject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SpecialitySubjectCommand implements ICommand {
    ApplicantDBProvider applicantDBProvider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        List<SpecialitySubject> specialitySubjects = null;

        try {
            specialitySubjects = applicantDBProvider.getSpecialitySubjects();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("specialitySubjects", specialitySubjects);

        return "pages/speciality_subjects.jsp";


    }
}
