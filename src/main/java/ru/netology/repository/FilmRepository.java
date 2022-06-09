package ru.netology.repository;

import ru.netology.domain.ListFilms;

public class FilmRepository { //Занимаеться запоминанием. Помошник менеджера.
    private ListFilms[] playbill = new ListFilms[0];

    public void save(ListFilms item) {
        int length = playbill.length + 1;//Длинна нового массива.
        ListFilms[] tmp = new ListFilms[length];//Создаеться новый массив.
        System.arraycopy(playbill, 0, tmp, 0, playbill.length);
        //Playbill - откуда копируем. srcPos - с какой позиции копируем. tmp - куда копируем. desPos - с какой позиции копируем. playbill.lenght - сколько копируем.

        int lastIndex = tmp.length - 1; // Кладем из старого массива в новый. Вычесляет ячейку которая не заполнена.
        tmp[lastIndex] = item;
        playbill = tmp;

    }

    public ListFilms[] findAll() {

        return playbill;
    }

    public void removeById(int id) {
        int lenght = playbill.length - 1;
        ListFilms[] tmp = new ListFilms[lenght];
        int index = 0;
        for (ListFilms item : playbill) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        playbill = tmp;
    }


}
