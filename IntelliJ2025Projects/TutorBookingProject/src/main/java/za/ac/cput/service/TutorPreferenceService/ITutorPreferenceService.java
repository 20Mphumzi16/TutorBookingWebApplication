package za.ac.cput.service.TutorPreferenceService;

import za.ac.cput.domain.TutorPreferences;
import za.ac.cput.service.IService;

import java.util.List;

public interface ITutorPreferenceService extends IService <TutorPreferences,Long>{
    List<TutorPreferences>getAll();
}
