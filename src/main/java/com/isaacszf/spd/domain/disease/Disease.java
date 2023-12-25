package com.isaacszf.spd.domain.disease;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.isaacszf.spd.domain.enums.BrazilianState;
import com.isaacszf.spd.domain.enums.MethodContagion;

import java.util.Date;
import java.util.List;

@Table(name = "disease")
@Entity
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(unique = true, nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200, name = "etiological_agent")
    private String etiologicalAgent;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text[]", name = "methods_of_contagion")
    private List<MethodContagion> methodsOfContagion;

    @Column(nullable = false, columnDefinition = "text[]")
    private List<String> symptoms;

    @Column(nullable = false)
    private String treatment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text[]", name = "common_brazilian_states")
    private List<BrazilianState> commonBrazilianStates;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public Disease() {}

    public Disease(
        String name,
        String imgUrl,
        String description,
        String etiologicalAgent,
        List<MethodContagion> methodsOfContagion,
        List<String> symptoms,
        String treatment,
        List<BrazilianState> commonBrazilianStates
    ) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.etiologicalAgent = etiologicalAgent;
        this.methodsOfContagion = methodsOfContagion;
        this.symptoms = symptoms;
        this.treatment = treatment;
        this.commonBrazilianStates = commonBrazilianStates;
    }

    // Getters
    public Long getId() {
        return id;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setImgUrl(String imgUrl) {
      this.imgUrl = imgUrl;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public void setTreatment(String treatment) {
      this.treatment = treatment;
    }

    public void setUpdatedAt(Date date) {
      this.updatedAt = date;
    }
}
