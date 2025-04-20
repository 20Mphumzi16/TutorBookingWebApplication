package za.ac.cput.service.AvailabilityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Availability;
import za.ac.cput.repository.AvailabilityRepository;

import java.util.List;

@Service
public class AvailabilityService implements IAvailabilityService {

    private AvailabilityRepository availabilityRepository;

    @Autowired
    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public Availability create(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public Availability read(Long id) {
        return availabilityRepository.findById(id).orElse(null);
    }

    @Override
    public Availability update(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public boolean delete(Long id) {
        availabilityRepository.deleteById(id);
        return !availabilityRepository.existsById(id);
    }


    @Override
    public List<Availability> getAll() {
        return availabilityRepository.findAll();
    }

}
