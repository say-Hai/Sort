public class MergeSort {
    //自顶向下的归并排序
    public static void MergeSort(Comparable []a)
    {
        Msort(a,0,a.length-1);
    }
    public static void Msort(Comparable []a, int lo, int hi)
    {
        if(hi <= lo)
            return ;
        int mid = lo +(hi - lo)/2;
        //递归实现归并
        Msort(a,lo,mid);     //左边排序
        Msort(a,mid+1,hi);  //右边排序
        merge(a,lo,mid,hi); //归并结果
    }
    //merge()原地归并的抽象方法
    public static void merge(Comparable []a,int lo,int mid,int hi)
    {
        //将a[lo...mid]和a[mid+1...hi]进行归并
        int i = lo, j = mid + 1;

        if(hi - lo < 15)    //如果子数组小于15，则调用插入排序
        {
            InsertionSort.InsertionSort1(a,lo,hi);
            return;
        }
        Comparable [] aux = new Comparable[a.length];   //辅助数组
        for(int k = lo; k <= hi; k++)
        {
            aux [k] = a[k];
        }
        for(int k = lo; k <= hi; k++)
        {
            if(i > mid)     //左半边取尽
                a[k] = aux[j++];
            else if(j > hi)     //右半边取尽
                a[k] = aux[i++];
            else if(Sort.less(aux[i],aux[j]))    //两边较小元素
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }
}
