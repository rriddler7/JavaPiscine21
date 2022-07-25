INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Connel','12345', '{1,2}', '{1, 2, 4}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Joanna','11111', '{3}', '{3, 1}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Salli','qwerty', '{}', '{1, 2, 3, 4}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Runi','password', '{4, 5}', '{1, 4, 5}');
INSERT INTO chat.Users (login, password, roomsId, chatRoomsId) VALUES ('Miranda','mypass', '{}', '{1, 2, 3}');

INSERT INTO chat.chatroom (name, owner, messages) VALUES ('C', 1, '{1, 2, 6}');
INSERT INTO chat.chatroom (name, owner, messages) VALUES ('CPP', 2, '{3, 4}');
INSERT INTO chat.chatroom (name, owner, messages) VALUES ('Java', 3, '{5, 1, 3}');
INSERT INTO chat.chatroom (name, owner, messages) VALUES ('Python', 4, '{2, 3, 4}');
INSERT INTO chat.chatroom (name, owner, messages) VALUES ('DS', 5, '{1, 2, 3, 4}');

INSERT INTO chat.Message (author, room, text, dataTime) VALUES (1, 1, 'Hello, world!', '2022-07-21 17:14:01');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (1, 2, 'What?', '2022-07-21 17:16:22');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (2, 3, 'Listen to me', '2022-07-21 17:21:13');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (1, 4, 'I understood', '2022-07-21 17:33:00');
INSERT INTO chat.Message (author, room, text, dataTime) VALUES (3, 5, 'You Know', '2022-07-21 21:24:12');