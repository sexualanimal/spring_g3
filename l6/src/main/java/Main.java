import entity.Professional;
import entity.Student;
import factory.StudentCreateFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final int studentsCount = 30;
        final int groupsCount = 3;
        final int professionalScoreLimit = 80;
        final int generalScoreLimit = 50;
        final int generalGroupNumber = 2;
        final int scoreGroupNumber = 1;

        ApplicationContext ctx = new ClassPathXmlApplicationContext( "beans.xml");
        StudentCreateFactory factory = ctx.getBean("factory", StudentCreateFactory.class);


        List<Student> students = factory.getStudents(studentsCount, groupsCount);
        showStudentsFromList(students, "All students");


        List<Professional> professionals = getProfessionals(students, professionalScoreLimit);
        showStudentsFromList(professionals, "Professionals");


        List<Student> studentsFromGroup = getStudentsByGroup(students, generalGroupNumber);
        showStudentsFromList(studentsFromGroup, "Students by group");


        List<Student> studentsWithScoreByGroup = getStudentsWithScore(
                getStudentsByGroup(students, scoreGroupNumber),
                generalScoreLimit,
                true
        );
        showStudentsFromList(studentsWithScoreByGroup, "Students by group with score");
    }

    public static List<Student> getStudentsByGroup(List<? extends Student> students, int group) {
        List<Student> studentsFromGroup = students.stream()
                .filter(student -> student.getGroup().getNumber() == group)
                .collect(Collectors.toList());
        return checkListNPE(studentsFromGroup);
    }

    public static void showStudentsFromList(List<? extends Student> list, String tag) {
        System.out.println(tag + ':');
        list.forEach(System.out::println);
        System.out.println();
    }

    public static List<Student> getStudentsWithScore(List<? extends Student> students, int score, boolean moreThan) {
        List<Student> studentsWithScore = students.stream()
                .filter(student -> {
                    if (moreThan) {
                        return student.getAverageScore() >= score;
                    } else {
                        return student.getAverageScore() <= score;
                    }
                })
                .collect(Collectors.toList());
        return checkListNPE(studentsWithScore);
    }

    public static List checkListNPE(List list) {
        Optional<List> optionalList = Optional.ofNullable(list);
        return optionalList.orElse(new ArrayList<>());
    }

    public static List<Professional> getProfessionals(List<? extends Student> students, int scoreLimit) {
        List<Professional> professionals = getStudentsWithScore(students, scoreLimit, true)
                .stream()
                .map(student -> new Professional(
                        student.getName(),
                        student.getAverageScore(),
                        student.getGroup()
                ))
                .collect(Collectors.toList());
        return checkListNPE(professionals);
    }
}
