package algorithms;

/**
 * Created by Paritosh Dave on 10/29/2015.
 *
 *  This is stateless utility class, thus object of this class should never be created
 */
public final class MergeSort {

    static int[] inputArr ;

    private MergeSort()
    {
        // do nothing
    }

    public static int[] sort(int[] arr)
    {
        inputArr = arr;
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
                applyMergeSort(0, inputArr.length - 1);
                break;
        }
        return inputArr;
    }

    private static void applyMergeSort(int first_index, int last_index)
    {
        if(last_index> first_index)
        {
            int split_index = (first_index+last_index)/2;

            applyMergeSort(first_index, split_index);
            applyMergeSort(split_index+1, last_index);

            merge(first_index, split_index, last_index);
        }
    }

    private static void merge(int first_index, int split_index, int last_index)
    {
        // create temp array to hold the value from indexes that are getting sort
        int[] arr1 = new int[split_index-first_index+1];
        int[] arr2 = new int[last_index-split_index];

        for(int i = 0; i< arr1.length; ++i)
        {
            arr1[i] = inputArr[first_index+i];
        }
        for(int i = 0; i< arr2.length; ++i)
        {
            arr2[i] = inputArr[split_index+1+i];
        }

        // use temp arrays to sort original array
        int index1 = 0;
        int index2 = 0;
        int counter = first_index;
        while(index1+index2 < arr1.length+arr2.length)
        {
            if(index1 < arr1.length && index2 < arr2.length)
            {
                if(arr1[index1] < arr2[index2])
                {
                    inputArr[counter++] = arr1[index1];
                    ++index1;
                }
                else
                {
                    inputArr[counter++] = arr2[index2];
                    ++index2;
                }
            }
            else if(index1 == arr1.length)
            {
                for(int i = index2; i< arr2.length; ++i)
                {
                    inputArr[counter++] = arr2[i];
                }
                break;
            }
            else
            {
                for(int i = index1; i< arr1.length; ++i)
                {
                    inputArr[counter++] = arr1[i];
                }
                break;
            }

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
