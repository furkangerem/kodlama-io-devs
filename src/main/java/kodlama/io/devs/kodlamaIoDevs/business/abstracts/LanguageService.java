package kodlama.io.devs.kodlamaIoDevs.business.abstracts;

import kodlama.io.devs.kodlamaIoDevs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.GetLanguageByIdRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.responses.language.GetAllLanguageResponse;
import kodlama.io.devs.kodlamaIoDevs.business.responses.language.GetLanguageByIdResponse;

import java.util.List;

public interface LanguageService {

    String add(CreateLanguageRequest createLanguageRequest) throws Exception;
    String delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
    void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
    List<GetAllLanguageResponse> getAll();
    GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguageByIdRequest) throws Exception;
    boolean isExist(CreateLanguageRequest createLanguageRequest);
}