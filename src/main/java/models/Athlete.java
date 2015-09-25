package models;

import utils.ScoreUtils;

/**
 * Created by Aurimas on 23/09/15.
 * Athlete model
 */
public class Athlete {

    private String name;

    private float meter100;
    private float longJump;
    private float shotPut;
    private float highJump;
    private float meter400;
    private float hurdles;
    private float discusThrow;
    private float poleVault;
    private float javelinThrow;
    private float meter1500;

    private int totalScore;
    private String place;

    public Athlete(String name,
                   float meter100,
                   float longJump,
                   float shotPut,
                   float highJump,
                   float meter400,
                   float hurdles,
                   float discusThrow,
                   float poleVault,
                   float javelinThrow,
                   float meter1500) {

        this.setName(name);
        this.setMeter100(meter100);
        this.setLongJump(longJump);
        this.setShotPut(shotPut);
        this.setHighJump(highJump);
        this.setMeter400(meter400);
        this.setHurdles(hurdles);
        this.setDiscusThrow(discusThrow);
        this.setPoleVault(poleVault);
        this.setJavelinThrow(javelinThrow);
        this.setMeter1500(meter1500);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMeter100() {
        return meter100;
    }

    public void setMeter100(float meter100) {
        this.meter100 = meter100;
        countScore(meter100, "100m");
    }

    public float getLongJump() {
        return longJump;
    }

    public void setLongJump(float longJump) {
        this.longJump = longJump;
        //Multiple by 100 because jumping is in centimetres
        countScore(longJump * 100, "longJump");
    }

    public float getShotPut() {
        return shotPut;
    }

    public void setShotPut(float shotPut) {
        this.shotPut = shotPut;
        countScore(shotPut, "shotPut");
    }

    public float getHighJump() {
        return highJump;
    }

    public void setHighJump(float highJump) {
        this.highJump = highJump;
        //Multiple by 100 because jumping is in centimetres
        countScore(highJump * 100, "highJump");
    }

    public float getMeter400() {
        return meter400;
    }

    public void setMeter400(float meter400) {
        this.meter400 = meter400;
        countScore(meter400, "400m");
    }

    public float getHurdles() {
        return hurdles;
    }

    public void setHurdles(float hurdles) {
        this.hurdles = hurdles;
        countScore(hurdles, "hurdles");
    }

    public float getDiscusThrow() {
        return discusThrow;
    }

    public void setDiscusThrow(float discusThrow) {
        this.discusThrow = discusThrow;
        countScore(discusThrow, "discusThrow");
    }

    public float getPoleVault() {
        return poleVault;
    }

    public void setPoleVault(float poleVault) {
        this.poleVault = poleVault;
        //Multiple by 100 because jumping is in centimetres
        countScore(poleVault * 100, "poleVault");
    }

    public float getJavelinThrow() {
        return javelinThrow;
    }

    public void setJavelinThrow(float javelinThrow) {
        this.javelinThrow = javelinThrow;
        countScore(javelinThrow, "javelinThrow");
    }

    public float getMeter1500() {
        return meter1500;
    }

    public void setMeter1500(float meter1500) {
        this.meter1500 = meter1500;
        countScore(meter1500, "1500m");
    }

    public int getTotalScore() {
        return totalScore;
    }

    private void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * Counting total score by event and result
     * @param result
     * @param event
     */
    private void countScore(float result, String event){
        ScoringFormulae scoringFormulae = ScoreUtils.formulas.get(event);
        int score = ScoreUtils.event(result, scoringFormulae);
        setTotalScore(getTotalScore() + score);
    }
}
