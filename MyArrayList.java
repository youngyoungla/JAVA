import java.util.ArrayList;

/**
 * Created by zhao on 2018/8/29.
 */

//Java 中ArrayList
//动态数组 list接口的可变接口实现
//不是线程安全，只适用于单进程
public class MyArrayList<T> {
    private Object[] arrayList; //数组
    private int size;  //包含的元素数量
    private int capacity;
    //无参构造函数
    public MyArrayList()
    {
        capacity=10;
        size=0;
        arrayList= new Object[capacity];

    }
    //有参构造函数
    public MyArrayList(int capacity)
    {
        if(capacity <=0)
        {
            throw new RuntimeException("必须大于0");
        }
        this.capacity=capacity;
        arrayList =new Object[capacity];

    }

    public int size()
    {
        return size;
    }
    public int capacity(){
        return capacity;
    }
   /*线性表扩充 */
   public void extendsArrayList()
   {
       if(size>=capacity)
       {
           Object[] newArrayList =new Object[size* 2+1];
           this.capacity =size*2 +1;
           for(int i=0;i<size;i++)
           {
               newArrayList[i]=arrayList[i];
           }
           arrayList=newArrayList;
       }
   }
   public boolean add(T obj)
   {
       extendsArrayList();
       arrayList[size]=obj;
       size++;
       return true;
   }
   // 指定位置添加
    public boolean add(int index,T obj)
    {
        extendsArrayList();
        if(index<size &&index >=0)
        {
            for(int i=size;i>index;i--)
            {

                arrayList[i]=arrayList[i+1];

            }
            arrayList[index]=obj;
            size++;
            return true;
        }
        else if(size==index)
        {
            add(obj);
            size++;
            return true;
        }
        else
        {
            return false;
        }

    }

    //删除指定位置的元素
    public boolean remove(int index) {
        if (index < size) {
            for (int i = index; i < size - 1; i++) {
                arrayList[i] = arrayList[i + 1];
            }
            arrayList[size] = null;
            size--;
            return true;
        }
        else
        {
            return false;
        }
    }

    //删除元素
    public boolean remove(T obj)
    {
        for(int i=0;i<size;i++)
        {
            if(arrayList[i].equals(obj))   //equals 比较
            {
                remove(i);
                break;
            }
        }
        return false;
    }

    //修改
    public Boolean set(int index,T obj)
    {
        if(index <size)
        {
            arrayList[index] =obj;
            return true;
        }
        else
        {
            return false;
        }

    }

    //返回指定元素的位置
    public int indexOf(T obj)
    {
        for(int i=0;i<size;i++)
        {
            if(obj.equals(arrayList[i]))
            {
                return i;
            }
        }
        return -1;
    }

    //返回数据对象
    public Object[] toArray(){
       return arrayList;
    }

    //查看是否包含
    public Boolean contains(T obj)
    {
        for(int i=0;i<size;i++)
        {
            if(arrayList[i].equals(obj))
            {
                return true;
            }
        }
        return false;
    }

    public static void  main(String[] args)
    {
        MyArrayList<Integer> list=new MyArrayList<Integer>();
        list.add(34);
        System.out.println(list.contains(34));
        list.add(35);
        System.out.println(list.size());
        list.remove(56);


    }
}
