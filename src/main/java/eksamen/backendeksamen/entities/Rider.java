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
    //int age;
    //String nation;
    //int time;

    //Mountain point
    //int mPoint;

    //Spring point
    //int sPoint;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team;

    public Rider (String ridername){
        this.riderName=ridername;
    }

    public Rider(String riderName, Team team){
        this.riderName=riderName;
        this.team=team;
    }

    public Rider (RiderRequest riderRequest){
        this.riderName= riderRequest.getRidername();
    }

}
