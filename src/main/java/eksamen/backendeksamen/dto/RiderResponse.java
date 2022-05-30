package eksamen.backendeksamen.dto;

import eksamen.backendeksamen.entities.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class RiderResponse {
    private int id;
     private String riderName;
     private String teamName;
     private int time;

     public RiderResponse (Rider rider){
         this.id = rider.getId();
         this.riderName=rider.getRiderName();
         this.teamName= rider.getTeam().getTeamName();
         this.time=rider.getTime();
     }

     public static List<RiderResponse> getRidersFromEntities(List<Rider> riders) {
         return riders.stream().map(rider -> new RiderResponse(rider)).collect(Collectors.toList());
     }
    }

