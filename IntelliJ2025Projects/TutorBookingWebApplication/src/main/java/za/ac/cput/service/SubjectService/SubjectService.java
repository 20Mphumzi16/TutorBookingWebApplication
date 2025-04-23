package za.ac.cput.service.SubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject read(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public boolean delete(Long id) {
        subjectRepository.deleteById(id);
        return !subjectRepository.existsById(id);
    }


    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

}
