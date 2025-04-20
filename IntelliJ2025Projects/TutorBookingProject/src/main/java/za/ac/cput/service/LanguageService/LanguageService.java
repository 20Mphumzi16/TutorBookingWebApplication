package za.ac.cput.service.LanguageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Language;
import za.ac.cput.repository.LanguageRepository;

import java.util.List;

@Service
public class LanguageService implements ILanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language create(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language read(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public Language update(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public boolean delete(Long id) {
        languageRepository.deleteById(id);
        return !languageRepository.existsById(id);
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }
}
