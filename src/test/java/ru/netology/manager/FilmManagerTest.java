package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.ListFilms;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class FilmManagerTest {
    private FilmRepository repository = Mockito.mock(FilmRepository.class);

    private FilmManager manager = new FilmManager(repository);
    private ListFilms film1 = new ListFilms(101, 1, "Бладшот - Начало.", 500, 2);
    private ListFilms film2 = new ListFilms(102, 2, "Вперёд", 500, 2);
    private ListFilms film3 = new ListFilms(103, 3, "Отель Белград", 500, 2);
    private ListFilms film4 = new ListFilms(104, 4, "Джентльмены", 700, 2);
    private ListFilms film5 = new ListFilms(105, 5, "Человек-неведимка", 300, 2);
    private ListFilms film6 = new ListFilms(106, 6, "Тролли.Мировой тур", 500, 6);
    private ListFilms film7 = new ListFilms(107, 7, "Номер один", 500, 1);
    private ListFilms film8 = new ListFilms(108, 8, "Я-легенда", 600, 3);
    private ListFilms film9 = new ListFilms(109, 9, "Ну погоди", 400, 5);
    private ListFilms film10 = new ListFilms(110, 10, "Рататуй - Конец.", 400, 4);

    @Test
    public void test1FilmManager() {
        ListFilms[] returned = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};//Список которому должет ответить репозиторий.
        doReturn(returned).when(repository).findAll(); //Это строка учит правильно отвечать.
        //Возвращай (returned).Когда актер(repository) спросит findAll.


        ListFilms[] actual = manager.findLast();
        ListFilms[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(actual, expected);


        verify(repository).findAll();//Проверка что repository вызывал findAll. Если его не вызвать то сборка валиться.
    }
   /* @Test
    public void test2FilmManegerLimit() {
        ListFilms[] returned = {film1, film2, film3, film4, film5, film6, film7, film8, film9, film10};
        doReturn(returned).when(repository).findAll();

        ListFilms[] actual = manager.findLastLimit();
        ListFilms[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};

        assertArrayEquals(actual, expected);

        verify(repository).findAll();
    }*/
}
