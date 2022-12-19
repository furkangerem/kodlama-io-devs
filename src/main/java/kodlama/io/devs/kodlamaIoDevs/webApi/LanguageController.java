package kodlama.io.devs.kodlamaIoDevs.webApi;

import kodlama.io.devs.kodlamaIoDevs.business.abstracts.LanguageService;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.GetLanguageByIdRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.kodlamaIoDevs.business.responses.language.GetAllLanguageResponse;
import kodlama.io.devs.kodlamaIoDevs.business.responses.language.GetLanguageByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.add(createLanguageRequest);
    }

    @PutMapping("/update")
    public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
        languageService.update(updateLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
        languageService.delete(deleteLanguageRequest);
    }

    @GetMapping("/getAll")
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getbyid")
    public GetLanguageByIdResponse getById(GetLanguageByIdRequest getLanguageByIdRequest) throws Exception {
        return languageService.getById(getLanguageByIdRequest);
    }
}