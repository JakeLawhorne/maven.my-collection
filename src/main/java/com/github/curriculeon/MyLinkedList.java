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
        if(head.getData() == objectToRemove){
            head = head.getNext();
            return;
        }
        MyNode<SomeType> temp = head;
        boolean found = false;
        while(!found){
            if(temp.getNext().getData() == objectToRemove){
                temp.setNext(temp.getNext().getNext());
                found = true;
        }else{
                temp = temp.getNext();
            }
        }
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        if(indexOfObjectToRemove == 0){
            head = head.getNext();
            return;
        }
        MyNode<SomeType> temp = head;
        int counter = 1;
        boolean found = false;
        while(!found){
            if(counter == indexOfObjectToRemove){
                temp.setNext(temp.getNext().getNext());
                found = true;
            }else{
                temp = temp.getNext();
                counter++;
            }
        }

    }

    @Override
    public SomeType get(int indexOfElement) {
        int count = 0;
        Iterator<SomeType> itr = new MyLinkedListIterator();
        while(itr.hasNext()){
            if(count == indexOfElement){
                return itr.next();
            }else{
                itr.next();
                count++;
            }
        }
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
        int count = 0;
        Iterator<SomeType> itr = new MyLinkedListIterator();
        while(itr.hasNext()){
            itr.next();
            count++;
        }
        return count;
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
