package ru.netology.manager;

import ru.netology.domain.ListFilms;

public class ListFilmsManager {
    private ListFilms[] playbill = new ListFilms[0];
    private int limit;

    public ListFilmsManager() {
        limit = 10;
    }

    public ListFilmsManager(int limit) {
        this.limit = limit;
    }


    public void add(ListFilms item) {
        int length = playbill.length + 1;//Длинна нового массива.
        ListFilms[] tmp = new ListFilms[length];//Создаеться новый массив.____[length]
        System.arraycopy(playbill, 0, tmp, 0, playbill.length);
        //Playbill - откуда копируем. srcPos - с какой позиции копируем. tmp - куда копируем. desPos - с какой позиции копируем. playbill.length - сколько копируем.

        int lastIndex = tmp.length - 1; // Кладем из старого массива в новый. Вычесляет ячейку которая не заполнена.
        tmp[lastIndex] = item;
        playbill = tmp;

    }

    public ListFilms[] findLast() { //Добавления в обратном порядке.
        ListFilms[] playbill = findAll();
        ListFilms[] result;
        if (limit < playbill.length) {
            result = new ListFilms[limit];
        } else {
            result = new ListFilms[playbill.length];
        }
        for (int i = 0; i < result.length; i++) {
            int index = playbill.length - i - 1; //Берем размер массива(playbill.length). Ячейка куда хотим скопировать(i) и минус один (Потому что начинаеться с нуля).
            result[i] = playbill[index];
        }
        return result;
    }

    public ListFilms[] findAll() { //Вывод всех фильмов в порядке добавления.
        return playbill;
    }

}
