import static java.lang.Integer.min;

public class MergeSortBU {
    //自底向上的归并排序
    public static void MergeSortBU(Comparable []a)
    {
        int n = a.length;
        for (int sz = 1; sz < n; sz += sz)  //子数组的大小：1,2,4,8...
        {
            for (int lo = 0; lo + sz < n; lo += sz+sz)
                MergeSort.merge(a, lo, lo + sz-1, min(lo + sz + sz-1, n - 1));
        }
    }
}
