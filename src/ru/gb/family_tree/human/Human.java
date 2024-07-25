package ru.gb.family_tree.human;

import java.io.Serializable;
import  java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human (String name, Gender gender, LocalDate dob, LocalDate dod, Human mother, Human father){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.dod = dod;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();

    }

    public Human(String name, Gender gender, LocalDate dob){
        this(name, gender, dob, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate dob, Human mother, Human father){
        this(name, gender, dob, null, mother, father);
    }

    public boolean addChild (Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Female)){
        setMother(parent);
        } else if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
        }
        return true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private int getPeriod(LocalDate dob, LocalDate dod){
        Period diff = Period.between(dob, dod);
        return diff.getYears();
    }

    public int getAge(){
        if (dod == null){
            return getPeriod(dob, LocalDate.now());
        } else {
            return getPeriod(dob, dod);
        }
    }

    public String getMotherInfo(){
        String mi = "Мать: ";
        Human mother = getMother();
        if (mother == null){
            mi+= "нет, ";
        }else {
            mi += mother.getName();
            mi += ", ";
        }
        return mi;
    }

    public String getFatherInfo(){
        String fi = "Отец: ";
        Human father = getFather();
        if (father == null){
            fi+= "нет";
        }else {
            fi += father.getName();
        }
        return fi;
    }
    public String getChildrenInfo(){
        StringBuilder ci = new StringBuilder();
        ci.append("Дети: ");
        if (children.size() == 0){
            ci.append("нет");
        }else {
            ci.append(children.get(0).getName());
            for (int i =1; i < children.size(); i++){
                ci.append(", ");
                ci.append(children.get(i).getName());
            }
        }
        return ci.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder HumanInfo = new StringBuilder();
        HumanInfo.append("id: ");
        HumanInfo.append(id);
        HumanInfo.append("\n");
        HumanInfo.append("Имя: ");
        HumanInfo.append(name);
        HumanInfo.append(", Пол: ");
        HumanInfo.append(getGender());
        HumanInfo.append(", Возраст: ");
        HumanInfo.append(getAge());
        HumanInfo.append("\n");
        HumanInfo.append(getMotherInfo());
        HumanInfo.append(getFatherInfo());
        HumanInfo.append("\n");
        HumanInfo.append(getChildrenInfo());
        return HumanInfo.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}


