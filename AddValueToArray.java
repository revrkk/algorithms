import java.util.Arrays;

public class AddValueToArray
{   
    static int[] helperArray = new int[10];

    public static void main(String[] args)
    {
        int[] result = new int[10];
        add(1, 3, 5);
  		// 0,5,0,-5,0,0,0,0,0,0,
		Arrays.stream(helperArray).mapToObj(s->(s+",")).forEach(System.out::print);
		System.out.println();
        add(3, 7, 7);
        // 0,5,0,2,0,0,0,-7,0,0,
        Arrays.stream(helperArray).mapToObj(s->(s+",")).forEach(System.out::print);
		System.out.println();
        add(4, 9, 10);
        // 0,5,0,2,10,0,0,-7,0,-10,
		Arrays.stream(helperArray).mapToObj(s->(s+",")).forEach(System.out::print);
		System.out.println();
        int temp = 0;
        for (int i = 0; i < 10; i++)
        {
            if (helperArray[i] != 0)
            {
                temp += helperArray[i];
            }
            result[i] += temp;
        }
		// 0,5,5,7,17,17,17,10,10,0,
        Arrays.stream(result).mapToObj(s->(s+",")).forEach(System.out::print);
        // 0,5,5,12,17,17,17,17,10,10
    }
    public static void add(int sI, int eI, int value)
    {
        helperArray[sI] += value;
        if(eI < 9)
        	helperArray[eI+1] -= value;
    }
}