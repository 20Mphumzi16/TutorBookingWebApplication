package za.ac.cput.service.EducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Education;
import za.ac.cput.repository.EducationRepository;

import java.util.List;

@Service
public class EducationService implements IEducationService {

    private EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public Education create(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public Education read(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    @Override
    public Education update(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public boolean delete(Long id) {
        educationRepository.deleteById(id);
        return !educationRepository.existsById(id);
    }


    @Override
    public List<Education> getAll() {
        return educationRepository.findAll();
    }
}
