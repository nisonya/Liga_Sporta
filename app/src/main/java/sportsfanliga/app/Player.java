package sportsfanliga.app;

public class Player {
    String name, team, photo;
    int age, value;

    public Player(String name, String team, String photo, int age, int value) {
        this.name = name;
        this.team = team;
        this.photo = photo;
        this.age = age;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPhoto() {
        return photo;
    }

    public int getAge() {
        return age;
    }

    public int getValue() {
        return value;
    }
}
