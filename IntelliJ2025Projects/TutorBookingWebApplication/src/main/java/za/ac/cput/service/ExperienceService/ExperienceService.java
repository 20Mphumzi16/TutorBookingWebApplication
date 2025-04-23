package za.ac.cput.service.ExperienceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Experience;
import za.ac.cput.repository.ExperienceRepository;

import java.util.List;

@Service
public class ExperienceService implements IExperienceService {

    private ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Experience create(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience read(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    @Override
    public Experience update(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public boolean delete(Long id) {
       experienceRepository.deleteById(id);
       return !experienceRepository.existsById(id);
    }

    @Override
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }




}
