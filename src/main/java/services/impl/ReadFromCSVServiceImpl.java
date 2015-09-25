package services.impl;

import models.Athlete;
import services.ReadDataService;
import utils.ParseUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aurimas on 23/09/15.
 * Implementation of ReadDataService interface for reading csv files.
 */
public class ReadFromCSVServiceImpl implements ReadDataService {

    public static final String CSV_SEPARATOR = ";";
    public static final int LINE_LENGTH = 11;


    @Override
    public List<Athlete> read(String filePath) {
        System.out.println("Start read data from file path: " + filePath);
        BufferedReader br = null;
        String line = "";
        List<Athlete> athletes = new ArrayList<Athlete>();

        try {

            br = new BufferedReader(new FileReader(filePath));
            // Reading file
            while ((line = br.readLine()) != null) {

                String[] info = line.split(CSV_SEPARATOR);
                //Checking if line has all info
                if (info.length != LINE_LENGTH) {
                    //Skip line (incorrect data)
                    System.out.println("Skipped line.");
                    continue;
                }
                // Creating Athlete object
                Athlete athlete = new Athlete(info[0], ParseUtils.getSeconds(info[1]), ParseUtils.getFloat(info[2]),
                        ParseUtils.getFloat(info[3]), ParseUtils.getFloat(info[4]), ParseUtils.getSeconds(info[5]),
                        ParseUtils.getSeconds(info[6]), ParseUtils.getFloat(info[7]), ParseUtils.getFloat(info[8]),
                        ParseUtils.getFloat(info[9]), ParseUtils.getSeconds(info[10]));

                athletes.add(athlete);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Finish read data");
        return athletes;
    }

}
