package eksamen.backendeksamen.config;

import eksamen.backendeksamen.entities.Rider;
import eksamen.backendeksamen.entities.Team;
import eksamen.backendeksamen.repository.RiderRepository;
import eksamen.backendeksamen.repository.TeamRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Profile("!test")
public class TestData implements ApplicationRunner {

    RiderRepository repository;
    TeamRepository teamRepository;

    public TestData(RiderRepository repository, TeamRepository teamRepository) {
        this.repository = repository;
        this.teamRepository = teamRepository;
    }

    public void makeTestData() {
        Team t1 = new Team("FDJ",28);
        Team t2 = new Team("Cofidis",33);
        Team t3 = new Team("Team DSM",29);
        Team t4 = new Team("Jumbo-Visma",30);

        Rider r1 = new Rider("Albert");
        Rider r2 = new Rider("Bo");
        Rider r3 = new Rider("Carl");
        Rider r4 = new Rider("David");
        Rider r5 = new Rider("Elvis");
        Rider r6 = new Rider("Frederik");
        Rider r7 = new Rider("Gert");
        Rider r8 = new Rider("Hans");


        t1.addRiders(Set.of(r1,r2,r3));
        t2.addRiders(Set.of(r4,r5,r3));
        t3.addRider(r6);
        t4.addRiders(Set.of(r7,r8));

        teamRepository.saveAll(List.of(
                t1,
                t2,
                t3,
                t4
        ));

        /*
        */
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        makeTestData();


    }
}
