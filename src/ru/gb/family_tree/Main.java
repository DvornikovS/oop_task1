package ru.gb.family_tree;
import  java.time.LocalDate;
public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Андрей", Gender.Male, LocalDate.parse("1953-04-13"));
        Human human2 = new Human("Екатерина", Gender.Female, LocalDate.parse("1954-06-16"));
        familyTree.add(human1);
        familyTree.add(human2);

        Human human3 = new Human("Иван", Gender.Male, LocalDate.parse("1986-11-01"), human2, human1);
        Human human4 = new Human("Ольга", Gender.Female, LocalDate.parse("1989-01-25"), human2, human1);

        familyTree.add(human3);
        familyTree.add(human4);

        Human human5 = new Human("Инокентий", Gender.Male, LocalDate.parse("1928-12-31"));
        human5.addChild(human3);

        familyTree.add(human5);

        System.out.println(familyTree);
    }
}
