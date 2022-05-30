package eksamen.backendeksamen.services;

import eksamen.backendeksamen.dto.RiderRequest;
import eksamen.backendeksamen.dto.RiderResponse;
import eksamen.backendeksamen.entities.Rider;
import eksamen.backendeksamen.entities.Team;
import eksamen.backendeksamen.repository.RiderRepository;
import eksamen.backendeksamen.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {

    RiderRepository riderRepository;
    TeamRepository teamRepository;

    public RiderService(RiderRepository riderRepository, TeamRepository teamRepository) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    public RiderResponse getRider(int id){
        return new RiderResponse(riderRepository.findById(id).orElseThrow());
    }

    public List<RiderResponse> getAllRiders(String teamName){

        List<Rider> riders;
        if(teamName!=null){
            riders= riderRepository.findRiderByTeam_TeamName(teamName);
        }
        else {
            riders= riderRepository.findAll();
        }

        return RiderResponse.getRidersFromEntities(riderRepository.findAll());
    }

    public RiderResponse createRider(RiderRequest rr){
       Team t = teamRepository.findTeamByTeamName(rr.getTeamName());
       teamRepository.save(t);


       Rider newR = new Rider(rr.getRiderName(),t);
       riderRepository.save(newR);

       RiderResponse riderResponse = new RiderResponse(newR);
       return  riderResponse;
    }

    public RiderResponse editRider(RiderRequest radUpdate, int riderId){
        Team t = teamRepository.findTeamByTeamName(radUpdate.getTeamName());
        teamRepository.save(t);

        Rider r = riderRepository.findById(riderId).orElseThrow();
       r.setRiderName(r.getRiderName());
        r.setTeam(t);
        return new RiderResponse((riderRepository.save(r)));
    }


    public void updateTeam(int riderId, Team newTeam){
        Rider rider = riderRepository.findById(riderId).orElseThrow();
        rider.setTeam(newTeam);
        riderRepository.save(rider);
    }
public void deleteRider(int riderId){
        riderRepository.deleteById(riderId);
}



    /*

     */
}
