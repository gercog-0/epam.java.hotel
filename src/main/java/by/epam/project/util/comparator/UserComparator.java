package by.epam.project.util.comparator;

import by.epam.project.model.entity.User;

import java.util.Comparator;

/**
 * The enum User comparator.
 */
public enum UserComparator {
    /**
     * Name user comparator.
     */
    NAME((user1, user2) -> user1.getName().compareTo(user2.getName())),
    /**
     * Login user comparator.
     */
    LOGIN((user1, user2) -> user1.getLogin().compareTo(user2.getLogin()));

    private final Comparator<User> comparator;

    UserComparator(Comparator<User> comparator) {
        this.comparator = comparator;
    }

    /**
     * Gets comparator.
     *
     * @return the comparator
     */
    public Comparator<User> getComparator() {
        return comparator;
    }
}
