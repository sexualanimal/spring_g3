public class Student {
    private String name;
    private int averageScore;
    private Group group;

    public Student(String name, int averageScore, Group group) {
        this.name = name;
        this.averageScore = averageScore;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", averageScore=" + getAverageScore() +
                ", group=" + getGroup().getNumber() +
                '}';
    }
}
