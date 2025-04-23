package za.ac.cput.repository;

import za.ac.cput.domain.Contact;

import java.util.List;

public interface IContactRepository extends IRepository<Contact,Long>{
    List<Contact> getAll();
}
