import models.ScoringFormulae;
import org.junit.Assert;
import org.junit.Test;
import utils.ScoreUtils;

/**
 * Created by Aurimas on 25/09/15.
 */
public class ScoreUtilsTest {

    @Test
    public void test(){
        ScoringFormulae meter100 = ScoreUtils.formulas.get("100m");
        ScoringFormulae longJump = ScoreUtils.formulas.get("longJump");

        Assert.assertEquals(536, ScoreUtils.event(12.61f, meter100));
        Assert.assertEquals(382, ScoreUtils.event(500.0f, longJump));

        Assert.assertEquals(0, ScoreUtils.event(500.0f, null));

        try{
            ScoreUtils.event(5.0f, longJump);
            Assert.fail();
        } catch (NumberFormatException n) {

        }

    }

}
