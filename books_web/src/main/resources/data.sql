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

insert into user(username, password) values ( 'mary', '1'),
                                            ( 'anton', '2');