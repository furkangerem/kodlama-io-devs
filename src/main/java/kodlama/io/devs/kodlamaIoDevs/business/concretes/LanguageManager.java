package kodlama.io.devs.kodlamaIoDevs.business.concretes;

import kodlama.io.devs.kodlamaIoDevs.business.abstracts.LanguageService;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.GetLanguageByIdRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.responses.language.GetAllLanguageResponse;
import kodlama.io.devs.kodlamaIoDevs.business.responses.language.GetLanguageByIdResponse;
import kodlama.io.devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.kodlamaIoDevs.entities.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public String add(CreateLanguageRequest createLanguageRequest) throws Exception {

        Language language = new Language();
        if (createLanguageRequest.getName().isEmpty()) {
            throw new Exception("Programming language name can't be empty!");
        } else if (!this.isExist(createLanguageRequest)) {
            throw new Exception("Programming language already exists!");
        } else {
            language.setName(createLanguageRequest.getName());
            this.languageRepository.save(language);
            return "Successfully added.";
        }
    }

    @Override
    public String delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {

        List<Language> languages = languageRepository.findAll();
        for (Language language : languages) {
            if (deleteLanguageRequest.getId() == language.getId()) {
                language.setId(deleteLanguageRequest.getId());
                this.languageRepository.delete(language);
                return "Deleted.";
            }
        }
        throw new Exception("You can't delete not existing data!");
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {

        List<Language> languages = languageRepository.findAll();
        for (Language language : languages) {
            if (language.getName().equalsIgnoreCase(updateLanguageRequest.getOldName())) {
                language.setName(updateLanguageRequest.getNewName());
                this.languageRepository.save(language);
                break;
            }
        }
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {

        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguageResponse> languageResponses = new ArrayList<GetAllLanguageResponse>();

        for (Language language : languages) {

            GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());

            languageResponses.add(responseItem);
        }
        return languageResponses;
    }

    @Override
    public GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguageByIdRequest) throws Exception {

        List<Language> languages = languageRepository.findAll();
        GetLanguageByIdResponse responseItem = new GetLanguageByIdResponse();
        List<GetLanguageByIdResponse> getLanguageByIdResponses = new ArrayList<GetLanguageByIdResponse>();

        for (Language language : languages) {
            if (language.getId() == getLanguageByIdRequest.getId()) {
                responseItem.setName(language.getName());
                getLanguageByIdResponses.add(responseItem);
            }
        }
        return getLanguageByIdResponses.get(0); // Everytime, only one data will be sent to the end user.
    }

    @Override
    public boolean isExist(CreateLanguageRequest createLanguageRequest) {

        List<Language> languages = languageRepository.findAll();
        for (Language language : languages) {
            if (language.getName().equalsIgnoreCase(createLanguageRequest.getName())) {
                return false;
            }
        }
        return true;
    }
}
