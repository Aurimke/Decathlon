package services;

import models.Athlete;

import java.util.List;

/**
 * Created by Aurimas on 24/09/15.
 * Service for writing results
 */
public interface WriteDataService {

    /**
     * Dedicated to write results into file
     * @param filePath
     * @param athletes
     */
    void write(String filePath, List<Athlete> athletes);

}
