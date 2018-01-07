package Leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * Created by uslabs on 10/27/17.
 */
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> myNestedList;
    private NestedIterator itr;
    private int i = 0, size = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        myNestedList = nestedList;
    }

    @Override
    public Integer next() {
        if (i >= myNestedList.size())
            return null;
        if (itr == null) {
            NestedInteger currNestedInteger = myNestedList.get(i);
            if (currNestedInteger.isInteger()) {
                ++i;
                return currNestedInteger.getInteger();
            } else {
                itr = new NestedIterator(currNestedInteger.getList());
                if (itr.hasNext())
                    return itr.next();
                itr = null;
                ++i;
                return this.next();
            }
        } else {
            if (itr.hasNext())
                return itr.next();
            itr = null;
            ++i;
            return this.next();
        }
    }

    @Override
    public boolean hasNext() {
        if (itr == null) {
            return i < myNestedList.size();
        } else {
            if (itr.hasNext())
                return true;
            else
                return i < myNestedList.size() - 1;
        }
    }
}
