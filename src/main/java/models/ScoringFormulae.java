package models;

/**
 * Created by Aurimas on 23/09/15.
 * Model for event counting constants
 */
public class ScoringFormulae {

    private String name;

    private float a;
    private float b;
    private float c;

    private Type scoringFormulaeType;

    public ScoringFormulae(String name, Type scoringFormulaeType, float a, float b, float c){
        this.setName(name);
        this.setA(a);
        this.setB(b);
        this.setC(c);
        this.setScoringFormulaeType(scoringFormulaeType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    public Type getScoringFormulaeType() {
        return scoringFormulaeType;
    }

    public void setScoringFormulaeType(Type scoringFormulaeType) {
        this.scoringFormulaeType = scoringFormulaeType;
    }

    public enum Type {
        TRACK, FIELD
    }
}
