package ru.netology.manager;

import ru.netology.domain.ListFilms;

public class ListFilmsManager {

    private ListFilms[] playbill = new ListFilms[0];

    public void add(ListFilms item) {
        int length = playbill.length + 1;//Длинна нового массива.
        ListFilms[] tmp = new ListFilms[length];//Создаеться новый массив.
        System.arraycopy(playbill, 0, tmp, 0, playbill.length);
        //Playbill - откуда копируем. srcPos - с какой позиции копируем. tmp - куда копируем. desPos - с какой позиции копируем. playbill.lenght - сколько копируем.

        int lastIndex = tmp.length - 1; // Кладем из старого массива в новый. Вычесляет ячейку которая не заполнена.
        tmp[lastIndex] = item;
        playbill = tmp;

    }

    public ListFilms[] findLast() { //Добавленных фильмов в обратном от добавления порядке.
        ListFilms[] playbill = findAll();
        ListFilms[] result = new ListFilms[playbill.length];
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
