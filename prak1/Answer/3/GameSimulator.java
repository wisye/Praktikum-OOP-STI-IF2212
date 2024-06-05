import java.util.Scanner;

public class GameSimulator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int player = Integer.parseInt(scanner.nextLine());
        String seeker = scanner.nextLine();

        System.out.printf("Game dimulai dengan %d pemain, seeker adalah %s\n", player, seeker);

        HideNSeek hideNSeek = new HideNSeek(seeker, player);

        while((hideNSeek.getPlayerFound() + 1) < hideNSeek.getPlayer()){
            if(Integer.parseInt(scanner.nextLine()) == (hideNSeek.getPlayerFound() + 1)){
                hideNSeek.foundPlayer();
                System.out.printf("%d Pemain ditemukan\n", hideNSeek.getPlayerFound());
            }
        }

        System.out.printf("Semua pemain telah ditemukan, permainan selesai.\n");

        scanner.close();

    }
}
