import java.util.*;

class MaxProduct 
{
    public int findMaxProduct(int[] arr) 
    {
        Set<Integer> unique = new HashSet<>();
        for (int num : arr) 
        {
            unique.add(num);
        }
        if (unique.size() < 3) 
        {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : unique) 
        {
            minHeap.offer(num);
            if (minHeap.size() > 3) 
            {
                minHeap.poll();
            }
        }
        int product = 1;
        while (!minHeap.isEmpty()) 
        {
            product *= minHeap.poll();
        }

        return product;
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }
        MaxProduct obj = new MaxProduct();
        System.out.println(obj.findMaxProduct(arr));
    }
}
