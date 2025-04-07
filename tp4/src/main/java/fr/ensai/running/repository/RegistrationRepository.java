package fr.ensai.running.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Registration findByAthleteAndCompetition(long id_athlete, long id_competition);

    @Query("select r.athlete.id from Registration r wherer.competition.id = :idCompetition")
    List<Athlete> findAthleteIdByCompetitionId(Long idCompetition);
}