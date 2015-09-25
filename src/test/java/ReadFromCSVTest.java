import models.Athlete;
import org.junit.Assert;
import org.junit.Test;
import services.ReadDataService;
import services.impl.ReadFromCSVServiceImpl;

import java.util.List;

/**
 * Created by Aurimas on 25/09/15.
 */
public class ReadFromCSVTest {

    @Test
    public void test(){
        ReadDataService readDataService = new ReadFromCSVServiceImpl();
        List<Athlete> athletes = readDataService.read("");
        Assert.assertTrue(athletes.isEmpty());

        athletes = readDataService.read(this.getClass().getClassLoader().getResource("test.txt").getPath());
        Assert.assertEquals(4704, athletes.size());

        athletes = readDataService.read(this.getClass().getClassLoader().getResource("test2.txt").getPath());
        Assert.assertTrue(athletes.isEmpty());

        athletes = readDataService.read(this.getClass().getClassLoader().getResource("test3.txt").getPath());
        Assert.assertEquals(2, athletes.size());

    }
}
