package by.epam.project.model.creator;

import by.epam.project.model.entity.User;

public class UserCreator {
    public static UserCreator instance = new UserCreator();

    private UserCreator() {
    }

    public static UserCreator getInstance() {
        return instance;
    }

    public User createUser(int userId, String userLogin, String userEmail, String userName,
                           String userSurname, String userPhone, double userBalance,
                           boolean userIsBanned, boolean userIsActivated, int userRoleId) {

        User createdUser = new User(userId, userLogin, userEmail, userName, userSurname,
                userPhone, userBalance, userIsBanned, userIsActivated, userRoleId);
        return createdUser;
    }

    public User createUser(String userLogin, String userEmail, String userName,
                           String userSurname, String userPhone, int userRoleId) {

        User createdUser = new User(userLogin, userEmail, userName, userSurname, userPhone, userRoleId);
        return createdUser;
    }
}
