package za.ac.cput.service.AvailabilityService;

import za.ac.cput.domain.Availability;
import za.ac.cput.service.IService;

import java.util.List;

public interface IAvailabilityService extends IService<Availability,Long> {
    List<Availability>getAll();
}
