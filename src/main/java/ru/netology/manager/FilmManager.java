package ru.netology.manager;

import ru.netology.domain.ListFilms;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;

    public FilmManager(FilmRepository repository) {
        this.repository = repository;
    }

    public void add(ListFilms item) {
        repository.save(item);
    }

    public ListFilms[] findLast() { //Реверсированние массива.
        ListFilms[] playbill = repository.findAll();
        ListFilms[] result = new ListFilms[playbill.length];
        for (int i = 0; i < result.length; i++) {
            int index = playbill.length - i - 1; //Берем размер массива(playbill.length). Ячейка куда хотим скопировать(i) и минус один (Потому что начинаеться с нуля).
            result[i] = playbill[index];
        }
        return result;
    }

    /*public ListFilms[] findLastLimit() { //Реверсированние массива с лимитом в 10..
        ListFilms[] playbill = repository.findAll();
        ListFilms[] result = new ListFilms[10];
        for (int i = 0; i < result.length; i++) {
            int index = playbill.length - i - 1; //Берем размер массива(playbill.length). Ячейка куда хотим скопировать(i) и минус один (Потому что начинаеться с нуля).
            result[i] = playbill[index];
        }
        return result;
    }*/

    public void removedById(int id) {

        repository.removeById(id);
    }

}
