package ru.netology.manager;

import ru.netology.domain.ListFilms;

public class ListFilmsManager {

    private int countFilms = 10;
    private ListFilms[] playbill = new ListFilms[0];

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
        int valueLimit = playbill.length;
        if (valueLimit >= countFilms) {
            valueLimit = countFilms;
        } else {
            valueLimit = playbill.length;
        }

        ListFilms[] result = new ListFilms[valueLimit]; //[playbill.length]
        for (int i = 0; i < valueLimit; i++) {
            int index = playbill.length - i - 1; //Берем размер массива(playbill.length). Ячейка куда хотим скопировать(i) и минус один (Потому что начинаеться с нуля).
            result[i] = playbill[index];
        }
        return result;
    }

    public ListFilms[] findAll() { //Вывод всех фильмов в порядке добавления.
        return playbill;
    }

}
