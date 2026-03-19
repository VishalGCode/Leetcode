typedef struct {
    int *p;
} NumArray;


NumArray* numArrayCreate(int* nums, int numsSize) {
    NumArray* numArr = malloc(sizeof(NumArray));
    numArr->p = malloc(sizeof(int) * numsSize);
    for (int i = 0; i < numsSize; i++) {
        numArr->p[i] = nums[i];
    }

    return numArr;
}

int numArraySumRange(NumArray* obj, int left, int right) {
    int sum = 0;

    for(int i = left; i <= right; i++){
        sum += obj->p[i];
    }

    return sum;
}

void numArrayFree(NumArray* obj) {
    free(obj->p);
    free(obj);
}

/**
 * Your NumArray struct will be instantiated and called as such:
 * NumArray* obj = numArrayCreate(nums, numsSize);
 * int param_1 = numArraySumRange(obj, left, right);
 
 * numArrayFree(obj);
*/