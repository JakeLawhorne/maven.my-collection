package com.github.curriculeon;

import java.util.Iterator;

public class MyLinkedList<SomeType> implements MyCollectionInterface<SomeType>{
    private MyNode<SomeType> head;
    public MyLinkedList() {
        this.head = null;
    }

    public MyLinkedList(SomeType... valuesToBePopulatedWith) {
        for(SomeType thing : valuesToBePopulatedWith){
            this.add(thing);
        }

    }

    @Override
    public void add(SomeType objectToAdd) {
        MyNode<SomeType> newNode = new MyNode<>(objectToAdd);
        if(head == null){
            head = newNode;
        }else{
            MyNode<SomeType> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    @Override
    public void remove(SomeType objectToRemove) {

    }

    @Override
    public void remove(int indexOfObjectToRemove) {

    }

    @Override
    public SomeType get(int indexOfElement) {
        return null;
    }

    @Override
    public Boolean contains(SomeType objectToCheckFor) {
        boolean exists = false;
        Iterator<SomeType> itr = new MyLinkedListIterator();
        while(itr.hasNext()){
            if(itr.next() == objectToCheckFor){
                exists = true;
                break;
            }
        }
        return exists;
    }

    @Override
    public Integer size() {
        return null;
    }

    @Override
    public Iterator<SomeType> iterator() {
        return new MyLinkedListIterator();
    }
    private class MyLinkedListIterator implements Iterator<SomeType>{
        private MyNode<SomeType> current;

        public MyLinkedListIterator(){
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public SomeType next() {
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            SomeType data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}
