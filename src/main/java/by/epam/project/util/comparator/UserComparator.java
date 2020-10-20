package by.epam.project.util.comparator;

import by.epam.project.entity.Room;
import by.epam.project.entity.User;

import java.util.Comparator;

public enum UserComparator {
    NAME((user1, user2) -> user1.getName().compareTo(user2.getName())),
    LOGIN((user1, user2) -> user1.getLogin().compareTo(user2.getLogin()));

    private final Comparator<User> comparator;

    UserComparator(Comparator<User> comparator) {
        this.comparator = comparator;
    }

    public Comparator<User> getComparator() {
        return comparator;
    }
}
