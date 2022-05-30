package eksamen.backendeksamen.services;

import eksamen.backendeksamen.dto.RiderResponse;
import eksamen.backendeksamen.dto.TeamResponse;
import eksamen.backendeksamen.repository.RiderRepository;
import eksamen.backendeksamen.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public TeamService(RiderRepository riderRepository, TeamRepository teamRepository) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    public TeamResponse getTeam(int id){
        return new TeamResponse(teamRepository.findById(id).orElseThrow());
    }

    public List<TeamResponse> getAllTeams(){
        return TeamResponse.getTeamFromEntities(teamRepository.findAll());
    }
}
