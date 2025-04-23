package za.ac.cput.factory;

import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {
    public static Subject buildSubject(Long id, String name) {
        if(id<=0|| Helper.isStringNullorEmpty(name)){
            return null;
        }
        return new Subject.SubjectBuilder().setId(id).setName(name).build();
    }
    public static Subject buildSubject(String name) {
        if( Helper.isStringNullorEmpty(name)){
            return null;
        }
        return new Subject.SubjectBuilder()
                .setName(name).build();
    }
}
