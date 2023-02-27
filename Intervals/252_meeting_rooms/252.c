#include <stdlib.h>
#include <stdbool.h>


#define min(a,b) (((a) < (b)) ? (a) : (b))

bool cmp_less_than(int* array1, int array1Size, int* array2, int array2Size) {

    int i = 0;
    int min_size = min(array1Size, array2Size);

    while ((i < min_size) && (array1[i] == array2[i])) { i += 1; }
    if (i == min_size) {return false;}
    else if (array1[i] < array2[i]) {return true;}
    else if (array1[i] > array2[i]) {return false;}
    else if (array1Size < array2Size) {return true;}
    return false;

}

void merge(int left, int mid, int right, int** array, int** sortedArray, int* columnSizes) {
    
    int i = left;
    int j = mid;

    for (int k = left; k < right; k++) {
        if ((i < mid) && (j < right)) {
            if (cmp_less_than(array[i], columnSizes[i], array[j], columnSizes[j])) {
                sortedArray[k] = array[i];
                i++;
            } else {
                sortedArray[k] = array[j];
                j++;
            }  
            
        } else if (i < mid) {
            sortedArray[k] = array[i];
            i++;
        } else {
            sortedArray[k] = array[j];
            j++;
        }
    }
    
    for (int k = left; k < right; k++) {
        array[k] = sortedArray[k];
    }
}

void mergeSort(int left, int right, int** array, int** sortedArray, int* columnSizes) {

    if (left == (right - 1)) {
        return;
    }
    int mid = (left + right) / 2;
    mergeSort(left, mid, array, sortedArray, columnSizes);
    mergeSort(mid, right, array, sortedArray, columnSizes);
    merge(left, mid, right, array, sortedArray, columnSizes);
}



bool canAttendMeetings(int** intervals, int intervalsSize, int* intervalsColSize){

    if (intervalsSize == 0) {return true;}

    int** buffer = (int**)malloc(sizeof(int*) * intervalsSize);
    mergeSort(0, intervalsSize, intervals, buffer, intervalsColSize);

    int result = true;
    for (int i = 0; i < intervalsSize - 1; i++) {
        if (intervals[i][1] > intervals[i + 1][0]) {
            result = false;
            break;
        }
    }
    free(buffer);
    return result;
}