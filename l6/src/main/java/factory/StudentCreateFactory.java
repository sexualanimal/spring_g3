package factory;

import entity.Group;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentCreateFactory {
    private List<Student> students;
    private Names[] names;
    private SecondNames[] secondNames;

    public StudentCreateFactory() {
        this.students = new ArrayList<>();
        names = Names.values();
        secondNames = SecondNames.values();
    }

    public List<Student> getStudents(int studentCount, int groupsCount){
        Random random = new Random();

        for (int i = 0; i < studentCount; i++) {
            String name = names[random.nextInt(names.length - 1)]
                    + " "
                    + secondNames[random.nextInt(secondNames.length - 1)];

            students.add(new Student(
                    name,
                    1 + random.nextInt(100),
                    new Group(1 + random.nextInt(groupsCount))
            ));
        }
        return students;
    }

    private enum Names {
        Ivan,
        Petr,
        Vicror,
        Vladimir,
        Alexander,
        Gleb,
        Anton,
        Dmitriy,
        Anna,
        Yana,
        Katerina,
        Alexandra
    }

    private enum SecondNames {
        Pertov,
        Vasiliev,
        Manchenco,
        Pipka,
        Varenik,
        Uzbekov,
        Kolesov,
        Matrin,
        Kolovrat,
        Zuev,
        Tsyba,
        Goleniev
    }
}
