/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.ArrayList;

/**
 *
 * @author rla
 * @param <E>
 */
public interface IBSearchTree<E extends Comparable<E>> {
    void createBalancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange);
    void addNode(E theItem);
    boolean nodeContains(E desiredItem);
    E findItem(E desiredItem);
    E deleteNode(E desiredItem);
    boolean removeNode(E desiredItem);
}
