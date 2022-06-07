package eksamen.backendeksamen.entities;

import eksamen.backendeksamen.dto.RiderRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String riderName;
    int time;

    /*
    time%60 = restSekunder
    time/60 = minutter
    minutter/24 = timer
    minutter%24
    * */


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team;

    public Rider (String riderName, int time){

        this.riderName=riderName;
        this.time=time;
    }

    public Rider(String riderName, Team team, int time){
        this.riderName=riderName;
        this.team=team;
        this.time=time;
    }

    public Rider (RiderRequest riderRequest){
        this.riderName= riderRequest.getRiderName();
        this.time=riderRequest.getTime();
    }

}
