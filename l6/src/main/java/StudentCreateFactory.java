import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentCreateFactory {
    private List<Student> students;
    private Names[] names;
    private SecondNames[] secondNames;

    public StudentCreateFactory(int studentCount, int groupsCount) {
        this.students = new ArrayList<>();

        names = Names.values();
        secondNames = SecondNames.values();

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
    }

    enum Names {
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

    enum SecondNames {
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

    public List<Student> getStudents() {
        return students;
    }
}
