package za.ac.cput.factory;

import za.ac.cput.domain.Language;
import za.ac.cput.util.Helper;

public class LanguageFactory {
    public static Language buildLanguage(Long id,String name) {
        if(id<=0|| Helper.isStringNullorEmpty(name)){
            return null;
        }
        return new Language.LanguageBuilder()
                .setId(id)
                .setName(name)
                .build();
    }

    public static Language buildLanguage(String name) {
        if( Helper.isStringNullorEmpty(name)){
            return null;
        }
        return new Language.LanguageBuilder()

                .setName(name)
                .build();
    }
}
