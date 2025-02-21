package db;

public class UserService {
    private DatabaseConnection connection;

    public UserService(DatabaseConnection connection) {
        this.connection = connection;
    }

    public boolean addUser(String username) {
        if (connection.isConnected()) {
            System.out.println("User " + username + " added to database.");
            return true;
        }
        return false;
    }

    public boolean removeUser(String username) {
        if (connection.isConnected()) {
            System.out.println("User " + username + " removed from database.");
            return true;
        }
        return false;
    }
}
