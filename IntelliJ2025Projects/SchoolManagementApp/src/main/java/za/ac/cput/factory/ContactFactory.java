package za.ac.cput.factory;

import za.ac.cput.domain.Contact;

public class ContactFactory {

    public static Contact buildContact(Long id,String email,String phone){

        if(id<=0||email.isEmpty()||phone.isEmpty()){
            return null;
        }
        return new Contact.ContactBuilder()
                .setId(id)
                .setEmail(email)
                .setPhone(phone)
                .build();



    }

}
