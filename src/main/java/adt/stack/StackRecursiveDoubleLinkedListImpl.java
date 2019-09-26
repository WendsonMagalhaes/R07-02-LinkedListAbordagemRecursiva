package adt.stack;

import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

   protected RecursiveDoubleLinkedListImpl<T> top;
   protected int size;

   public StackRecursiveDoubleLinkedListImpl(int size) {
      this.size = size;
      this.top = new RecursiveDoubleLinkedListImpl<T>();
   }

   @Override
   public void push(T element) throws StackOverflowException {
      if (this.isFull()) {
         throw new StackOverflowException();
      }
      this.top.insert(element);
   }

   @Override
   public T pop() throws StackUnderflowException {

      if (this.isEmpty()) {
         throw new StackUnderflowException();
      }

      T element = this.top();
      this.top.removeLast();

      return element;
   }

   @Override
   public T top() {

      T top = null;
      if (!this.isEmpty()) {
         top = this.top.toArray()[this.top.size() - 1];
      }

      return top;
   }

   @Override
   public boolean isEmpty() {

      return this.top.size() == 0;
   }

   @Override
   public boolean isFull() {

      return this.top.size() == this.size;
   }

}
