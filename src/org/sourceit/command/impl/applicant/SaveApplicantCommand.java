package org.sourceit.command.impl.applicant;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveApplicantCommand implements ICommand {
    private ApplicantDBProvider provider1 = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        Applicant applicant = new Applicant();

        applicant.setProfessionId(Long.parseLong(request.getParameter("profession_id")));
        applicant.setEntranceYear(Long.parseLong(request.getParameter("entrance_year")));
        applicant.setFirstName(request.getParameter("first_name"));
        applicant.setLastName(request.getParameter("last_name"));

        if (request.getParameter("applicant_id") != null) {
            applicant.setId(Long.parseLong(request.getParameter("applicant_id")));
        }

        try {
            provider1.saveApplicant(applicant);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=applicants";
    }
}
