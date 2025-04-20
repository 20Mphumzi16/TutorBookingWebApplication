package za.ac.cput.service.TutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tutor;
import za.ac.cput.repository.TutorRepository;

import java.util.List;
@Service

public class TutorService implements ITutorService {

private TutorRepository tutorRepository;

@Autowired
    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor create(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor read(Long aLong) {
        return tutorRepository.findById(aLong).orElse(null);
    }

    @Override
    public Tutor update(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public boolean delete(Long aLong) {
        tutorRepository.deleteById(aLong);
        return !tutorRepository.existsById(aLong);
    }

    @Override
    public List<Tutor> getAll() {
        return tutorRepository.findAll();
    }
}
