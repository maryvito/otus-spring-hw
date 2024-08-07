insert into authors (name) values ( 'Александр Пушкин' ), ('Агата Кристи');

insert into genres (name) values ( 'роман' ), (' детектив ');

insert into books (name, author_id, genre_id) values ( 'Евгений Онегин', 1, 1),
                                                     ('Капитанская дочка', 1, 1),
                                                     ('Эркюль Пуаро', 2, 2);
insert into comments(book_id, text) values ( 1, 'комментарий к Евгению Онегину - 1'),
                                        ( 1, 'комментарий к Евгению Онегину - 2'),
                                        ( 1, 'комментарий к Евгению Онегину - 3'),
                                        ( 1, 'комментарий к Евгению Онегину - 4'),
                                        ( 1, 'комментарий к Евгению Онегину - 5'),
                                        ( 2, 'комментарий к Капитанской дочке - 1');

insert into user(username, password, role) values ( 'mary', '1', 'admin'),
                                            ( 'anton', '2', 'user'),
                                            ( 'edi', '3', 'editor');


INSERT INTO acl_sid (id, principal, sid) VALUES
                                             (1, 1, 'mary'),
                                             (2, 1, 'anton'),
                                             (3, 0, 'ROLE_EDITOR');

INSERT INTO acl_class (id, class, class_id_type) VALUES
    (1, 'com.example.bookssecurity.domain.Book', 'java.lang.Integer');


INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 0, NULL, 3, 0),
(2, 1, 1, NULL, 3, 0),
(3, 1, 2, NULL, 3, 0);

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES
(1, 2, 1, 2, 1, 1, 1, 1);
/*(2, 1, 2, 1, 2, 1, 1, 1),
(3, 1, 3, 3, 1, 1, 1, 1),
(4, 2, 1, 2, 1, 1, 1, 1),
(5, 2, 2, 3, 1, 1, 1, 1),
(6, 3, 1, 3, 1, 1, 1, 1),
(7, 3, 2, 3, 2, 1, 1, 1);*/
