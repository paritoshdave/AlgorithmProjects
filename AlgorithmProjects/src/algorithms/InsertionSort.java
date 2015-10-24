package algorithms;

import java.lang.RuntimeException;

final public class InsertionSort
{
    public enum SORT_TYPE
    {
        ASC,
        DESC
    }

    static int[] inputArr ;

    private InsertionSort()
    {
        // do nothing
    }

    public static int[] sort(int[] arr, SORT_TYPE type)
    {
        inputArr = arr;
        applyInsertionSort(type);
        return inputArr;
    }

    private static void applyInsertionSort(SORT_TYPE type)
    {

        int arraySize = inputArr.length;

        switch(arraySize)
        {
            case 0:
            {
                System.out.println("Empty array.");
                throw new EmptyInputArray("Input array length is less than 0");
            }

            case 1:
                // single element array is considered sorted. Do nothing.
                break;

            default:
                for(int i = 1; i < inputArr.length; ++i)
                {
                    int val = inputArr[i];
                    int j = i-1;
                    while(j >= 0 && ((SORT_TYPE.ASC == type && inputArr[j] > val) || (SORT_TYPE.DESC == type && inputArr[j] < val)))
                    {
                        inputArr[j+1] = inputArr[j];
                        --j;
                    }
                    inputArr[j+1] = val;
                }
                break;
        }

    }

    private static class EmptyInputArray extends RuntimeException
    {
        public EmptyInputArray(String st)
        {
            super(st);
        }
    }
}