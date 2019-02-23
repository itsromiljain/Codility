package com.example.affirm;

import java.io.Serializable;
import java.util.List;

public class CovenantRule implements Serializable {

    private Float maxDefaultLikelihood;

    private List<String> bannedStates;


    public Float getMaxDefaultLikelihood() {
        return maxDefaultLikelihood;
    }

    public void setMaxDefaultLikelihood(Float maxDefaultLikelihood) {
        this.maxDefaultLikelihood = maxDefaultLikelihood;
    }

    public List<String> getBannedStates() {
        return bannedStates;
    }

    public void setBannedStates(List<String> bannedStates) {
        this.bannedStates = bannedStates;
    }
}
