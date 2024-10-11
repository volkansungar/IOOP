public class FootballPlayer extends Player {
    int assists;
    int goals;

    public FootballPlayer() {}

    public FootballPlayer(String name, String position, String team, int energy, int assists, int goals) {
        super(name, position, team, energy);
        this.assists = assists;
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "assists=" + assists +
                ", goals=" + goals +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", energy=" + energy +
                '}';
    }

    @Override
    public void doTraining() {
        energy -= 50;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
