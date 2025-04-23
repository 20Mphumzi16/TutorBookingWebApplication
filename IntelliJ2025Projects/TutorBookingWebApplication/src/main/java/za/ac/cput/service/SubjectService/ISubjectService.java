package za.ac.cput.service.SubjectService;

import za.ac.cput.domain.Subject;
import za.ac.cput.service.IService;

import java.util.List;

public interface ISubjectService extends IService<Subject,Long> {
    List<Subject>getAll();
}
