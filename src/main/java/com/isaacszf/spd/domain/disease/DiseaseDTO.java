package com.isaacszf.spd.domain.disease;

import java.util.List;

import com.isaacszf.spd.domain.enums.BrazilianState;
import com.isaacszf.spd.domain.enums.MethodContagion;

public class DiseaseDTO {
  private String name;
  private String imgUrl;
  private String etiologicalAgent;
  private String description;
  private List<MethodContagion> methodsOfContagion;
  private List<String> symptoms;
  private String treatment;
  private List<BrazilianState> commonBrazilianStates;

  public String getName() {
    return name;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public String getEtiologicalAgent() {
    return etiologicalAgent;
  }

  public String getDescription() {
    return description;
  }

  public List<MethodContagion> getMethodsOfContagion() {
    return methodsOfContagion;
  }

  public List<String> getSymptoms() {
    return symptoms;
  }

  public String getTreatment() {
    return treatment;
  }

  public List<BrazilianState> getCommonBrazilianStates() {
    return commonBrazilianStates;
  }
}
