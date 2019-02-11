package org.m1.web.rest.example.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.m1.web.rest.example.errors.EtudiantNonTrouveException;
import org.m1.web.rest.example.model.Etudiant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("etudiants")
public class EtudiantsController {
    
    private Map<String, Etudiant> etudiants = new HashMap<>();
    
    @PostConstruct
    private void init() {
        Etudiant jdoe = new Etudiant();
        jdoe.setId("jdoe");
        jdoe.setNom("Doe");
        jdoe.setPrenom("John");
        etudiants.put(jdoe.getId(), jdoe);
    }
    
    @GetMapping
    public List<Etudiant> getEtudiants() {
        return etudiants.values().stream().collect(Collectors.toList());
    }
    
    @GetMapping(path = "/{id}")
    public Etudiant getEtudiant(@PathVariable String id) {
        return etudiants.get(id);
    }
    
    @PostMapping
    public Etudiant creerEtudiant(@RequestBody Map<String, Object> body) {
        String id = UUID.randomUUID().toString();
        Etudiant etudiant = new Etudiant();
        etudiant.setId(id);
        etudiant.setNom((String) body.get("nom"));
        etudiant.setPrenom((String) body.get("prenom"));
        etudiants.put(id, etudiant);
        return etudiant;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> majEtudiant(@PathVariable String id, @RequestBody Etudiant etudiant) {
        if (etudiants.containsKey(etudiant.getId())) {
            etudiants.put(etudiant.getId(), etudiant);
            return ResponseEntity.ok(etudiant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'étudiant n'a pas été trouvé");
        }
    }
    
    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable String id) {
        if (etudiants.containsKey(id)) {
            etudiants.remove(id);
        } else {
            // Mauvais car renvoie une erreur 500
            throw new RuntimeException(new EtudiantNonTrouveException());
        }
    }
    
    
    
    
}
