package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    public CustomTree() {
        root = new Entry<>("0");
        root.availableToAddRightChildren = true;
        root.availableToAddLeftChildren = true;
        root.parent = null;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<String> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddRightChildren = true;
            availableToAddLeftChildren = true;
        }

        public boolean isAvailableToAddChildren() {

            return (availableToAddLeftChildren | availableToAddRightChildren);
        }
    }

    public String getParent(String s) {
        Queue<Entry<String>> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            Entry<String> iEntry = stack.poll();
            if (iEntry.elementName.equals(s)) {
                return iEntry.parent.elementName;
            } else {
                if (iEntry.leftChild != null) {
                    stack.offer(iEntry.leftChild);
                }
                if (iEntry.rightChild != null) {
                    stack.offer(iEntry.rightChild);
                }
            }
        }
        return "null";
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        Queue<Entry<String>> stack = new LinkedList<>();
        stack.offer(root);
        int count = 0;
        while (!stack.isEmpty()) {
            Entry<String> iEntry = stack.poll();
            count++;
            if (iEntry.leftChild != null) {
                stack.offer(iEntry.leftChild);
            }
            if (iEntry.rightChild != null) {
                stack.offer(iEntry.rightChild);
            }
        }
        count--;
        return count;
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            Entry<String> iEntry = stack.poll();
            if (iEntry != null) {
                if (iEntry.isAvailableToAddChildren()) {
                    if (iEntry.availableToAddLeftChildren) {
                        iEntry.leftChild = new Entry<>(s);
                        iEntry.leftChild.parent = iEntry;
                        iEntry.availableToAddLeftChildren = false;
                        return true;
                    } else {
                        if (iEntry.availableToAddRightChildren) {
                            iEntry.rightChild = new Entry<>(s);
                            iEntry.rightChild.parent = iEntry;
                            iEntry.availableToAddRightChildren = false;
                            return true;
                        }
                    }
                } else {
                    stack.offer(iEntry.leftChild);
                    stack.offer(iEntry.rightChild);
                }
        }
        }
        if (nullTreeAdd(s)) {
            return true;
        }

        return false;
    }

    public boolean nullTreeAdd(String s) {
        Queue<Entry<String>> stack = new LinkedList<>();
        Entry<String> iEntry;
        stack.offer(root);
        while (!stack.isEmpty()) {
            iEntry = stack.poll();
            if (!iEntry.isAvailableToAddChildren()) {
                if (iEntry.leftChild == null) {
                    iEntry.availableToAddLeftChildren = true;
                } else {
                    stack.offer(iEntry.leftChild);
                }
            if (iEntry.rightChild == null) {
                iEntry.availableToAddRightChildren = true;
            } else
            {
                stack.offer(iEntry.rightChild);
            }
        } else {
                if (iEntry.leftChild != null) {
                    stack.offer(iEntry.leftChild);
                }
                if (iEntry.rightChild != null) {
                    stack.offer(iEntry.rightChild);
                }
            }
        }
        stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            iEntry = stack.poll();
            if (iEntry != null) {
                if (iEntry.isAvailableToAddChildren()) {
                    if (iEntry.availableToAddLeftChildren) {
                        iEntry.leftChild = new Entry<>(s);
                        iEntry.leftChild.parent = iEntry;
                        iEntry.availableToAddLeftChildren = false;
                        return true;
                    } else {
                        if (iEntry.availableToAddRightChildren) {
                            iEntry.rightChild = new Entry<>(s);
                            iEntry.rightChild.parent = iEntry;
                            iEntry.availableToAddRightChildren = false;
                            return true;
                        }
                    }
                } else {
                    stack.offer(iEntry.leftChild);
                    stack.offer(iEntry.rightChild);
                }
            }
        }
        return false;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
            throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        try {
            Queue<Entry<String>> stack = new LinkedList<>();
            stack.offer(root);
            while (!stack.isEmpty()) {
                Entry<String> iEntry = stack.poll();
                if (iEntry.elementName.equals((String) o)) {
                    if (iEntry.parent.rightChild == iEntry) {
                        iEntry.parent.rightChild = null;
                        iEntry = null;
                        return true;
                    }
                    else {
                        if (iEntry.parent.leftChild == iEntry) {
                            iEntry.parent.leftChild = null;
                            iEntry = null;
                            return true;
                        }
                    }
                } else {
                    if (iEntry.rightChild != null) {
                        stack.offer(iEntry.rightChild);
                    }
                    if (iEntry.leftChild != null) {
                        stack.offer(iEntry.leftChild);
                    }
                }
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
