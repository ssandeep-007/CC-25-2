import java.util.*;
class TwoSum 
{
    public void findTwoSum(int[] arr, int target) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) 
        {
            int required = target - arr[i];
            if (map.containsKey(required)) 
            {
                System.out.println("Finding two indices whose values add up to " + target + "...");
                System.out.println("Indices: " + map.get(required) + " " + i);
                return;
            }
            map.put(arr[i], i);
        }
        System.out.println("No solution found");
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        TwoSum obj = new TwoSum();
        obj.findTwoSum(arr, target);
    }
}
