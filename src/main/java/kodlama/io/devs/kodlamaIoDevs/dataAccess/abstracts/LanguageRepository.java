package kodlama.io.devs.kodlamaIoDevs.dataAccess.abstracts;

import kodlama.io.devs.kodlamaIoDevs.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}