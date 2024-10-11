public abstract class Player {
    String name;
    String position;
    String team;
    int energy;

    public Player() {}

    public Player(String name, String position, String team, int energy) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", energy=" + energy +
                '}';
    }

    public abstract void doTraining();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
