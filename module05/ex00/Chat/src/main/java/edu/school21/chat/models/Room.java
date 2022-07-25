package edu.school21.chat;

import java.util.List;
import java.util.Objects;

public class Room {
    private Integer id;
    private String name;
    private User owner;
    private List<Message> roomMessages;

    public Room(Integer id, String name, User owner, List<Message> roomMessages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.roomMessages = roomMessages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Message> getRoomMessages() {
        return roomMessages;
    }

    public void setRoomMessages(List<Message> roomMessages) {
        this.roomMessages = roomMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(name, room.name) && Objects.equals(owner, room.owner) && Objects.equals(roomMessages, room.roomMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, roomMessages);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", roomMessages=" + roomMessages +
                '}';
    }
}
