#include <stdlib.h>

struct DisJointSet* DisJointSet(int);
int disjointset_find(struct DisJointSet*, int);
void disjointset_unite(struct DisJointSet*, int, int);
void disjointset_free(struct DisJointSet*);

struct DisJointSet {
    int* roots;
    int* ranks;
    int (*find)(struct DisJointSet* self, int x);
    void (*unite)(struct DisJointSet* self, int x, int y);
    void (*free)(struct DisJointSet* self);
};

struct DisJointSet* DisJointSet(int n) {
    struct DisJointSet* disjointset = (struct DisJointSet*)malloc(sizeof(struct DisJointSet));
    int* roots = (int*)malloc(sizeof(int) * n);
    int* ranks = (int*)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++) {
        roots[i] = i;
        ranks[i] = 0;
    }
    disjointset -> roots = roots;
    disjointset -> ranks = ranks;
    disjointset -> find = disjointset_find;
    disjointset -> unite = disjointset_unite;
    disjointset -> free = disjointset_free;
    return disjointset;
}

int disjointset_find(struct DisJointSet* self, int x) {
    if (self -> roots[x] == x) {
        return x;
    }
    self -> roots[x] = disjointset_find(self, self -> roots[x]);
    return self -> roots[x];
}

void disjointset_unite(struct DisJointSet* self, int x, int y) {
    int rootX = self -> find(self, x);
    int rootY = self -> find(self, y);
    if (rootX != rootY) {
        if (self -> ranks[rootX] > self -> ranks[rootY]) {
            self -> roots[rootY] = rootX;
        } else if (self -> ranks[rootX] < self -> ranks[rootY]) {
            self -> roots[rootX] = rootY;
        } else {
            self -> roots[rootY] = rootX;
            self -> ranks[rootX] += 1;
        }
    }
}

void disjointset_free(struct DisJointSet* self) {
    free(self -> roots);
    free(self -> ranks);
    free(self);
}

int Distance(int* a, int* b) {
    return abs(a[0] - b[0]) + abs(a[1] - b[1]);
}

void merge(size_t left, size_t mid, size_t right, int** array, int** sortedArray) {
    
    size_t i = left;
    size_t j = mid;
    for (size_t k = left; k < right; k++) {
        if ((i < mid) && (j < right)) {
            if (array[i][0] < array[j][0]) {
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
    
    for (size_t k = left; k < right; k++) {
        array[k] = sortedArray[k];
    }
}

void mergeSort(size_t left, size_t right, int** array, int** sortedArray) {

    if (left == (right - 1)) {
        return;
    }
    size_t mid = (left + right) / 2;
    mergeSort(left, mid, array, sortedArray);
    mergeSort(mid, right, array, sortedArray);
    merge(left, mid, right, array, sortedArray);
}

int minCostConnectPoints(int** points, int pointsSize, int* pointsColSize) {

    if (pointsSize <= 1) {
        return 0;
    }
    size_t max_combinations = 499500;
    int** edges = (int**)malloc(sizeof(int*) * max_combinations);
    size_t k = 0;
    for (int i = 0; i < pointsSize; i++) {
        for (int j = i + 1; j < pointsSize; j++) {
            edges[k] = (int*)malloc(sizeof(int) * 3);
            edges[k][0] = Distance(points[i], points[j]);
            edges[k][1] = i;
            edges[k][2] = j;
            k += 1;
        }
    }
    size_t combinations = k;
    int** mergeSortBuffer = (int**)malloc(sizeof(int*) * combinations);
    mergeSort(0, combinations, edges, mergeSortBuffer);
    free(mergeSortBuffer);
    struct DisJointSet* disjointset = DisJointSet(pointsSize);

    int count = 0;
    k = 0;
    int sum = 0;
    while (count < pointsSize - 1) {
        if (disjointset -> find(disjointset, edges[k][1]) != disjointset -> find(disjointset, edges[k][2])) {
            disjointset -> unite(disjointset, edges[k][1], edges[k][2]);
            count += 1;
            sum += edges[k][0];
        }
        k += 1;
    }
    for (int i = 0; i < combinations; i++) {
        free(edges[i]);
    }
    free(edges);
    disjointset -> free(disjointset);
    return sum;
}