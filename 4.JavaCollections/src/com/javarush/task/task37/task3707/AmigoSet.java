package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        int capacity = 16 > (collection.size()/.75f)? 16: (int) Math.ceil(collection.size() / .75f);
        this.map = new HashMap<>(capacity);
        for (E element:collection){
            this.map.put(element,PRESENT);
        }
    }

    public boolean add(E e){
        return map.put(e, PRESENT) == null;
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o) == PRESENT;
    }

    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }



    @Override
    public boolean equals(Object o) {

        if ((o == null)||!(o instanceof AmigoSet )) return false;

        if (this.hashCode()!= ((AmigoSet)o).hashCode()) return false;
        AmigoSet<E> compare = (AmigoSet)o;
        if (this.map.size()!= compare.map.size()) return false;
        for (E e: map.keySet()){
            if (!compare.contains(e)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.map.hashCode()*31+PRESENT.hashCode();
    }

    @Override
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.map.keySet().toArray(a);
    }
}
