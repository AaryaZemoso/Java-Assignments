package Assignment10;

import java.util.Iterator;

public class SList<T>{

    static class SNode<T>{
        T data;
        SNode next;
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

    SNode head;

    public SListIterator iterator() {
        return new SListIterator<T>(this);
    }

    public String toString()
    {
        SListIterator itr = iterator();
        String makeString = "[ ";
        while(itr.hasNext())
            makeString += itr.next() + " , ";
        makeString = makeString.substring(0, makeString.length() - 2) + " ]";
        return makeString;
    }
}

class SListIterator<T>
{
    SList list;
    SList.SNode<T> curr;

    SListIterator(SList<T> list)
    {
        this.list = list;
        this.curr = this.list.head;
    }

    public void add(T data)
    {
        SList.SNode temp = new SList.SNode(data);

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
        if(this.curr.next == null)
            this.curr = this.list.head = null;

        else
        {
            this.curr.next = this.curr.next.next;
        }
    }

    public void reset()
    {
        this.curr = this.list.head;
    }

    public boolean hasNext() {
        return curr != null;
    }

    public SList.SNode next() {

        SList.SNode temp = this.curr;
        this.curr = this.curr.next;
        return temp;
    }
}
