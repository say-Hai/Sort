import java.util.Random;

public class QuickSort {
    //快速排序
    public static void QuickSort(Comparable []a)
    {
        Qsort(a, 0, a.length-1);
    }
    public static void Qsort(Comparable []a, int lo, int hi)
    {
        if(hi <= lo)
        {
            return;
        }
        int mid = partition(a, lo, hi);
        Qsort(a, lo, mid-1);
        Qsort(a, mid+1, hi);
    }
    //快排的切分
    public static int partition(Comparable []a,int lo, int hi)
    {
        //随机生成在[lo,hi]范围的随机数
        Random r = new Random();
        int k = r.nextInt(hi+1 - lo) + lo;
        Sort.exch(a,lo, k);

        Comparable e = a[lo];
        int i = lo, j = hi + 1;
        while(true)
        {
            while(Sort.less(a[++i], e))
            {
                if(i == hi)
                    break;
            }
            while(Sort.less(e, a[--j]))
            {
                if( j == lo)
                    break;
            }
            if(i >= j)
                break;
            Sort.exch(a, i, j);
        }
        Sort.exch(a, lo, j);
        return j;
    }
}
