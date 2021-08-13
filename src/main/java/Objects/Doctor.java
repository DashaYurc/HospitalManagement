package Objects;

public class Doctor {
private int id;
private String name;
private int age;
private String specialisation;

public Doctor(){

}

    public Doctor(int id, String name, int age, String specialisation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.specialisation = specialisation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
