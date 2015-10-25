/**
 * Created by Paritosh Dave on 10/25/2015.
 *
 * This class works on two non negative integer number, convert them in binary format and then apply binary summation and
 * later converts the binary outcome to decimal format. The eventual result would be the sum of the two given numbers
 * The class contains two useful utility methods:
 * 1) convertIntToBinaryArray(int i): convert decimal number to binary array
 * 2) convertBinaryArrToNumber(int[] arr): convert binary array to decimal number
 *
 * Note: size of the array used to capture the bit data is 32. This is due to the fact that in java, 4 Bytes( 32 bits)
 * are used to hold any integer data.
 */
public class BinaryAddition {

    public static void main(String... args)
    {
        int num1 = 1234;
        int num2 = 234;

        // boolean takes 1 bit and that is why boolean array is used (avoiding unnecessary memory usages)
        boolean[] arr1 = convertIntToBinaryArray(num1);
        boolean[] arr2 = convertIntToBinaryArray(num2);

        boolean[] resultArr = performSumOnBitsArray(arr1, arr2);

        System.out.println(num1+" + "+num2 +"  =  "+convertBinaryArrToNumber(resultArr));
    }

    private static boolean[] performSumOnBitsArray(boolean[] arr1, boolean[] arr2)
    {
        boolean[] resultArr = new boolean[arr1.length];

        boolean carryBit = false;
        for(int j = arr1.length-1; j >= 0; --j)
        {
            boolean bit1 = arr1[j];
            boolean bit2 = arr2[j];

            resultArr[j] = sumBits(bit1,  bit2,  carryBit);
            carryBit = carryBit(bit1, bit2, carryBit);
        }

        return resultArr;
    }

    private static boolean carryBit(boolean bit1, boolean bit2, boolean bit3)
    {
        if(bit1 == false && bit2 == false && bit3 == false)
            return false;
        if(bit1 == false && bit2 == false && bit3 ==true)
            return false;
        if(bit1 == false && bit2 == true && bit3 == false)
            return false;
        if(bit1 == false && bit2 == true && bit3 == true)
            return true;
        if(bit1 == true && bit2 == false && bit3 == false)
            return false;
        if(bit1 == true && bit2 == false && bit3 == true)
            return true;
        if(bit1 == true && bit2 == true && bit3 == false)
            return true;
        if(bit1 == true && bit2 == true && bit3 ==true)
            return true;
        return false;
    }

    private static boolean sumBits(boolean bit1, boolean bit2, boolean bit3)
    {
        if(bit1 == false && bit2 == false && bit3 == false)
            return false;
        if(bit1 ==false && bit2 == false && bit3 == true)
            return true;
        if(bit1 == false && bit2 == true && bit3 == false)
            return true;
        if(bit1 ==false && bit2 == true && bit3 == true)
            return false;
        if(bit1 == true && bit2 == false && bit3 == false)
            return true;
        if(bit1 == true && bit2 == false && bit3 == true)
            return false;
        if(bit1 ==true && bit2 == true && bit3 == false)
            return false;
        if(bit1 == true && bit2 == true && bit3 == true)
            return true;
        return false;
    }

    private static void printArr(boolean[] arr)
    {
        for(int i = 0; i< arr.length; ++i)
        {
            int val = arr[i]? 1: 0;
            System.out.print(val+"  ");
        }
        System.out.println();
    }

    private static boolean[] convertIntToBinaryArray(int num)
    {
        boolean[] arr = new boolean[32];

        for(int i = 31; i>=0 && num > 0; --i)
        {
            arr[i] = (num%2) == 0? false: true;
            num = num/2;
        }

        return arr;
    }

    private static int convertBinaryArrToNumber(boolean[] arr)
    {
        int num = 0;

        for(int i = arr.length-1; i >=0; --i)
        {
            int val = arr[arr.length -1 - i] == true? 1: 0;
            num = num+ val*((int)Math.pow(2,i));
        }

        return num;
    }
}
