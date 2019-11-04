package edu.forty.bits.ds.tree;

/**
 * Created by naman.nigam on 30/11/15.
 */
public class TreePrefix {

    private boolean recContainsPrefix(String prefixKey, BSTNode<String> tree) {
        //base case
        if (tree == null)

            return false;
        //test if each node starts with the prefix.
        if (tree.getInfo().startsWith(prefixKey)) {
            return true;
        }
        //recursive case.
        else if (prefixKey.compareTo(tree.getInfo()) < 0)
            return recContainsPrefix(prefixKey, tree.getLeft());
            //recursive case.
        else if (prefixKey.compareTo(tree.getInfo()) > 0)
            return recContainsPrefix(prefixKey, tree.getRight());

        else {
            return true;
        }
    }
}