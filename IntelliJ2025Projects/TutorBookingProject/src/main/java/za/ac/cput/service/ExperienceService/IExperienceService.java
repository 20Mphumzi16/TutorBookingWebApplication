package za.ac.cput.service.ExperienceService;

import za.ac.cput.domain.Experience;
import za.ac.cput.service.IService;

import java.util.List;

public interface IExperienceService extends IService <Experience,Long>{
    List<Experience>getAll();

}
