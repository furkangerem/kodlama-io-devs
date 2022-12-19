package kodlama.io.devs.kodlamaIoDevs.business.abstracts;

import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.GetTechnologyByIdRequest;
import kodlama.io.devs.kodlamaIoDevs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.kodlamaIoDevs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.devs.kodlamaIoDevs.business.responses.technology.GetTechnologyByIdResponse;

import java.util.List;

public interface TechnologyService {

    String add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    String delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
    String update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
    List<GetAllTechnologyResponse> getAll();
    GetTechnologyByIdResponse getById(GetTechnologyByIdRequest getTechnologyByIdRequest) throws Exception;
    boolean isExist(CreateTechnologyRequest createTechnologyRequest);
}