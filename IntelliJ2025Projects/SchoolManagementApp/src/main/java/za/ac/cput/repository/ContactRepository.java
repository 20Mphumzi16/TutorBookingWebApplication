package za.ac.cput.repository;

import za.ac.cput.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository implements IContactRepository {

           private final ArrayList<Contact> contacts;

            public ContactRepository() {
                contacts = new ArrayList<>();
            }

    @Override
    public Contact create(Contact contact) {

                if(contact!=null){
                    contacts.add(contact);
                    return contact;
                }
                return null;

    }

    @Override
    public Contact read(Long aLong) {
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<Contact> getAll() {
        return contacts;
    }
}
