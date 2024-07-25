package ru.gb.family_tree.family_tree;
import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Human> humanList;
    private long humanId;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public boolean add(Human human){
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

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for( Human human: humanList){
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
        for (Human human: humanList){
            StringBuilder.append(human);
            StringBuilder.append("\n");
        }
        return StringBuilder.toString();
    }
}
