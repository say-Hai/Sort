public class HeapSort {
    //堆排序
    public static void heapsort(Comparable[] a)
    {
        int N = a.length - 1;
        for (int k = N/2; k >= 1; k--)
        {
            sink(a, k, N);
        }
        while(N > 1)
        {
            Sort.exch( a,1, N--);
            sink (a,1,N);
        }
    }
    public static void sink(Comparable[] a, int k, int N)
    {
        while(2*k <= N)
        {
            int j = 2 * k;
            if (j < N && Sort.less(a[j], a[j + 1]))
                j++;
            if (!Sort.less(a[k], a[j]))
                break;
            Sort.exch(a, k, j);
            k = j;
        }
    }
}
