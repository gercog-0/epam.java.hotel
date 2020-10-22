package by.epam.project.model.creator;

import by.epam.project.model.entity.User;

/**
 * The type User creator.
 */
public class UserCreator {
    /**
     * The constant instance.
     */
    public static UserCreator instance = new UserCreator();

    private UserCreator() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UserCreator getInstance() {
        return instance;
    }

    /**
     * Create user user.
     *
     * @param userId          the user id
     * @param userLogin       the user login
     * @param userEmail       the user email
     * @param userName        the user name
     * @param userSurname     the user surname
     * @param userPhone       the user phone
     * @param userBalance     the user balance
     * @param userIsBanned    the user is banned
     * @param userIsActivated the user is activated
     * @param userRoleId      the user role id
     * @return the user
     */
    public User createUser(int userId, String userLogin, String userEmail, String userName,
                           String userSurname, String userPhone, double userBalance,
                           boolean userIsBanned, boolean userIsActivated, int userRoleId) {

        User createdUser = new User(userId, userLogin, userEmail, userName, userSurname,
                userPhone, userBalance, userIsBanned, userIsActivated, userRoleId);
        return createdUser;
    }

    /**
     * Create user user.
     *
     * @param userLogin   the user login
     * @param userEmail   the user email
     * @param userName    the user name
     * @param userSurname the user surname
     * @param userPhone   the user phone
     * @param userRoleId  the user role id
     * @return the user
     */
    public User createUser(String userLogin, String userEmail, String userName,
                           String userSurname, String userPhone, int userRoleId) {

        User createdUser = new User(userLogin, userEmail, userName, userSurname, userPhone, userRoleId);
        return createdUser;
    }
}
