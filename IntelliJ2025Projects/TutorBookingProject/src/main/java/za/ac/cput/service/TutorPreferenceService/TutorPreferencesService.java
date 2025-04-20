package za.ac.cput.service.TutorPreferenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TutorPreferences;
import za.ac.cput.repository.TutorPreferencesRepository;

import java.util.List;

@Service
public class TutorPreferencesService implements ITutorPreferenceService {

    private TutorPreferencesRepository repository;

    @Autowired
    public TutorPreferencesService(TutorPreferencesRepository repository) {
        this.repository = repository;
    }

    @Override
    public TutorPreferences create(TutorPreferences preferences) {
        return repository.save(preferences);
    }

    @Override
    public TutorPreferences read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TutorPreferences update(TutorPreferences preferences) {
        return repository.save(preferences);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }


    @Override
    public List<TutorPreferences> getAll() {
        return repository.findAll();
    }
}
