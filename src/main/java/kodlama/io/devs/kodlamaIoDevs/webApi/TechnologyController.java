package kodlama.io.devs.kodlamaIoDevs.webApi;

import kodlama.io.devs.kodlamaIoDevs.business.abstracts.TechnologyService;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.GetTechnologyByIdRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.devs.kodlamaIoDevs.business.responses.technology.GetTechnologyByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        technologyService.add(createTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        technologyService.update(updateTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        technologyService.delete(deleteTechnologyRequest);
    }

    @GetMapping("/getall")
    public List<GetAllTechnologyResponse> getAll() {
        return technologyService.getAll();
    }

    @GetMapping("/getbyid")
    public GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTechnologyByIdRequest) throws Exception {
        return technologyService.getById(getTechnologyByIdRequest);
    }
}