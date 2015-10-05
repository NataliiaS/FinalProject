package org.sourceit.command.impl.speciality_subject;


import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;
import org.sourceit.entities.SpecialitySubject;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditSpecialitySubjectCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        try {
            Long spSdId = Long.parseLong(request.getParameter("id"));
            SpecialitySubject specialitySubject = provider.getSpecialitySubject(spSdId);
            request.setAttribute("specialitySubject", specialitySubject);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        List<Subject> subjects = null;

        try {
            subjects = provider.getSubjects();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("subjects", subjects);

        List<Profession> professions = null;

        try {
            professions = provider.getProfessions();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("professions", professions);

        return "pages/edit_speciality_subjects.jsp";
    }
}
