package services.impl;

import models.Athlete;

import java.util.Comparator;

/**
 * Created by Aurimas on 24/09/15.
 * Comparing Athlete objects by total score
 */
public class AthletesScoreComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete o1, Athlete o2) {
        return o1.getTotalScore() < o2.getTotalScore() ? 1 : (o2.getTotalScore() < o1.getTotalScore() ? -1 : 0);
    }

}
