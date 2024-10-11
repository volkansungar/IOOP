public class BasketballPlayer extends Player {
    int assists;
    int rebounds;
    int points;

    public BasketballPlayer() {}

    public BasketballPlayer(String name, String position, String team, int energy, int assists, int rebounds, int points) {
        super(name, position, team, energy);
        this.assists = assists;
        this.rebounds = rebounds;
        this.points = points;
    }

    @Override
    public String toString() {
        return "BasketballPlayer{" +
                "assists=" + assists +
                ", rebounds=" + rebounds +
                ", points=" + points +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", energy=" + energy +
                '}';
    }

    @Override
    public void doTraining() {
        energy -= 30;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
