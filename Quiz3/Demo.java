public class Demo {
    public static void main(String[] args) {
        Player[] players = new Player[4];
        FootballPlayer football1 = new FootballPlayer("Messi", "CF", "Argentina", 150, 365, 828);
        FootballPlayer football2 = new FootballPlayer("Ronaldo", "CF", "Portugal", 130, 268, 885);
        BasketballPlayer basketball1 = new BasketballPlayer("LeBron", "SF", "Lakers", 90, 11009, 11185, 40474);
        BasketballPlayer basketball2 = new BasketballPlayer("Shaquille", "Center", "Lakers", 100, 3026, 13099, 28596);
        players[0] = football1;
        players[1] = football2;
        players[2] = basketball1;
        players[3] = basketball2;

        for (Player player : players) {
            System.out.println(player.toString());
        }
        for (Player player: players) {
            player.doTraining();
        }
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }




}
