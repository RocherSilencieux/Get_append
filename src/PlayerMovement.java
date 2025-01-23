import java.util.Scanner;

public class PlayerMovement {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Vérifie si une case est vide.
     *
     * @param grid Le tableau représentant la grille de jeu.
     * @param y    La position verticale de la case.
     * @param x    La position horizontale de la case.
     * @return True si la case est vide, false sinon.
     */
    private static boolean isEmptyCase(String[][] grid, int y, int x) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return false; // Hors limites, considéré comme non vide
        }
        return grid[y][x].equals(Grid.emptyCase);
    }

    /**
     * Déplace le joueur vers le haut.
     *
     * @param grid   La grille de jeu.
     * @param player L'objet Player contenant la position actuelle du joueur.
     */
    public static void moveUp(String[][] grid, Player player) {
        if (player.y == 0) {
            System.out.println("You cannot move outside the grid.");
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y - 1, player.x)) {
            System.out.println("The cell above is not empty.");
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.y -= 1;
            grid[player.y][player.x] = temp;
        }
    }

    /**
     * Déplace le joueur vers le bas.
     *
     * @param grid   La grille de jeu.
     * @param player L'objet Player contenant la position actuelle du joueur.
     */
    public static void moveDown(String[][] grid, Player player) {
        if (player.y == grid.length - 1) {
            System.out.println("You cannot move outside the grid.");
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y + 1, player.x)) {
            System.out.println("The cell below is not empty.");
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.y += 1;
            grid[player.y][player.x] = temp;
        }
    }

    /**
     * Déplace le joueur vers la gauche.
     *
     * @param grid   La grille de jeu.
     * @param player L'objet Player contenant la position actuelle du joueur.
     */
    public static void moveLeft(String[][] grid, Player player) {
        if (player.x == 0) {
            System.out.println("You cannot move outside the grid.");
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y, player.x - 1)) {
            System.out.println("The cell to the left is not empty.");
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.x -= 1;
            grid[player.y][player.x] = temp;
        }
    }

    /**
     * Déplace le joueur vers la droite.
     *
     * @param grid   La grille de jeu.
     * @param player L'objet Player contenant la position actuelle du joueur.
     */
    public static void moveRight(String[][] grid, Player player) {
        if (player.x == grid[0].length - 1) {
            System.out.println("You cannot move outside the grid.");
            move(grid, player);
        } else if (!isEmptyCase(grid, player.y, player.x + 1)) {
            System.out.println("The cell to the right is not empty.");
            move(grid, player);
        } else {
            String temp = grid[player.y][player.x];
            grid[player.y][player.x] = Grid.emptyCase;
            player.x += 1;
            grid[player.y][player.x] = temp;
        }
    }

    public static void move(String[][] grid, Player player) {
        System.out.println("Please move using the arrow keys or the Z, Q, S, D keys:");
        String direction = scanner.nextLine();

        // Vérification si la direction est vide
        if (direction == null || direction.isEmpty()) {
            System.out.println("No input provided, please enter a valid direction.");
            move(grid, player); // Relance la méthode pour demander une nouvelle saisie
            return; // Terminer cette itération
        }

        // Analyse du premier caractère de la direction
        switch (direction.charAt(0)) {
            case 'z':
            case 'Z':
                moveUp(grid, player);
                break;
            case 's':
            case 'S':
                moveDown(grid, player);
                break;
            case 'q':
            case 'Q':
                moveLeft(grid, player);
                break;
            case 'd':
            case 'D':
                moveRight(grid, player);
                break;
            default:
                System.out.println("The selected key is not valid for movement.");
                move(grid, player); // Redemande une saisie valide
        }
    }

}
