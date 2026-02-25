package tdd;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack{

    private final Deque<Integer> stack;

    MinMaxStackImpl(){
        stack = new ArrayDeque<Integer>();
    }

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
        if(!stack.isEmpty()){
            return stack.pop();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public int peek() {
        if(!stack.isEmpty()){
            return stack.peek();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public int getMin() {
        if (!stack.isEmpty()) {
            return getSortedListFromStack().get(0);
        } else {
            throw new IllegalStateException("The stack is empty");
        }
    }

    @Override
    public int getMax() {
        if (!stack.isEmpty()) {
            List<Integer> stackToList = getSortedListFromStack();
            return getSortedListFromStack().get(stackToList.size() - 1);
        } else {
            throw new IllegalStateException("The stack is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    private List<Integer> getSortedListFromStack(){
        List<Integer> stackToList = new ArrayList<>(this.stack);
        stackToList.sort(Integer::compareTo);
        return stackToList;
    }
}
