import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.ApplicantResult;

import java.util.List;

public class TestApplicantResult {
    List<ApplicantResult> applicantResults;
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Before
    public void before() throws Exception {
        try {
            applicantResults = provider.getApplicantResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetApplicantResultNotNull() throws Exception {
        Assert.assertNotNull(provider.getApplicantResult(9));
    }

//    @Test (expected = Exception.class)
//    public void testGetApplicantResultException() throws Exception{
//        provider.getApplicantResult(10000);
//    }

    @Test (expected = Exception.class)
    public void testSaveApplicantResultNotNull() throws Exception{
        ApplicantResult applicantResult = new ApplicantResult();
        provider.saveApplicantResult(applicantResult);
    }

    @Test
    public void testGetApplicantResultsNotNull(){
        Assert.assertNotNull(applicantResults);
    }

    @Test
    public void testSaveApplicantResult() throws Exception {
        ApplicantResult applicantResult = new ApplicantResult();
        applicantResult.setSubjectId(3);
        applicantResult.setApplicantId(3);
        applicantResult.setMark(12);
        provider.saveApplicantResult(applicantResult);
    }

//    @Test
//    public void testSaveEditApplicant() throws Exception {
//        ApplicantResult applicantResult = provider.getApplicantResult(18);
//        applicantResult.setMark(11);
//        provider.saveApplicantResult(applicantResult);
//    }

    @Test
    public void testDeleteApplicantResult() throws Exception {
        provider.deleteApplicantResult(22);
    }
}
