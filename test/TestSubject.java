import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Subject;

import java.util.List;

public class TestSubject {

    List<Subject> subjects;
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Before
    public void before() throws Exception {
        try {
            subjects = provider.getSubjects();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSubjectNotNull() throws Exception {
        Assert.assertNotNull(provider.getSubject(3));
    }

//    @Test (expected = Exception.class)
//    public void testGetSubjectException() throws Exception{
//        provider.getSubject(10000);
//    }

    @Test (expected = Exception.class)
    public void testSaveSubjectNotNull() throws Exception{
        Subject subject = new Subject();
        provider.saveSubject(subject);
    }

    @Test
    public void testGetSubjectsNotNull(){
        Assert.assertNotNull(subjects);
    }

    @Test
    public void testSaveSubject() throws Exception {
        Subject subject = new Subject();
        subject.setSubjectName("HTML");
        provider.saveSubject(subject);
    }

    @Test
    public void testSaveEditSubject() throws Exception {
        Subject subject = provider.getSubject(3);
        subject.setSubjectName("CSS");
        provider.saveSubject(subject);
    }

    @Test
    public void testDeleteSubject() throws Exception {
        provider.deleteSubject(7);
    }
}
