package by.epam.project.model.entity;

import java.util.HashMap;
import java.util.Map;

public class User extends Account {
    public enum Role {
        USER(0), ADMINISTRATOR(1);

        private final int roleId;

        Role(int roleId) {
            this.roleId = roleId;
        }

        public int getRoleId() {
            return roleId;
        }

        private static final Map<Integer, Role> LOOKUP_MAP = new HashMap<>();

        static {
            for (Role element : values()) {
                LOOKUP_MAP.put(element.getRoleId(), element);
            }
        }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public Role getRole() {
        return role;
    }

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