package za.ac.cput.service.StudentService;

import za.ac.cput.domain.Student;
import za.ac.cput.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student,Long> {
    List<Student> getAll();
}
