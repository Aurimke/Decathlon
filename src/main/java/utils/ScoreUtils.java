package utils;

import models.ScoringFormulae;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by Aurimas on 24/09/15.
 * Utility class for counting score
 */
public final class ScoreUtils {

    private ScoreUtils() {
    }

    public static HashMap<String, ScoringFormulae> formulas;

    //Table for events formulae
    static {
        formulas = new HashMap<String, ScoringFormulae>();
        formulas.put("100m", new ScoringFormulae("100m", ScoringFormulae.Type.TRACK, 25.4347f, 18f, 1.81f));
        formulas.put("longJump", new ScoringFormulae("longJump", ScoringFormulae.Type.FIELD, 0.14354f, 220f, 1.4f));
        formulas.put("shotPut", new ScoringFormulae("shotPut", ScoringFormulae.Type.FIELD, 51.39f, 1.5f, 1.05f));
        formulas.put("highJump", new ScoringFormulae("highJump", ScoringFormulae.Type.FIELD, 0.8465f, 75f, 1.42f));
        formulas.put("400m", new ScoringFormulae("400m", ScoringFormulae.Type.TRACK, 1.53775f, 82f, 1.81f));
        formulas.put("hurdles", new ScoringFormulae("hurdles", ScoringFormulae.Type.TRACK, 5.74352f, 28.5f, 1.92f));
        formulas.put("discusThrow", new ScoringFormulae("discusThrow", ScoringFormulae.Type.FIELD, 12.91f, 4f, 1.1f));
        formulas.put("poleVault", new ScoringFormulae("poleVault", ScoringFormulae.Type.FIELD, 0.2797f, 100f, 1.35f));
        formulas.put("javelinThrow", new ScoringFormulae("javelinThrow", ScoringFormulae.Type.FIELD, 10.14f, 7f, 1.08f));
        formulas.put("1500m", new ScoringFormulae("1500m", ScoringFormulae.Type.TRACK, 0.03768f, 480f, 1.85f));
    }

    /**
     * Counting score for track events (faster time produces a better score)
     * @param result
     * @param scoringFormulae
     * @return
     */
    private static int trackEvent(float result, ScoringFormulae scoringFormulae) {
        return new BigDecimal(scoringFormulae.getA() * Math.pow(scoringFormulae.getB() - result, scoringFormulae.getC())).intValue();
    }

    /**
     * Counting score for field events (greater distance or height produces a better score)
     * @param result
     * @param scoringFormulae
     * @return
     */
    private static int fieldEvent(float result, ScoringFormulae scoringFormulae) {
        return new BigDecimal(scoringFormulae.getA() * Math.pow(result - scoringFormulae.getB(), scoringFormulae.getC())).intValue();
    }

    /**
     * Counting score for event
     * @param result
     * @param scoringFormulae
     * @return
     */
    public static int event(float result, ScoringFormulae scoringFormulae) {
        if (scoringFormulae == null || result < 0.00001f) {
            return 0;
        }
        int score = 0;
        switch (scoringFormulae.getScoringFormulaeType()) {
                case TRACK:  score = trackEvent(result, scoringFormulae); break;
                case FIELD: score = fieldEvent(result, scoringFormulae); break;
        }
        return score;
    }
}
