import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;

import java.util.List;

public class TestProfession {
    List<Profession> professions;
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Before
    public void before() throws Exception {
        try {
            professions = provider.getProfessions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetProfessionNotNull() throws Exception {
        Assert.assertNotNull(provider.getProfession(2));
    }

//    @Test (expected = Exception.class)
//    public void testGetProfessionException() throws Exception{
//        provider.getProfession(10000);
//    }

    @Test (expected = Exception.class)
    public void testSaveProfessionNotNull() throws Exception{
        Profession profession = new Profession();
        provider.saveProfession(profession);
    }

    @Test
    public void testGetProfessionsNotNull(){
        Assert.assertNotNull(professions);
    }

    @Test
    public void testSaveProfession() throws Exception {
        Profession profession = new Profession("Phyton");
        provider.saveProfession(profession);
    }

    @Test
    public void testSaveEditProfession() throws Exception {
        Profession profession = provider.getProfession(2);
        profession.setProfessionName("Paskal");
        provider.saveProfession(profession);
    }

    @Test
    public void testDeleteProfession() throws Exception {
        provider.deleteProfession(7);
    }
}
