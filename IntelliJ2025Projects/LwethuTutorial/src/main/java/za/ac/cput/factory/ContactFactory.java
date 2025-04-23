package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {
   
    public static Contact buildContact(Long id,String email,String phone){
        if(id<=0||Helper.isStringNullOrEmpty(email)||Helper.isStringNullOrEmpty(phone)){
            return null;
        }
        return new Contact.ContactBuilder()
                .setId(id)
                .setEmail(email)
                .setPhone(phone)
                .build();
    }
}
