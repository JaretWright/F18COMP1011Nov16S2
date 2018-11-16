import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordGenerator {

    /**
     * This method returns a random byte array that can
     * be used as a salt in a password
     */
    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = new SecureRandom().getInstanceStrong();

        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }


    /**
     * This method return a hashed password using the SHA512
     * algorithms
     */
    public static String getPassword(String pwToHash, byte[] salt) throws NoSuchAlgorithmException {

        //SHA-512 is the name of the algorithm used to hash the password
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);

        byte[] bytes = md.digest(pwToHash.getBytes());

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<bytes.length; i++)
        {
            //this converts a byte to a hex value
            sb.append(Integer.toString((bytes[i] & 0xff)+0x100, 16).substring(1));

            //alternative option
            //sb.append(String.format("%x", bytes[i]));
        }

        return sb.toString();

    }
}
