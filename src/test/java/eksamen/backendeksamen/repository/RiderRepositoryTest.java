package eksamen.backendeksamen.repository;

import eksamen.backendeksamen.entities.Rider;
import eksamen.backendeksamen.entities.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RiderRepositoryTest {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    RiderRepository riderRepository;

    @BeforeEach
    void setUp() {

        teamRepository.deleteAll();
        riderRepository.deleteAll();;

        Team t4 = new Team("Jumbo-Visma",30);

        Rider r1 = new Rider("Albert",30);
        Rider r2 = new Rider("Bo",20);
        Rider r3 = new Rider("Carl",43);
        Rider r4 = new Rider("David",46);

        t4.addRiders(Set.of(r1,r2,r3,r4));

        teamRepository.saveAll(List.of(
                t4
        ));
    }

    @Test
    public void getAllRiders(){
        List<Rider> riderList = riderRepository.findAll();
        assertEquals(4,riderList.size());
    }

    @Test
    public void getRidersFromTeam(){
        List<Rider> riderList = riderRepository.findRiderByTeam_TeamName("Jumbo-Visma");
        assertEquals(4,riderList.size());
    }

    @Test
    public void getRiderFromTeamNotOk(){
        List<Rider> riderList = riderRepository.findRiderByTeam_TeamName("nisse");
        assertEquals(0,riderList.size());
    }
}