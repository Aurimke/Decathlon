package services;

import models.Athlete;

import java.util.List;

/**
 * Created by Aurimas on 23/09/15.
 * Service for reading data
 */
public interface ReadDataService {

    /**
     * Dedicated to read Athlete data from file
     * @param filePath
     * @return
     */
    List<Athlete> read(String filePath);
}
