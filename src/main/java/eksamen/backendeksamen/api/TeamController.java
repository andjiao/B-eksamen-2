package eksamen.backendeksamen.api;

import eksamen.backendeksamen.dto.RiderResponse;
import eksamen.backendeksamen.dto.TeamResponse;
import eksamen.backendeksamen.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/* denne påvirker kun i broser, så man kan stadig kører controller i postman*/
@CrossOrigin
@RequestMapping("teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping
    public List<TeamResponse> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public TeamResponse getTeam(@PathVariable int id) throws  Exception{
        return teamService.getTeam(id);
    }
}
