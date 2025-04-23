package za.ac.cput.za.ac.cput.factory;

import za.ac.cput.za.ac.cput.domain.Subject;

public class SubjectFactory {
    public static Subject build(Long subjectId,String subjectName,String subjectDescription,int grade){
        if(subjectId<=0||subjectDescription.isEmpty()||subjectName.isEmpty()||grade<=0){
            return null;
        }
        return new Subject.SubjectBuilder()
                .setId(subjectId)
                .setName(subjectName)
                .setSubjectDescription(subjectDescription)
                .setGrade(grade)
                .build();
    }

}
