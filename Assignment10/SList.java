package Assignment10;

import java.util.Iterator;

public class SList<T>{

    static class SNode<T>{
        T data;
        SNode<T> next;
        SNode(T data)
        {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "SNode{" +
                        data +
                    '}';
        }
    };

    SNode<T> head;

    public SListIterator<T> iterator() {
        return new SListIterator<T>(this);
    }

    public String toString()
    {
        SListIterator<T> itr = iterator();
        String makeString = "[ ";
        while(itr.hasNext())
            makeString += itr.next() + " , ";
        makeString = makeString.substring(0, makeString.length() - 2) + " ]";
        return makeString;
    }
}

class SListIterator<T>
{
    SList<T> list;
    SList.SNode<T> curr;

    SListIterator(SList<T> list)
    {
        this.list = list;
        this.curr = this.list.head;
    }

    public void add(T data)
    {
        SList.SNode<T> temp = new SList.SNode<>(data);

        if(curr == null)
            this.list.head = this.curr = temp;

        else
        {
            temp.next = this.curr.next;
            this.curr.next = temp;

            this.curr = this.curr.next;
        }

    }

    public void remove()
    {
        if(this.list.head == this.curr)
        {
            this.list.head = this.curr = this.list.head.next;
            return;
        }

        if(this.list.head.next == null)
        {
            this.list.head = this.curr = null;
            return;
        }

        if(this.list.head == null)
            return;

        if(this.curr == null)
            return;

        SList.SNode<T> temp = this.list.head;
        while(temp.next != this.curr)
            temp = temp.next;

        temp.next = this.curr.next;
        this.curr = temp;
    }

    public void reset()
    {
        this.curr = this.list.head;
    }

    public boolean hasNext() {
        return curr != null;
    }

    public SList.SNode<T> next() {

        SList.SNode<T> temp = this.curr;
        this.curr = this.curr.next;
        return temp;
    }
}
