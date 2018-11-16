import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashExperiment {
    public static void main(String[] args)
    {
        String pw = "happy";
        String hashedPW = null;
        String hashedPW2 = null;

        try {
            byte[] salt = PasswordGenerator.getSalt();
            hashedPW = PasswordGenerator.getPassword(pw, salt);
            hashedPW2 = PasswordGenerator.getPassword(pw, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.printf("%s becomes %s%n", pw, hashedPW);
        System.out.printf("%s becomes %s%n", pw, hashedPW2);

        System.out.print("Enter a password: ");
        Scanner keyboard = new Scanner(System.in);
        pw = keyboard.nextLine();

        User user1 = new User(1, pw);


        do {
            System.out.print("enter a password: ");
            pw = keyboard.nextLine();
            try {
                hashedPW = PasswordGenerator.getPassword(pw, user1.getSalt());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } while (!user1.getPassword().equals(hashedPW));

        System.out.println("Success");

    }
}
