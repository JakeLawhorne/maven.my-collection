package com.github.curriculeon.mylinkedlist;

import com.github.curriculeon.ImportChecker;
import com.github.curriculeon.MyLinkedList;
import com.github.curriculeon.MyCollectionInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author leonhunter
 * @created 12/15/2019 - 8:20 PM
 */
@SuppressWarnings("all")
public class RemoveByIndex {
    //given
    private <SomeType> void test(int indexOfElementToRemove, SomeType[] valuesToBePopulatedWith, SomeType[] expectedElementSequence) {
        MyLinkedList<SomeType> myList = new MyLinkedList<>();
//        ImportChecker.scanClass(myList.getClass(), "java.util", "MyArrayList", "MySet", "MyCollectionInterface");
        MyCollectionInterface<SomeType> myCollection = (MyCollectionInterface<SomeType>) myList;

        // given elements have been added to collection
        for (SomeType someValue : valuesToBePopulatedWith) {
            myCollection.add(someValue);
            Boolean myCollectionContainsValue = myCollection.contains(someValue);
            Assert.assertTrue(myCollectionContainsValue);
        }
        Integer preRemoveLength = myCollection.size(); // get size of collection
        Integer expectedPreRemoveLength = valuesToBePopulatedWith.length;
        Assert.assertEquals(expectedPreRemoveLength, preRemoveLength); // ensure length is correct
        Integer expectedPostRemoveLength = preRemoveLength - 1;// get the expected post-removal length

        // when
        myCollection.remove(indexOfElementToRemove);
        Integer postRemoveLength = myCollection.size(); // get size of collection
        Integer actualPostRemoveLength = postRemoveLength; // get the actual post-removal length

        // then
        Assert.assertEquals(expectedPostRemoveLength, actualPostRemoveLength);
        for (int currentIndex = 0; currentIndex < expectedElementSequence.length; currentIndex++) {
            SomeType expectedElement = expectedElementSequence[currentIndex];
            SomeType actualElement = myCollection.get(currentIndex);
            Assert.assertEquals(expectedElement, actualElement);
        }
    }


    @Test
    public void test0() {
        String[] valuesToPopulateCollection = new String[]{"The", "Quick", "Brown", "Fox"};
        String[] expectedElementSequence = new String[]{"The", "Brown", "Fox"};
        int indexOfElementToRemove = 1;
        test(indexOfElementToRemove, valuesToPopulateCollection, expectedElementSequence);
    }


    @Test
    public void test1() {
        Integer[] valuesToPopulateCollection = new Integer[]{1,3,5,8,13};
        Integer[] expectedElementSequence = new Integer[]{3,5,8,13};
        int indexOfElementToRemove = 0;
        test(indexOfElementToRemove, valuesToPopulateCollection, expectedElementSequence);
    }

    @Test
    public void test2() {
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        Date[] valuesToPopulateCollection = new Date[]{d1,d2,d3};
        Date[] expectedElementSequence = new Date[]{d1,d2};
        int indexOfElementToRemove = 2;
        test(indexOfElementToRemove, valuesToPopulateCollection, expectedElementSequence);
    }
}
