import java.util.Comparator;

public class MaxPQ <Key extends Comparable<Key>>
{
    private Key [] pq;
    private int N = 0;

    public MaxPQ(int MaxN)
    {
        pq = (Key[]) new Comparable[MaxN+1];
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void insert(Key v)
    {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax()
    {
        Key max = pq[1];
        exch(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }
    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i,int j)
    {
        Key t =pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    //元素上浮，由下至上堆有序化
    private void swim(int k)
    {
        //如果父节点pq[k/2]小于子节点pq[k],则交换两者位置
        while(k>1 && less(k/2 ,k))
        {
            exch(k/2,k);
            k = k/2;        //将此位置作为子节点继续进行上浮操作。
        }
    }
    //元素下沉，由上至下堆有序化
    private void sink(int k)
    {
        //当子节点在数组范围之内。
        while(2*k <= N)
        {
            int j = 2*k;
            //j代表两个子节点中的最大值pq[2k]和pq[2k+1]
            if(j < N && less(j, j+1))
                j++;
            //如果父节点pq[k]大于子节点pq[j]，则不需要下沉。
            if(!less(k,j))
                break;
            exch(k, j); //否则交换两者位置继续下沉。
            k = j;
        }
    }

}
