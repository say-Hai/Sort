public class SelectionSort {
    //选择排序
    public static void SelectionSort(Comparable[] a)
    {
        int N = a.length;
        for(int i= 0; i<a.length; i++)
        {
            int min = i;
            for(int j=i+1; j<a.length; j++)
            {
                if( Sort.less ( a[j],a[min] ))
                {
                    min = j;
                }
            }
            Sort.exch(a, i, min);                            //交换i，m
        }
    }
}
