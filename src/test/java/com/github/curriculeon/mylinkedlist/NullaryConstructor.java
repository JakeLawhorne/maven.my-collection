package com.github.curriculeon.mylinkedlist;

import com.github.curriculeon.ImportChecker;
import com.github.curriculeon.MyCollectionInterface;
import com.github.curriculeon.MyLinkedList;
import com.github.curriculeon.MySet;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * @author leonhunter
 * @created 12/15/2019
 */
@SuppressWarnings("all")
public class NullaryConstructor {
    @Test
    public void testPolymorphism() {
        //given
        MyLinkedList<?> myList = new MyLinkedList<>();
//        ImportChecker.scanClass(myList.getClass(), "java.util", "MyArrayList", "MySet", "MyCollectionInterface");

        // when
        Boolean isInstanceOfMySet = (Object) myList instanceof MySet;
        Boolean isInstanceOfList = myList instanceof List;
        Boolean isInstanceOfCollection = myList instanceof Collection;
        Boolean isInstanceOfIterable = myList instanceof Iterable;
        Boolean isInstanceOfMyCollection = myList instanceof MyCollectionInterface;

        // then
        Assert.assertTrue(!isInstanceOfMySet);
        Assert.assertTrue(!isInstanceOfList);
        Assert.assertTrue(!isInstanceOfCollection);
        Assert.assertTrue(isInstanceOfIterable);
        Assert.assertTrue(isInstanceOfMyCollection);
    }
}