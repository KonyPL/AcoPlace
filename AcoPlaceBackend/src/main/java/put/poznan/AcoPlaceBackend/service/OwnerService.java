package put.poznan.AcoPlaceBackend.service;

import org.springframework.stereotype.Service;
import put.poznan.AcoPlaceBackend.model.Owner;
import put.poznan.AcoPlaceBackend.repository.OwnerRepository;

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
