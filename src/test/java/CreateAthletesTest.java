import models.Athlete;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Aurimas on 25/09/15.
 */
public class CreateAthletesTest {

    @Test
    public void test(){
        Athlete athlete1 = new Athlete("1", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assert.assertEquals(0, athlete1.getTotalScore());

        Athlete athlete2 = new Athlete("2", 12.61f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Assert.assertEquals(918, athlete2.getTotalScore());

    }
}
