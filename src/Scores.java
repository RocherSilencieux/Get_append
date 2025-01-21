import java.util.ArrayList;
import java.util.List;

public class Scores {

    public static void ascendingSort(List<String[]> players) {
        for (int i = 1; i < players.size(); i++) {
            String[] current = players.get(i);
            int j = i - 1;

            while (j >= 0 && Integer.parseInt(players.get(j)[1]) > Integer.parseInt(current[1])) {
                players.set(j + 1, players.get(j));
                j--;
            }
            players.set(j + 1, current);
        }
    }

    public static void descendingSort(List<String[]> players) {
        for (int i = 1; i < players.size(); i++) {
            String[] current = players.get(i);
            int j = i - 1;

            while (j >= 0 && Integer.parseInt(players.get(j)[1]) < Integer.parseInt(current[1])) {
                players.set(j + 1, players.get(j));
                j--;
            }
            players.set(j + 1, current);
        }
    }



    public static void displayTop10(List<String[]> players) {
        System.out.println("\nTop 10 Players:");
        for (int i = 0; i < Math.min(10, players.size()); i++) {
            System.out.println((i + 1) + ". " + players.get(i)[0] + " - " + players.get(i)[1]);
        }
    }

    public static void main(String[] args) {
        List<String[]> players = new ArrayList<>();
        players.add(new String[]{"Alice", "120"});
        players.add(new String[]{"Bob", "150"});
        players.add(new String[]{"Charlie", "90"});
        players.add(new String[]{"Diana", "110"});
        players.add(new String[]{"Eve", "200"});
        players.add(new String[]{"Frank", "140"});
        players.add(new String[]{"Grace", "95"});
        players.add(new String[]{"Hank", "130"});
        players.add(new String[]{"Ivy", "180"});
        players.add(new String[]{"Jack", "170"});
        players.add(new String[]{"Kevin", "80"});

        //ascendingSort(players);
        descendingSort(players);

        displayTop10(players);
    }
}