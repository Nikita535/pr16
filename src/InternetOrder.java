public class InternetOrder implements Order {
    protected int size;
    protected ListNode head;
    protected ListNode tail;

    public InternetOrder() {//не принимает параметров,пустой список
        head = new ListNode();
        size = 1;
        head.next = tail;
        tail.next = head;
    }
    public InternetOrder(Item[] items)//массив позиций заказа
    {
        for (Item i:items)
        {
            this.add(i);
        }
    }
    @Override
    public void add(Item item)
    {
        if (head.value == null)
        {
            head=new ListNode(null,item);
        }
        else
        {
            ListNode current=head;
            while (current.next!=null&&current.next!=head)
            {
                current=current.next;
            }
            ListNode newNode=new ListNode(head,item);
            tail=newNode;
            current.next=newNode;
            size++;
        }
    }

    public boolean removeItem(String itemName)
    {
        boolean isRemove=false;
        ListNode current=head;
        ListNode toRemove=null;
        while (current.next!=head)
        {
            if  (current.value.getName()==itemName)
            {
                toRemove=current;
                isRemove=true;
            }
            current=current.next;
        }
        if (toRemove==head)
        {
            tail.next=head.next;
            head=toRemove.next;
            size--;
        }else
            if (toRemove==tail)
        {
            ListNode prev=head;
            while (prev.next!=tail)
            {
                prev=prev.next;

            }
            prev.next=head;
            tail=prev;
            size--;
        }
        else
        {
            ListNode prev=head;
            current=head.next;
            while (current.next!=head) {
                if (current==toRemove)
                {
                    prev.next=current.next;
                    size--;
                }
                prev=current;
                current=current.next;
            }
        }
        return isRemove;
    }

    @Override
    public Item[] getItems()
    {
        Item[] items=new Item[size];
        ListNode current =head;
        int i=0;
        do
        {
            items[i]=current.value;
            current=current.next;
            i++;
        }while (current.next!=head);
        return items;
    }
    @Override
    public double getTotalCost()
    {
        double cost=0;
        ListNode current =head;
        do
        {
            cost+=current.value.getCost();
            current=current.next;
        }while (current.next!=head);
        return cost;
    }

    @Override
    public int getItemscount(String Itemname) {
        ListNode current=head;
        int count =0;
        do
        {
            if (current.value.getName()==Itemname) {
                count++;
            }
            current=current.next;
        }while (current.next!=head);
        return count;
    }



    public Item[] getItemsSort()
    {
        Item[] items=new Item[size];
        ListNode current=head;
        for (int i=0;i<size;i++)
        {
            items[i]=current.value;
            current=current.next;
        }
        for (int i=0;i<size-1;i++) {
            for (int j = i + 1; j < size; j++) {
                if (items[i].getCost()<items[j].getCost())
                {
                    Item temp=items[i];
                    items[i]=items[j];
                    items[j]=temp;
                }
            }
        }
        return items;
    }
}
