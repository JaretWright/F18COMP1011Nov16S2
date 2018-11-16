import java.security.NoSuchAlgorithmException;

public class User {
    private int userID;
    private String password;
    private byte[] salt;

    public User(int userID, String password) {
        setUserID(userID);
        setPassword(password);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            salt = PasswordGenerator.getSalt();
            this.password = PasswordGenerator.getPassword(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println("Inside setPassword(): PW ="+this.password);
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
