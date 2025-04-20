package za.ac.cput.service.EducationService;

import za.ac.cput.domain.Education;
import za.ac.cput.service.IService;

import java.util.List;

public interface IEducationService extends IService <Education,Long>{
    List<Education> getAll();
}
