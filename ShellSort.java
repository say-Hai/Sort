public class ShellSort {
    //希尔排序，实际上是移动间距为h的特殊插入排序
    public static void ShellSort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while(h < N/3)                      //从间距为N/3开始进行排序
            h = 3*h + 1;            //间距为1，4，13，40...
        while(h >= 1)
        {
            for(int i = h; i< N; i++)
            {
                for(int j = i; j>=h && Sort.less(a[j],a[j-h]); j-=h)
                {
                    Sort.exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }

}
