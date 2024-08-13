package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.human.Human;

import java.time.LocalDate;
import java.util.Comparator;

public class HumanComparatorByBirthDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDob().compareTo(o2.getDob());
    }

}
