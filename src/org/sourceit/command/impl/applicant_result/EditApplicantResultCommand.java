package org.sourceit.command.impl.applicant_result;


import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditApplicantResultCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        try {
            Long applicantResultId = Long.parseLong(request.getParameter("id"));
            ApplicantResult applicantResult = provider.getApplicantResult(applicantResultId);
            request.setAttribute("applicantResult", applicantResult);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        List<Applicant> applicants = null;

        try {
            applicants = provider.getApplicants();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("applicants", applicants);

        List <Subject> subjects = null;

        try {
            subjects = provider.getSubjects();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("subjects", subjects);

        return "pages/edit_applicant_result.jsp";
    }
}
