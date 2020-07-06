import java.util.Random;

public class Quick3Sort {
    //三向切分
    public static void Quick3Sort(Comparable []a)
    {
        Quick3way(a, 0, a.length-1);
    }
    public static void Quick3way(Comparable []a, int lo, int hi)
    {
        if(hi <= lo +15)
        {
            InsertionSort.InsertionSort1(a, lo, hi);
            return;
        }
        //随机生成在[lo,hi]范围的随机数
        Random r = new Random();
        int k = r.nextInt(hi+1 - lo) + lo;
        Sort.exch(a,lo, k);

        int lt = lo, i = lo + 1, gt = hi;
        Comparable e = a[lo];
        while(i <= gt)
        {
            int cmp = a[i].compareTo(e);
            if(cmp < 0)
                Sort.exch(a, lt++, i++);
            else if(cmp > 0)
                Sort.exch(a, i ,gt--);
            else
                i++;
        }
        Quick3way(a, lo, lt-1);
        Quick3way(a, gt + 1, hi);
    }
}
