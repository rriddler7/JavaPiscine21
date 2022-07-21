package edu.school21.chat;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private Integer id;
    private User author;
    private Room chatRoom;
    private String text;
    private LocalDateTime dateTime;

    public Message(Integer id, User author, Room chatRoom, String text, LocalDateTime dateTime) {
        this.id = id;
        this.author = author;
        this.chatRoom = chatRoom;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Room getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(Room chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(author, message.author) && Objects.equals(chatRoom, message.chatRoom) && Objects.equals(text, message.text) && Objects.equals(dateTime, message.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, chatRoom, text, dateTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", chatRoom=" + chatRoom +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
