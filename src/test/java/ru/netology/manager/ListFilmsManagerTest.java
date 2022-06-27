package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.ListFilms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ListFilmsManagerTest {
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
    ListFilms film11 = new ListFilms(111, 11, "Терминатор", 500, 6);

    @Test
    public void test1FindLast() {
        ListFilmsManager manager = new ListFilmsManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);


        ListFilms[] actual = manager.findLast();
        ListFilms[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void test2FindLast() {
        ListFilmsManager manager = new ListFilmsManager();
        manager.add(film1);


        ListFilms[] actual = manager.findLast();
        ListFilms[] expected = {film1};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void test3FindLast() {
        ListFilmsManager manager = new ListFilmsManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);


        ListFilms[] actual = manager.findLast();
        ListFilms[] expected = {film5, film4, film3, film2, film1};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void test4FindLast() {
        ListFilmsManager manager = new ListFilmsManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);


        ListFilms[] actual = manager.findLast();
        ListFilms[] expected = {film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void test5FindLast() {
        ListFilmsManager manager = new ListFilmsManager();


        ListFilms[] actual = manager.findLast();
        ListFilms[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        ListFilmsManager manager = new ListFilmsManager();
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);


        ListFilms[] actual = manager.findAll();
        ListFilms[] expected = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};

        assertArrayEquals(actual, expected);
    }

}