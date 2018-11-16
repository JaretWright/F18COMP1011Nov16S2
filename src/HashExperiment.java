import java.security.NoSuchAlgorithmException;

public class HashExperiment {
    public static void main(String[] args)
    {
        String pw = "happy";
        String hashedPW = null;

        try {
            byte[] salt = PasswordGenerator.getSalt();
            hashedPW = PasswordGenerator.getPassword(pw, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.printf("%s becomes %s%n", pw, hashedPW);

    }
}
