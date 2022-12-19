package kodlama.io.devs.kodlamaIoDevs.dataAccess.abstracts;

import kodlama.io.devs.kodlamaIoDevs.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    
}