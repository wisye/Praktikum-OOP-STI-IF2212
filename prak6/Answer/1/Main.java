import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean result = false;

        try{
            String s = scanner.nextLine();
            Email email = new Email(s);
            scanner.close();
            email.validateEmail();
        }
        catch(InvalidDomainException | InvalidEmailException e){
            System.out.println(e.getClass().getName() + "! " + e.getMessage());
            result = true;
        }
        catch (Exception e) {
            System.out.println(e.getClass().getName());
            result = true;
        }
        finally {
            if (!result){
                System.out.println("true" + "\n" +
                                    "Email validated.");
            }
            else{
                System.out.println("Email string error!");
            }
            System.out.println("Operation finished.");
        }
    }
}
