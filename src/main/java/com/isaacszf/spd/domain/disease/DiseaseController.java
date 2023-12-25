package com.isaacszf.spd.domain.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.isaacszf.spd.handlers.ApplicationException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @GetMapping
    public List<Disease> getAll() {
        return diseaseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disease> getById(@PathVariable Long id) {
        Optional<Disease> disease = diseaseRepository.findById(id);

        if (disease.isEmpty()) {
            throw new ApplicationException(String.format("Disease with id=%d not found", id), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(disease.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Disease> updateById(@PathVariable Long id, @RequestBody DiseaseDTO fields) {
        Optional<Disease> optDisease = diseaseRepository.findById(id);

        if (optDisease.isEmpty()) {
            throw new ApplicationException(String.format("Disease with id=%d not found", id), HttpStatus.NOT_FOUND);
        }

        Disease disease = optDisease.get();

        if (fields.getImgUrl() != null) disease.setImgUrl(fields.getImgUrl());
        if (fields.getDescription() != null) disease.setDescription(fields.getDescription());
        if (fields.getTreatment() != null) disease.setTreatment(fields.getTreatment());
        disease.setUpdatedAt(new Date());

        diseaseRepository.save(disease);
        return ResponseEntity.ok(disease);
    }

    @PostMapping("/create")
    public ResponseEntity<Disease> createDisease(@RequestBody DiseaseDTO fields) {
        try { 
            Disease disease = new Disease(
                fields.getName(),
                fields.getImgUrl(),
                fields.getDescription(),
                fields.getEtiologicalAgent(),
                fields.getMethodsOfContagion(),
                fields.getSymptoms(),
                fields.getTreatment(),
                fields.getCommonBrazilianStates()
            );

            diseaseRepository.save(disease);
       
            return ResponseEntity.ok(disease);
        } catch (DataIntegrityViolationException e) {
            throw new ApplicationException("field is missing (commonBrazilianStates or methodsOfContagion)", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public List<Disease> getAllWithFilters(@RequestBody DiseaseSearchDTO filters) {
        List<Disease> diseases = diseaseRepository.findAll();

        return diseases.stream()
            .filter(disease -> matchesName(disease, filters))
            .filter(disease -> matchesStates(disease, filters))
            .filter(disease -> matchesMethodsOfContagion(disease, filters))
            .collect(Collectors.toList());
    }
    
    private boolean matchesName(Disease disease, DiseaseSearchDTO filters) {
        String name = filters.getName().toLowerCase();
        return name.isEmpty() || disease.getName().toLowerCase().contains(name);
    }
    
    private boolean matchesStates(Disease disease, DiseaseSearchDTO filters) {
        List<String> states = filters.getStates();
        return states == null || states.isEmpty() || disease.getCommonBrazilianStates().stream()
                .map(Enum::name)
                .anyMatch(states::contains);
    }
    
    private boolean matchesMethodsOfContagion(Disease disease, DiseaseSearchDTO filters) {
        List<String> methodsOfContagion = filters.getMethodsOfContagion();
        return methodsOfContagion == null || methodsOfContagion.isEmpty() || disease.getMethodsOfContagion().stream()
                .map(Enum::name)
                .anyMatch(methodsOfContagion::contains);
    }
}
