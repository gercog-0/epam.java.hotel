package by.epam.project.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * The type User.
 */
public class User extends Account {
    /**
     * The enum Role.
     */
    public enum Role {
        /**
         * User role.
         */
        USER(0),
        /**
         * Administrator role.
         */
        ADMINISTRATOR(1),
        /**
         * Guest role.
         */
        GUEST(2);

        private final int roleId;

        Role(int roleId) {
            this.roleId = roleId;
        }

        /**
         * Gets role id.
         *
         * @return the role id
         */
        public int getRoleId() {
            return roleId;
        }

        private static final Map<Integer, Role> LOOKUP_MAP = new HashMap<>();

        static {
            for (Role element : values()) {
                LOOKUP_MAP.put(element.getRoleId(), element);
            }
        }

        /**
         * Gets role by id.
         *
         * @param roleId the role id
         * @return the role by id
         */
        public static Role getRoleById(int roleId) {
            return LOOKUP_MAP.get(roleId);
        }
    }

    private String name;
    private String surname;
    private String email;
    private String phone;
    private double balance;
    private boolean isBanned;
    private boolean isActivated;
    private Role role;

    /**
     * Instantiates a new User.
     *
     * @param login   the login
     * @param email   the email
     * @param name    the name
     * @param surname the surname
     * @param phone   the phone
     * @param roleId  the role id
     */
    public User(String login, String email,
                String name, String surname, String phone, int roleId) {
        super(login);
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.isBanned = false;
        this.isActivated = false;
        this.role = Role.getRoleById(roleId);
    }

    /**
     * Instantiates a new User.
     *
     * @param id          the id
     * @param login       the login
     * @param email       the email
     * @param name        the name
     * @param surname     the surname
     * @param phone       the phone
     * @param balance     the balance
     * @param isBanned    the is banned
     * @param isActivated the is activated
     * @param roleId      the role id
     */
    public User(int id, String login, String email, String name,
                String surname, String phone, double balance,
                boolean isBanned, boolean isActivated, int roleId) {
        super(id, login);
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.isBanned = isBanned;
        this.isActivated = isActivated;
        this.balance = balance;
        this.role = Role.getRoleById(roleId);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Is banned boolean.
     *
     * @return the boolean
     */
    public boolean isBanned() {
        return isBanned;
    }

    /**
     * Sets banned.
     *
     * @param banned the banned
     */
    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    /**
     * Is activated boolean.
     *
     * @return the boolean
     */
    public boolean isActivated() {
        return isActivated;
    }

    /**
     * Sets activated.
     *
     * @param activated the activated
     */
    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        User user = (User) o;

        if (Double.compare(user.balance, balance) != 0) {
            return false;
        }
        if (isBanned != user.isBanned) {
            return false;
        }
        if (isActivated != user.isActivated) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) {
            return false;
        }
        if (email != null ? !email.equals(user.email) : user.email != null) {
            return false;
        }
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) {
            return false;
        }
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp - (temp >>> 32));
        result = 31 * result + (isBanned ? 1 : 0);
        result = 31 * result + (isActivated ? 1 : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", isBanned=").append(isBanned);
        sb.append(", isActivated=").append(isActivated);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}