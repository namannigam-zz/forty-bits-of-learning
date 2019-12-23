package edu.forty.bits.datastructures.tree;

import lombok.Getter;

@Getter
public class BSTNode<E> {
    private String info;
    private BSTNode<E> left;
    private BSTNode<E> right;
}