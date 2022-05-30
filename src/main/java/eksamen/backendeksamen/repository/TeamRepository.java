package eksamen.backendeksamen.repository;

import eksamen.backendeksamen.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    Team findTeamByTeamName(String teamName);

}
