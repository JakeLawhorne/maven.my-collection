package com.github.curriculeon;

public class MyNode<SomeType> {
    private SomeType data;
    private MyNode<SomeType> next;

    public MyNode() {
    }

    public MyNode(SomeType data, MyNode<SomeType> next) {
            this.data = data;
            this.next = next;
    }

    public SomeType getData() {
        return this.data;
    }

    public void setData(SomeType data) {
        this.data = data;
    }

    public MyNode<SomeType> getNext() {
        return this.next;
    }

    public void setNext(MyNode<SomeType> next) {
        if(this == next){
            throw new IllegalArgumentException();
        }else {
            this.next = next;
        }
    }
}
