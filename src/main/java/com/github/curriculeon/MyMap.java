package com.github.curriculeon;

public class MyMap<KeyType, ValueType> implements MyMapInterface<KeyType, ValueType>{
    KeyValue<KeyType, ValueType> keyPair;
    MyArrayList<KeyValue> map = new MyArrayList<>();

    @Override
    public void put(KeyType key, ValueType value) {
        keyPair = new KeyValue<>(key, value);
        map.add(keyPair);
    }

    @Override
    public ValueType get(KeyType key) {
        for(KeyValue pair : map){
            if(pair.getKey() == key){
                return (ValueType) pair.getValue();
            }
        }
        return null;
    }

    @Override
    public MySet<KeyType> getKeySet() {
        return null;
    }

    @Override
    public MyCollectionInterface<ValueType> getValues() {
        return null;
    }

    @Override
    public MySet<KeyValue<KeyType, ValueType>> getList() {
        return null;
    }

    @Override
    public MyMapInterface<ValueType, KeyType> invert() {
        return null;
    }
}
