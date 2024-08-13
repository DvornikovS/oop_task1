package ru.gb.family_tree.family_tree;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByBirthDate;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E>{
    private List<E> humanList;
    private long humanId;

    public FamilyTree(){ this(new ArrayList<>());}

    public FamilyTree(List<E> humanlist) { this.humanList = humanlist;}

    private void addToParents(E human){
        for(E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for(E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public boolean add(E human){
        if(human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);
            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for( E human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder StringBuilder = new StringBuilder();
        StringBuilder.append("Семейное древо:\n");
        for (E human: humanList){
            StringBuilder.append(human);
            StringBuilder.append("\n");
        }
        return StringBuilder.toString();
    }


    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new FamilyTreeIterator(humanList);
    }


    public void sortByBirthDate() {
            humanList.sort(new FamilyTreeComparatorByBirthDate<>());
    }

    public void sortByName(){
        humanList.sort(new FamilyTreeComparatorByName<>());
    }
}
