package ex03;

public interface UserList {
    public void addUser(User user);

    User getUserByID(Integer id);

    User getUserByIndex(Integer index);

    public Integer getUsersNumber();
}
