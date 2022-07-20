package ex02;

public class Program {
    public static void main(String[] args) throws UserArrayList.UserNotFoundException {
        UserArrayList userList = new UserArrayList();
        for(int i = 0; i < 15; i++) {
            User user;
            user = new User("User" + i, i * 1000);
            userList.addUser(user);
        }
        System.out.println("User: " + userList.getUserByIndex(15 / 2));
        System.out.println("User: " + userList.getUserByID(15));
        System.out.println("Total capacity: " + userList.getUsersNumber());
        System.out.println("User: " + userList.getUserByIndex(20));
    }
}
