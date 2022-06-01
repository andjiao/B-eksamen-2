package eksamen.backendeksamen.api;

import eksamen.backendeksamen.dto.RiderRequest;
import eksamen.backendeksamen.dto.RiderResponse;
import eksamen.backendeksamen.entities.Team;
import eksamen.backendeksamen.repository.RiderRepository;
import eksamen.backendeksamen.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/* denne påvirker kun i broser, så man kan stadig kører controller i postman*/
@CrossOrigin
@RequestMapping("/api/riders")
public class RiderController {

    @Autowired
    RiderService riderService;

    @GetMapping
    public List<RiderResponse> getAllRiders(@RequestParam(value = "team", required = false) String teamName){
        return riderService.getAllRiders(teamName);
    }

    @GetMapping("/{id}")
    public RiderResponse getRider(@PathVariable int id) throws  Exception{
        return  riderService.getRider(id);
    }

    @PostMapping
    public RiderResponse createRider(@RequestBody RiderRequest riderRequest){
        return riderService.createRider(riderRequest);
    }

    @PutMapping("/{id}")
    public RiderResponse editRider(@RequestBody RiderRequest riderRequest, @PathVariable int id){
        return riderService.editRider(riderRequest,id);
    }

    @PatchMapping("/{id}/{newTeam}")
    public String editTeam(@PathVariable int id, @PathVariable String newTeam) throws Exception{
        riderService.updateTeam(id, newTeam);
        return "{\"message\":\"Succes\"}";
    }
    @DeleteMapping("/{id}")
    public String deleteRider(@PathVariable int id){
        riderService.deleteRider(id);
        return "{\"message\":\"Succes\"}";
    }

}
