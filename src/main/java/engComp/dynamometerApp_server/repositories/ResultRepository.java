package engComp.dynamometerApp_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import engComp.dynamometerApp_server.entities.Result;

import java.time.LocalDate;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Integer> {

}
