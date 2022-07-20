package ex02;

import java.util.ArrayList;
import java.util.Arrays;

public class UserArrayList implements UserList {
    private Integer size;
    private Integer capacity;
    private User[] users;

    public UserArrayList() {
        size = 0;
        capacity = 10;
        users = new User[capacity];
    }

    @Override
    public void addUser(User user) {
        if (size == capacity) {
            users = growUsers(users);
        }
        if (user != null) {
            users[size] = user;
            size++;
        }
    }

    private User [] growUsers(User [] users) {
        capacity = (int)(capacity * 1.5);
        User[] grow = new User[this.capacity];
        for (int i = 0; i < size; i++) {
            grow[i] = users[i];
        }
        return grow;
    }

    public class UserNotFoundException extends RuntimeException {
        @Override
        public String toString() {
            return ("User not found!");
        }
    }

    @Override
    public User getUserByID(Integer id) throws UserNotFoundException{
        for (User user : users) {
            if (id.equals(user.getIdentifier())) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(Integer index) throws UserNotFoundException {
        if (index >= 0 && index < this.size) {
                return this.users[index];
            }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public Integer getUsersNumber() {
        return this.size;
    }
}
