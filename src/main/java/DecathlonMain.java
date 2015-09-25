import models.Athlete;
import services.ReadDataService;
import services.SortDataService;
import services.WriteDataService;
import services.impl.ReadFromCSVServiceImpl;
import services.impl.SortAthletesServiceImpl;
import services.impl.WriteToXMLServiceImpl;

import java.util.List;

/**
 * Created by Aurimas on 23/09/15.
 */
public class DecathlonMain {

    public static void main(String[] args) {

        if (args.length > 1) {

            System.out.println("Starting");

            String inputPath = args[0];
            String outputPath = args[1];
            //Reading from csv and creating Athlete objects
            ReadDataService readDataService = new ReadFromCSVServiceImpl();
            List<Athlete> athletes = readDataService.read(inputPath);

            //Sorting Athletes by score and setting places
            SortDataService sortDataService = new SortAthletesServiceImpl();
            athletes = sortDataService.sort(athletes);

            //Writing data to xml file
            WriteDataService writeDataService = new WriteToXMLServiceImpl();
            writeDataService.write(outputPath, athletes);

            System.out.println("Finished");
        }

    }
}
