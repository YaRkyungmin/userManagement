import model.UserManagementManager;

public class Main {
    public static void main(String[] args) {
        UserManagementManager manager = new UserManagementManager();

        manager.startUserManagementService();
    }
}
