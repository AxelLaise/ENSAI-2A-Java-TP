package fr.ensai.running.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ensai.running.model.Competition;
import fr.ensai.running.repository.CompetitionRepository;

@Service
public class CompetitionService {
    
    private static final Logger log = LoggerFactory.getLogger(CompetitionService.class);

    @Autowired
    private CompetitionRepository competitionRepository;

    /**
     * Find a Competition by id
     * 
     * @return Competition or null if not found
     */
    public Competition findById(Long id) {
        return competitionRepository.findById(id).orElse(null);
    }

    /**
     * List of all Competitions
     */
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    /**
     * Delete an Athlete by id
     */
    public void deleteById(Long id) {
        competitionRepository.deleteById(id);
        log.warn("Athlete {} deleted", id);
    }
}
