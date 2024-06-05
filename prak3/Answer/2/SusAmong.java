import java.util.Scanner;

public class SusAmong {
    public static void main(String[] args) {
        int taskCompleted = 0;
        int playersFrozen = 0;
        int emergencyMeetingCalled = 0;

        Scanner scanner = new Scanner(System.in);

        int totalPlayers = scanner.nextInt();
        int compost = scanner.nextInt();

        for (int i = 1; i <= compost; i++) {
            RedAstronaut red = new RedAstronaut("Impostor " + i);
        }

        for (int i = 1; i <= totalPlayers - compost; i++) {
            BlueAstronaut blue = new BlueAstronaut("Crewmate " + i);
        }

        while (true) {
            int com = scanner.nextInt();

            if (com == 1) {
                int idx = scanner.nextInt();

                if (Player.getPlayers()[idx] instanceof BlueAstronaut) {
                    BlueAstronaut blue = (BlueAstronaut) (Player.getPlayers()[idx]);
                    blue.completeTask();
                    taskCompleted++;
                } 
            }

            else if (com == 2) {
                int idx_1 = scanner.nextInt();

                if (Player.getPlayers()[idx_1] instanceof RedAstronaut) {
                    RedAstronaut red = (RedAstronaut) (Player.getPlayers()[idx_1]);
                    int idx_2 = scanner.nextInt();
                    playersFrozen++;
                    red.freeze(Player.getPlayers()[idx_2]);
                }
            } 
            
            else if (com == 3) {
                for (int i = 0; i < totalPlayers; i++) {
                    Player.getPlayers()[i].emergencyMeeting();
                }
                emergencyMeetingCalled++;
            } 
            
            else if (com == 4) {
                break;
            }

            if (Player.getPlayers()[com].gameOver()) {
                break;
            }
        }

        System.out.println("Task completed: " + taskCompleted);
        System.out.println("Players frozen: " + playersFrozen);
        System.out.println("Emergency meetings called: " + emergencyMeetingCalled);
        System.out.println("Game Over. Thanks for playing!");

        scanner.close();
    }
}