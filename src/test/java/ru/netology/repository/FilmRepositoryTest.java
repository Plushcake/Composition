package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.ListFilms;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
    ListFilms film1 = new ListFilms(101, 1, "Бладшот - Начало.", 500, 2);
    ListFilms film2 = new ListFilms(102, 2, "Вперёд", 500, 2);
    ListFilms film3 = new ListFilms(103, 3, "Отель Белград", 500, 2);
    ListFilms film4 = new ListFilms(104, 4, "Джентльмены", 700, 2);
    ListFilms film5 = new ListFilms(105, 5, "Человек-неведимка", 300, 2);
    ListFilms film6 = new ListFilms(106, 6, "Тролли.Мировой тур", 500, 6);
    ListFilms film7 = new ListFilms(107, 7, "Номер один", 500, 1);
    ListFilms film8 = new ListFilms(108, 8, "Я-легенда", 600, 3);
    ListFilms film9 = new ListFilms(109, 9, "Ну погоди", 400, 5);
    ListFilms film10 = new ListFilms(110, 10, "Рататуй - Конец.", 400, 4);

    @Test
    public void test1Repository() {
        FilmRepository repo = new FilmRepository();
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);
        repo.save(film6);
        repo.save(film7);
        repo.save(film8);
        repo.save(film9);
        repo.save(film10);

        repo.removeById(102);

        ListFilms[] actual = repo.findAll();
        ListFilms[] expected = {film1, film3, film4, film5, film6, film7, film8, film9, film10}; //ассертим не длину массива а целиком набор.

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2Repository() {
        FilmRepository repo = new FilmRepository();

        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.save(film4);
        repo.save(film5);

        repo.removeById(105);

        ListFilms[] actual = repo.findAll();
        ListFilms[] expected = {film1, film2, film3, film4};

        Assertions.assertArrayEquals(expected, actual);

    }

}