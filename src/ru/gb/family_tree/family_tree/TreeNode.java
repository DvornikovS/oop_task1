package ru.gb.family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(long id);

    long getId();

    boolean addChild(T human);

    boolean addParent(T human);

    String getName();

    LocalDate getDob();

    LocalDate getDod();

    List<T> getParents();

    List<T> getChildren();
}