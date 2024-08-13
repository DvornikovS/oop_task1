package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> list;
    private int index;

    public <E extends TreeNode<E>>FamilyTreeIterator(List<E> list){
        this.list = (List<Human>) list;
        index = 0;
    }



    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Human next() {
        return list.get(index++);
    }
}
