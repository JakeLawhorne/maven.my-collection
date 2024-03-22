package com.github.curriculeon;

import java.util.Arrays;
import java.util.Iterator;

public class MySet<SomeType> implements MyCollectionInterface<SomeType>{
    SomeType[] elements;
    @SuppressWarnings("unchecked")
    public MySet() {
        this.elements = (SomeType[]) new Object[0];
    }

    public MySet(SomeType[] valuesToBePopulatedWith) {
        this.elements = valuesToBePopulatedWith;
    }

    @Override
    public void add(SomeType objectToAdd) {
        if(this.contains(objectToAdd)){
            return;
        }else{
            this.elements = Arrays.copyOf(elements, elements.length + 1);
            this.elements[elements.length - 1] = objectToAdd;
        }
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
    public void remove(int indexOfObjectToRemove) {
        final int rightCopyStartIndex = 0;
        final int finalArrayLength = elements.length - 1;
        final int rightLength = finalArrayLength - indexOfObjectToRemove;
        final int leftLength = indexOfObjectToRemove <= 0 ? 1 : indexOfObjectToRemove;

        SomeType[] leftCopy = Arrays.copyOf(elements, leftLength);
        SomeType[] rightCopy = Arrays.copyOf(elements, rightLength);
        SomeType[] finalCopy = Arrays.copyOf(elements, finalArrayLength);
        System.arraycopy(elements, indexOfObjectToRemove + 1, rightCopy, rightCopyStartIndex, rightLength);

        for(int i = 0; i < indexOfObjectToRemove; i++){
            finalCopy[i] = leftCopy[i];
        }
        if(indexOfObjectToRemove < elements.length - 1) {
            for (int i = indexOfObjectToRemove; i < finalCopy.length; i++) {
                finalCopy[i] = rightCopy[i - indexOfObjectToRemove];
            }
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
            if (something.equals(objectToCheckFor)) {
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
    public Iterator<SomeType> iterator() {
        return Arrays.stream(elements).iterator();
    }
}
