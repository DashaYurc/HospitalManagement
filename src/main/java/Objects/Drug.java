package Objects;

public class Drug {
    private int id;
    private String name;

    public Drug(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Drug(){
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
}
