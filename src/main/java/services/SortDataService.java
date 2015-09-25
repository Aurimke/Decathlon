package services;

import models.Athlete;

import java.util.List;

/**
 * Created by Aurimas on 24/09/15.
 * Service for sorting data
 */
public interface SortDataService {

    /**
     * Sorts Athletes
     * @param athletes
     * @return sorted list
     */
    List<Athlete> sort(List<Athlete> athletes);

}
