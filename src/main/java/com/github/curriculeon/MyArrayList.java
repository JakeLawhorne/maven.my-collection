package com.github.curriculeon;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<SomeType> implements MyCollectionInterface<SomeType>{
    private SomeType[] elements;

    public MyArrayList(SomeType[] valuesToBePopulatedWith) {
        this.elements = valuesToBePopulatedWith;
    }
    @SuppressWarnings("unchecked")
    public MyArrayList(){
        this.elements = (SomeType[]) new Object[0];
    }
    @Override
    public void add(SomeType objectToAdd) {
        this.elements = Arrays.copyOf(elements, elements.length + 1);
        this.elements[elements.length - 1] = objectToAdd;
    }

    @Override
    public void remove(SomeType objectToRemove) {
        SomeType[] elements2 = elements;
        this.elements = Arrays.copyOf(elements, elements.length - 1);
        for(int i = 0; i < elements2.length; i++){
            if(elements2[i] != objectToRemove){
                elements[i] = elements2[i];
            }
        }
    }

    @Override
    public void remove(final int indexOfObjectToRemove) {
        int startingIndex = indexOfObjectToRemove <= 0 ? 1 : indexOfObjectToRemove;
        int destPos = elements.length - 1;
        int rightLength = destPos - indexOfObjectToRemove;
        int leftLength = indexOfObjectToRemove - startingIndex + 1;

        SomeType[] leftCopy = Arrays.copyOf(elements, leftLength);
        SomeType[] rightCopy = Arrays.copyOf(elements, rightLength);
        SomeType[] finalCopy = Arrays.copyOf(elements, destPos - 1);
        System.arraycopy(elements, indexOfObjectToRemove + 1, rightCopy, destPos, rightLength);

        for(int i = 0; i < indexOfObjectToRemove; i++){
            finalCopy[i] = leftCopy[i];
        }
        for(int i = indexOfObjectToRemove + 1; i < finalCopy.length; i++){
            finalCopy[i] = rightCopy[i - indexOfObjectToRemove];
        }
        this.elements = finalCopy;
    }

    @Override
    public SomeType get(int indexOfElement) {
        return elements[indexOfElement];
    }

    @Override
    public Boolean contains(SomeType objectToCheckFor) {
        boolean containsCheck = false;
        for(SomeType something : elements){
            if (something == objectToCheckFor) {
                containsCheck = true;
                break;
            }
        }
        return containsCheck;
    }

    @Override
    public Integer size() {
        return elements.length;
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(elements).iterator();
    }
}
