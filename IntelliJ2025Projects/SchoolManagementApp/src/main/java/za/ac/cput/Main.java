package za.ac.cput;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

     Contact con1=new Contact.ContactBuilder().setId(1L).setEmail("0658436358").setPhone("mphumzimbula@gmail.com").build();

     System.out.println(con1);
    }
}