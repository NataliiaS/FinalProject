package org.sourceit.command.impl.applicant_result;


import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.ApplicantResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveApplicantResultCommand implements ICommand {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        ApplicantResult applicantResult = new ApplicantResult();

        applicantResult.setMark((int) Long.parseLong(request.getParameter("mark")));
        applicantResult.setSubjectId(Long.parseLong(request.getParameter("subject_id")));
        applicantResult.setApplicantId(Long.parseLong(request.getParameter("applicant_id")));

        if (request.getParameter("applicant_result_id") != null) {
            applicantResult.setId(Long.parseLong(request.getParameter("applicant_result_id")));
        }

        try {
            provider.saveApplicantResult(applicantResult);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=applicantResults";
    }
}
