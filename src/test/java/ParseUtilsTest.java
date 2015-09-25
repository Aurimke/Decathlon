import exceptions.MyException;
import org.junit.Assert;
import org.junit.Test;
import utils.ParseUtils;

/**
 * Created by Aurimas on 25/09/15.
 */
public class ParseUtilsTest {

    @Test
    public void test(){
        Assert.assertEquals(5.5f, ParseUtils.getFloat("5.5"), 0f);
        Assert.assertEquals(0.0f, ParseUtils.getFloat("0.0"), 0f);
        Assert.assertEquals(0f, ParseUtils.getFloat("0"), 0f);
        Assert.assertEquals(-50.50f, ParseUtils.getFloat("-50.50"), 0f);
        try {
            ParseUtils.getFloat("");
            Assert.fail();
        } catch (NumberFormatException e) {

        }
        try {
            ParseUtils.getFloat("dgf");
            Assert.fail();
        } catch (NumberFormatException e) {

        }

        try {
            Assert.assertEquals(5.5f, ParseUtils.getSeconds("5.5"), 0f);
            Assert.assertEquals(0.0f, ParseUtils.getSeconds("0.0.0"), 0f);
            Assert.assertEquals(305.5f, ParseUtils.getSeconds("5.5.5"), 0f);
            Assert.assertEquals(0.0f, ParseUtils.getSeconds(null), 0f);
        } catch (MyException m) {
            Assert.fail();
        }

        try {
            ParseUtils.getSeconds("5.5.5.5");
            Assert.fail();
        } catch (MyException m) {

        }

        try {
            ParseUtils.getSeconds("5");
            Assert.fail();
        } catch (MyException m) {

        }

        try {
            ParseUtils.getSeconds("5,5");
            Assert.fail();
        } catch (MyException m) {

        }

        Assert.assertEquals("5.50", ParseUtils.getMin(5.5f));
        Assert.assertEquals("5.5.50", ParseUtils.getMin(305.5f));
        Assert.assertEquals("0.00", ParseUtils.getMin(0.0f));

        Assert.assertEquals("", ParseUtils.getMin(null));
        Assert.assertEquals(0.0f, ParseUtils.getFloat(null), 0f);
    }

}
