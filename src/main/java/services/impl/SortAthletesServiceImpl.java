package services.impl;

import models.Athlete;
import services.SortDataService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aurimas on 24/09/15.
 * Implementation of SortDataService interface for sorting Athletes by ascending order of their places
 */
public class SortAthletesServiceImpl implements SortDataService {

    @Override
    public List<Athlete> sort(List<Athlete> athletes) {
        System.out.println("Start sort");
        if (athletes == null) {
            return new ArrayList<Athlete>();
        }
        // sorting by total score
        AthletesScoreComparator athletesScoreComparator = new AthletesScoreComparator();
        Collections.sort(athletes, athletesScoreComparator);

        // setting places
        int lastPlace = 0;
        int lastScore = -1;
        int repeats = 0;
        for (int i = 0; i < athletes.size(); i++) {
            Athlete athlete = athletes.get(i);
            int score = athlete.getTotalScore();
            // checking if sharing places
            if (lastScore == score) {
                repeats += 1;
                continue;
            }
            // setting shared places
            if (repeats != 0) {
                setRange(athletes, lastPlace, repeats);
                lastPlace += repeats;
            }

            // setting place
            lastPlace += 1;
            lastScore = score;
            repeats = 0;
            athlete.setPlace("" + lastPlace);
        }

        // if last places was shared than setting shared places
        if (lastPlace != athletes.size()) {
            setRange(athletes, lastPlace, repeats);
        }
        System.out.println("Finish sort");
        return athletes;
    }

    /**
     * Setting shared places
     * @param athletes
     * @param lastPlace
     * @param repeats
     */
    private void setRange(List<Athlete> athletes, int lastPlace, int repeats){
        int repeatsEnd = lastPlace + repeats;
        for (int j = lastPlace - 1; j < repeatsEnd; j++) {
            athletes.get(j).setPlace(lastPlace  + "-" + repeatsEnd);
        }
    }

}
