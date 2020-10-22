package by.epam.project.model.entity;

/**
 * The type Account.
 */
public class Account extends Entity {
    private int id;
    private String login;

    /**
     * Instantiates a new Account.
     *
     * @param id    the id
     * @param login the login
     */
    public Account(int id, String login) {
        this.id = id;
        this.login = login;
    }

    /**
     * Instantiates a new Account.
     *
     * @param login the login
     */
    public Account(String login) {
        this.login = login;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (id != account.id) {
            return false;
        }
        return login != null ? login.equals(account.login) : account.login == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
