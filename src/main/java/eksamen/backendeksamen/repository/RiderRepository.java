package eksamen.backendeksamen.repository;

import eksamen.backendeksamen.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RiderRepository  extends JpaRepository<Rider, Integer> {

    List<Rider> findRiderByTeam_TeamName(String teamName);

}
