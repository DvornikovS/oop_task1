package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.io.Serializable;
import  java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        FamilyTree<Human> tree = testTree();
        //tree = readTree();
        //saveTree(tree);
        System.out.println(tree);
        tree.sortByBirthDate();
        System.out.println(tree);
        tree.sortByName();
        System.out.println(tree);

    }
    private static FamilyTree<Human> readTree(){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree<Human>) fileHandler.read();
    }
    private static void  saveTree(FamilyTree<Human> tree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    public static FamilyTree<Human> testTree() {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human human1 = new Human("Андрей", Gender.Male, LocalDate.parse("1953-04-13"));
        Human human2 = new Human("Екатерина", Gender.Female, LocalDate.parse("1954-06-16"));
        tree.add(human1);
        tree.add(human2);

        Human human3 = new Human("Иван", Gender.Male, LocalDate.parse("1986-11-01"), human2, human1);
        Human human4 = new Human("Ольга", Gender.Female, LocalDate.parse("1989-01-25"), human2, human1);

        tree.add(human3);
        tree.add(human4);

        Human human5 = new Human("Инокентий", Gender.Male, LocalDate.parse("1928-12-31"));
        human5.addChild(human3);

        tree.add(human5);

        return tree;
    }
}
