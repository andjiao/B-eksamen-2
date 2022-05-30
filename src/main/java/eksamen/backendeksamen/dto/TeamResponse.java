package eksamen.backendeksamen.dto;

import eksamen.backendeksamen.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor

public class TeamResponse {
    private int id;
    private String teamName;
    private int numbMembers;

    public TeamResponse(Team team){
        this.id=team.getId();
        this.teamName= team.getTeamName();
        this.numbMembers=team.getNumbMembers();
    }

    public static List<TeamResponse> getTeamFromEntities(List<Team> teams){
        return teams.stream().map(team-> new TeamResponse(team)).collect(Collectors.toList());
    }
}
