
public class InsertionSort {
    //插入排序
    public static void InsertionSort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 1; i < N; i++)
        {
            int j;
            Comparable e = a[i];
            for(j= i; j > 0 && Sort.less( e, a[j-1] ); j--)
            {
                a[j] = a[j-1];
            }
            a[j] = e;
        }
    }
    public static void InsertionSort1(Comparable []a, int hi, int lo)
    {
        for(int i = hi + 1; i <= lo; i++)
        {
            int j;
            Comparable e = a[i];
            for(j = i; j > hi && Sort.less(e,a[j-1]); j--)
            {
                a[j] = a[j-1];
            }
            a[j] = e;
        }
    }

}
