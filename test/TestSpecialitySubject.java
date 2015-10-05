import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.SpecialitySubject;

import java.util.List;

public class TestSpecialitySubject {
    List<SpecialitySubject> specialitySubjects;
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Before
    public void before() throws Exception {
        try {
            specialitySubjects = provider.getSpecialitySubjects();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSpecialitySubjectNotNull() throws Exception {
        Assert.assertNotNull(provider.getSpecialitySubject(2));
    }

//    @Test (expected = Exception.class)
//    public void testGetSpecialitySubjectException() throws Exception{
//        provider.getSpecialitySubject(10000);
//    }

    @Test (expected = Exception.class)
    public void testSaveSpecialitySubjectNotNull() throws Exception{
        SpecialitySubject specialitySubject = new SpecialitySubject();
        provider.saveSpecialitySubjects(specialitySubject);
    }

    @Test
    public void testGetSpecialitySubjectsNotNull(){
        Assert.assertNotNull(specialitySubjects);
    }

    @Test
    public void testSaveSpecialitySubject() throws Exception {
        SpecialitySubject specialitySubject = new SpecialitySubject();
        specialitySubject.setProfessionSubject(2);
        specialitySubject.setSubjectId(3);
        provider.saveSpecialitySubjects(specialitySubject);
    }

//    @Test
//    public void testSaveEditSpecialitySubject() throws Exception {
//        SpecialitySubject specialitySubject = provider.getSpecialitySubject(4);
//        specialitySubject.setProfessionSubject(2);
//        provider.saveSpecialitySubjects(specialitySubject);
//    }

    @Test
    public void testDeleteSpecialitySubject() throws Exception {
        provider.deleteSpecialitySubject(7);
    }
}
