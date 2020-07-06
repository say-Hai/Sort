import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.min;

public class Sort {
    //比较方法
    public static boolean less(Comparable v, Comparable w)
    {
        //接口Comparable的方法
        return v.compareTo(w) < 0;
    }
    //交换方法
    public static void exch( Comparable [] a , int i , int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //打印输出方法
    private static void show(Comparable [] a)
    {
        for( int i=0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    //验证是否有序方法
    public  static boolean isSorted(Comparable [] a)
    {
        for(int i=1; i<a.length; i++)
        {
            if( less( a[i] , a[i-1] ))
                return false;
        }
        return true;
    }
    //计算每种排序之间运行时间的大小
    public static double time(String alg, Comparable[] a)      //计算:"alg"方法排序a数组所需要的时间
    {
        double startTime=System.currentTimeMillis();            //该方法的作用是返回当前的计算机时间
        if(alg.equals("SelectionSort"))
        {
            SelectionSort.SelectionSort(a);
        }
        if(alg.equals("InsertionSort"))
        {
            InsertionSort.InsertionSort(a);
        }
        if(alg.equals("ShellSort"))
        {
            ShellSort.ShellSort(a);
        }
        if(alg.equals("MergeSort"))
        {
            MergeSort.MergeSort(a);
        }
        if(alg.equals("MergeSortBU"))
        {
            MergeSortBU.MergeSortBU(a);
        }
        if(alg.equals("QuickSort"))
        {
            QuickSort.QuickSort(a);
        }
        if(alg.equals("Quick3way"))
        {
            Quick3Sort.Quick3Sort(a);
        }
        double endTime=System.currentTimeMillis();
        return (endTime-startTime);                            //计算所用时间
    }
    //用随机数形成T个N大小的数组进行排序
    public static double timeRandomInput(String alg, int N, int T) //利用算法将T个长度为N的数组排序
    {
        double total = 0.0;         //T个数组排序所用的总时间
        Random r = new Random();                              //创建随机数种子
        for(int t = 0; t< T; t++)
        {
            Comparable [] a = new Comparable[N];        //形成所用数组
            for(int i=0; i<N; i++)
            {
                a[i] = r.nextDouble()*100;                  //随机数在0-100之间的double数
            }
            total += time(alg,a);
            //检查排序是否正确
            if(!isSorted(a))
            {
                System.out.println(alg + "："+"出错");
                return 0;
            }
        }
        System.out.println(alg + "："+total + "ms");     //打印输出结果
        return total;
    }
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);                 //Java标准输入
        int T = sc.nextInt();
        int N = sc.nextInt();
        double t1 = timeRandomInput("SelectionSort",N,T);
        double t2 = timeRandomInput("InsertionSort",N,T);
        double t3 = timeRandomInput("ShellSort",N,T);
        double t4 = timeRandomInput("MergeSort",N,T);
        double t5 = timeRandomInput("MergeSortBU",N,T);
        double t6 = timeRandomInput("QuickSort",N,T);
        double t7 = timeRandomInput("Quick3way",N,T);

 /*
        Random r = new Random();                              //创建随机数种子
        Comparable [] a = new Comparable[20];
        for(int i=0; i<20; i++)
        {
            a[i] = r.nextInt(100);                  //随机数在0-100之间的double数
        }
        Quick3Sort(a);
        show(a);
*/
    }
}
