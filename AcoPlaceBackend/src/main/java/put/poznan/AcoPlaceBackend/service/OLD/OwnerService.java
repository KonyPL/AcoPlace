package put.poznan.AcoPlaceBackend.service.OLD;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.OLD.Owner;
import put.poznan.AcoPlaceBackend.repository.OLD.OwnerRepository;

import java.util.List;

@Service
public class OwnerService {
    private  final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }
}
