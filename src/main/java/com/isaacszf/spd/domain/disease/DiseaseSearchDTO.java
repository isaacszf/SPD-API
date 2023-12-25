package com.isaacszf.spd.domain.disease;

import java.util.ArrayList;
import java.util.List;

public class DiseaseSearchDTO {
    private String name = "";
    private List<String> states = new ArrayList<>();
    private List<String> methodsOfContagion = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<String> getStates() {
        return states;
    }

    public List<String> getMethodsOfContagion() { return methodsOfContagion; };
}
