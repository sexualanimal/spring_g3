public class Professional extends Student{

    public Professional(String name, int averageScore, Group group) {
        super(name, averageScore, group);
    }

    @Override
    public String toString() {
        return "Professional{" +
                "name='" + getName() + '\'' +
                ", averageScore=" + getAverageScore() +
                ", group=" + getGroup().getNumber() +
                '}';
    }
}
