package algorithms;

class TestSort
{
    public static void main(String... args)
    {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.ASC);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{10,9};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.ASC);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{10};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.ASC);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{10,9,8,7,6};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.ASC);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{1,6,3,9,12,8,-17};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.ASC);
        System.out.println("Printing is asc order");
        printArr(result);


        arr1 = new int[]{1,2,3,4,5};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.DESC);
        System.out.println("Printing is desc order");
        printArr(result);

        arr1 = new int[]{10,9};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.DESC);
        System.out.println("Printing is desc order");
        printArr(result);

        arr1 = new int[]{10,9,8,7,6};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.DESC);
        System.out.println("Printing is desc order");
        printArr(result);

        arr1 = new int[]{1,6,3,9,12,8,-17};
        result = InsertionSort.sort(arr1, InsertionSort.SORT_TYPE.DESC);
        System.out.println("Printing is desc order");
        printArr(result);

        arr1 = new int[]{1,2,3,4,5};
        result = MergeSort.sort(arr1);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{10,9,23,1};
        result = MergeSort.sort(arr1);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{10};
        result = MergeSort.sort(arr1);
        System.out.println("Printing is asc order");
        printArr(result);


        arr1 = new int[]{4,3,123,45,2,-5,-1,0,4,12,123,8};
        result = MergeSort.sort(arr1);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{1,6,3,9,12,8,-17};
        result = MergeSort.sort(arr1);
        System.out.println("Printing is asc order");
        printArr(result);

        arr1 = new int[]{15,2,4,12,4,3,2,1};
        result = MergeSort.sort(arr1);
        System.out.println("Printing is asc order");
        printArr(result);

    }

    private static void printArr(int[] arr)
    {
        for(int i = 0; i< arr.length; ++i)
        {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
}