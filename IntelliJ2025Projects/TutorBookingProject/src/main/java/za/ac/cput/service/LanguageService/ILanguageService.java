package za.ac.cput.service.LanguageService;

import za.ac.cput.domain.Language;
import za.ac.cput.service.IService;

import java.util.List;

public interface ILanguageService extends IService <Language,Long> {
    List<Language> getAll();
}
