import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;

import java.util.List;

public class TestApplicant {

    List<Applicant> applicants;
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Before
    public void before() throws Exception {
        try {
            applicants = provider.getApplicants();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetApplicantNotNull() throws Exception {
        Assert.assertNotNull(provider.getApplicant(3));
    }

//    @Test (expected = Exception.class)
//    public void testGetApplicantException() throws Exception{
//        provider.getApplicant(10000);
//    }

    @Test (expected = Exception.class)
    public void testSaveApplicantNotNull() throws Exception{
        Applicant applicant = new Applicant();
        provider.saveApplicant(applicant);
   }

    @Test
    public void testGetApplicantsNotNull(){
        Assert.assertNotNull(applicants);
    }

    @Test
    public void testSaveApplicant() throws Exception {
       Applicant applicant = new Applicant(2, "Ostashko", "Anastasiia", 2008);
       provider.saveApplicant(applicant);
    }

    @Test
    public void testSaveEditApplicant() throws Exception {
        Applicant applicant = provider.getApplicant(3);
        applicant.setEntranceYear(2020);
        provider.saveApplicant(applicant);
    }

    @Test
    public void testDeleteApplicant() throws Exception {
        provider.deleteApplicant(7);
    }
}
