package kodlama.io.devs.kodlamaIoDevs.business.concretes;

import kodlama.io.devs.kodlamaIoDevs.business.abstracts.TechnologyService;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.GetTechnologyByIdRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.devs.kodlamaIoDevs.business.responses.technology.GetTechnologyByIdResponse;
import kodlama.io.devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.kodlamaIoDevs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.kodlamaIoDevs.entities.Language;
import kodlama.io.devs.kodlamaIoDevs.entities.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyRepository technologyRepository;
    private final LanguageRepository languageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public String add(CreateTechnologyRequest createTechnologyRequest) throws Exception {

        Language language = new Language();
        Technology technology = new Technology();

        if (createTechnologyRequest.getName().isEmpty()) {
            throw new Exception("Technology name can't be empty!");
        } else if (!this.isExist(createTechnologyRequest)) {
            throw new Exception("Technology already exists!");
        } else {
            language.setId(createTechnologyRequest.getId());
            technology.setName(createTechnologyRequest.getName());
            technology.setLanguage(language);
            this.technologyRepository.save(technology);
            return "Successfully added!";
        }
    }

    @Override
    public String delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {

        if (deleteTechnologyRequest.getId() < 0) {
            throw new Exception("You can't enter negative values!");
        }

        List<Technology> technologies = technologyRepository.findAll();
        boolean returnMessage = false;
        for (Technology technology : technologies) {
            if (deleteTechnologyRequest.getId() == technology.getId()) {
                technology.setId(deleteTechnologyRequest.getId());
                this.technologyRepository.delete(technology);
                returnMessage = true;
                return "Successfully deleted!";
            }
        }
        return "You can not delete a record that doesn't exist";
    }

    @Override
    public String update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {

        if (updateTechnologyRequest.getOldName().isEmpty() || updateTechnologyRequest.getNewName().isEmpty()) {
            throw new Exception("You can't enter empty value(s)!");
        }

        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology : technologies) {
            if (technology.getName().equalsIgnoreCase(updateTechnologyRequest.getOldName())) {
                technology.setName(updateTechnologyRequest.getNewName());
                this.technologyRepository.save(technology);
                return "Successfully updated!";
            }
        }
        return "You can not update a record that doesn't exist";
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {

        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologyResponse> technologiesResponse = new ArrayList<GetAllTechnologyResponse>();

        for (Technology technology : technologies) {

            GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());
            responseItem.setLanguageId(technology.getLanguage().getId());

            technologiesResponse.add(responseItem);
        }
        return technologiesResponse;
    }

    @Override
    public GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTechnologyByIdRequest) throws Exception {

        List<Technology> technologies = technologyRepository.findAll();
        GetTechnologyByIdResponse responseItem = new GetTechnologyByIdResponse();
        List<GetTechnologyByIdResponse> technologiesResponse = new ArrayList<GetTechnologyByIdResponse>();

        for (Technology technology : technologies) {
            if (technology.getId() == getTechnologyByIdRequest.getId()) {
                responseItem.setName(technology.getName());
            }
            technologiesResponse.add(responseItem);
        }
        return responseItem;
    }

    @Override
    public boolean isExist(CreateTechnologyRequest createTechnologyRequest) {

        List<Technology> technologies = technologyRepository.findAll();
        for (Technology technology : technologies) {
            if (technology.getName().equalsIgnoreCase(createTechnologyRequest.getName())) {
                return false;
            }
        }
        return true;
    }
}
