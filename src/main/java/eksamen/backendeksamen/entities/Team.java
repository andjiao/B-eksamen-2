package eksamen.backendeksamen.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String teamName;
    int numbMembers;
    int wins;

    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
    private Set<Rider> riders = new HashSet<>();


    public void addRider(Rider rider) {
        this.riders.add(rider);
        rider.setTeam(this);
    }

    public void addRiders(Set<Rider> riders){
        this.riders.addAll(riders);
        for(Rider rider: riders){
            rider.setTeam(this);
        }
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    /*
        */
}
