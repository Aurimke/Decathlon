import models.Athlete;
import org.junit.Assert;
import org.junit.Test;
import services.SortDataService;
import services.impl.SortAthletesServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aurimas on 25/09/15.
 */
public class SortAthletesTest {

    @Test
    public void test(){
        List<Athlete> athletes = new ArrayList<Athlete>();
        SortDataService sortDataService = new SortAthletesServiceImpl();
        athletes = sortDataService.sort(athletes);
        Assert.assertTrue(athletes.isEmpty());
        athletes = sortDataService.sort(null);
        Assert.assertTrue(athletes.isEmpty());

        Athlete athlete1 = new Athlete("last", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Athlete athlete2 = new Athlete("before last", 12.61f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Athlete athlete3 = new Athlete("first", 12.61f, 5.0f, 9.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        Athlete athlete4 = new Athlete("after first", 13.61f, 6.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        athletes.add(athlete1);
        athletes.add(athlete2);
        athletes.add(athlete3);
        athletes.add(athlete4);

        athletes = sortDataService.sort(athletes);
        Assert.assertEquals("first", athletes.get(0).getName());
        Assert.assertEquals("after first", athletes.get(1).getName());
        Assert.assertEquals("before last", athletes.get(2).getName());
        Assert.assertEquals("last", athletes.get(3).getName());

        List<Athlete> places = new ArrayList<Athlete>();
        places.add(athlete1);
        places.add(athlete2);
        places.add(athlete3);
        places.add(athlete2);
        places.add(athlete2);
        places = sortDataService.sort(places);
        Assert.assertEquals("1", places.get(0).getPlace());
        Assert.assertEquals("2-4", places.get(1).getPlace());
        Assert.assertEquals("2-4", places.get(2).getPlace());
        Assert.assertEquals("2-4", places.get(3).getPlace());
        Assert.assertEquals("5", places.get(4).getPlace());

        places = new ArrayList<Athlete>();
        places.add(athlete2);
        places.add(athlete2);
        places.add(athlete2);
        places = sortDataService.sort(places);
        Assert.assertEquals("1-3", places.get(0).getPlace());
        Assert.assertEquals("1-3", places.get(1).getPlace());
        Assert.assertEquals("1-3", places.get(2).getPlace());

    }
}
