package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.Flatmate;
import put.poznan.AcoPlaceBackend.repository.FlatmateRepository;

import java.util.List;

@Service
public class FlatmateService {
    private final FlatmateRepository flatmateRepository;

    public FlatmateService(FlatmateRepository flatmateRepository) {
        this.flatmateRepository = flatmateRepository;
    }

    public List<Flatmate> getAllFlatmates() {
        return flatmateRepository.findAll();
    }
}
