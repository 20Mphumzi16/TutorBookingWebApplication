package za.ac.cput.service.TutorService;

import za.ac.cput.domain.Tutor;
import za.ac.cput.service.IService;

import java.util.List;

public interface ITutorService extends IService <Tutor,Long>{
    List<Tutor> getAll();
}
