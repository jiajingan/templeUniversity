# Implement InsertionSort, MergeSort, QuickSort(Lomuto), QuickSort(Hoare), and CountingSort
import math
import random
import sys
import time

def insertionSort(A):
    for i in range(1, len(A)): 
        # select key 
        key = A[i] 
        j = i-1
        while j >=0 and key < A[j] : 
            # Compare key
                # insert new element
                A[j+1] = A[j] 
                j -= 1
        # swap to get new key
        A[j+1] = key
# Time Complexity = O(n^2) because of two loops (for loop and while loop)
# Space Complexity = O(1) nothing was stored in memory

def merge(A, p, q, r):
    L = A[p:q+1]
    R = A[q+1:r+1]
    i = 0
    j = 0
    k = p
    while i < len(L) and j < len(R):
        if(L[i] < R[j]): #sort left
            A[k] = L[i]
            i += 1
        else:
            A[k] = R[j] #sort right
            j += 1
        k += 1
    if(j == len(R)):
        A[k:r+1] = L[i:]

def mergeSort(A,p,r):
    # p = 0
    # r = len(A)-1
    if(p < r):
        q = math.floor((p+r)/2)#divide the array by half
        mergeSort(A, p, q)#sort sub array left
        mergeSort(A, q+1, r)#sort sub array right
        merge(A, p, q, r) # merge 
    # else:
    #     return A

# Time Complexity = O(nlogn) due to recursion + divide and conquer
# Space Complexity = O(n) b/c divide and conquer, the tree is n*c which yields n

def partitionLomuto(A,p,r):
    pivot = A[r]
    i = p-1
    for j in range (p,r):
        if A[j] <= pivot:#looking for pivot
            i += 1
            A[i], A[j] = A[j], A[i] #swap
    A[i+1], A[r] = A[r], A[i+1] 
    return i+1
def quickSortLomuto(A,p,r):
    if p < r:
        q = partitionLomuto(A,p,r)
        quickSortLomuto(A,p,q-1) #left pivot check
        quickSortLomuto(A,q+1,r) #right pivot check
    else:
        return A
# Time Complexity = O(nlogn) due to recursion + divide and conquer
# Space Complexity = O(logn) It calls the recursion logn times

def partitionHoare(A,p,r):
    pivot = A[p]
    i = p-1
    j = r+1
    while True:
        while True:
            #check left of the pivot
            if A[j] <= pivot:
                break
            j -= 1
        while True:
            #check right of the pivot
            if A[i] >= pivot:
                break
            i += 1
        if i < j:
            #swap i and j
            A[i],A[j] = A[j], A[i]
        else:
            return j
            
def quickSortHoare(A,p,r):
    if p < r:
        q = partitionLomuto(A,p,r)
        quickSortLomuto(A,p,q) # pivot check 
        quickSortLomuto(A,q+1,r) # right pivot check
        
# Time Complexity = O(nlogn) due to recursion + divide and conquer
# Space Complexity = O(logn) It calls the recursion logn times

def countingSort(A):
    #generate a counting array and return sorting array
    counts = [0 for _ in range(max(A) + 1)]
    sortedArr = [0 for _ in range(len(A))]
    
    for element in A:
        #count the array elements
        counts[element] += 1

    for index in range(1, len(counts)):
        #iterate to add the count array index
        counts[index] = counts[index] + counts[index - 1]

    for element in A:
        # use count array to sort 
        counts[element] -= 1
        sortedArr[counts[element]] = element

    return sortedArr
# Time Complexity = O(n+k), n is the amount of elements and k is the range of the element min to max
# Space Complexity = O(k), we need to allocate a sorted list that is determined by k range


def randomNumLists(n):
    #generate random list
    inList = []
    for _ in range(n):
        inList.append(random.randint(0,n))
    return inList

def sortingTime(n):
    #get random list
    a= randomNumLists(n)
    print(f'random list size: {n}')
    #insertion sort
    insertArr = a[:]
    start = time.time()
    insertionSort(insertArr)
    end = time.time()
    print(f'insertion sort time: {end-start}seconds')
    # print(insertArr)
    
    #merge sort
    mergeArr = a[:]
    start = time.time()
    mergeSort(mergeArr,0,len(mergeArr)-1)
    end = time.time()
    print(f'merge sort time: {end-start}seconds')
    # print(mergeArr)
    
    #quickSort Hoare
    hoareArr = a[:]
    start = time.time()
    quickSortHoare(hoareArr,0,len(hoareArr)-1)
    end = time.time()
    print(f'quick-hoare sort time: {end-start}seconds')
    # print(hoareArr)

    #quicksort Lomuto
    lomutoArr = a[:]
    start = time.time()
    quickSortLomuto(lomutoArr,0,len(lomutoArr)-1)
    end = time.time()
    print(f'quick-lomuto sort time: {end-start}seconds')
    # print(lomutoArr)
    
    #counting sort
    countArr = a[:]
    start = time.time()
    c=countingSort(countArr)
    end = time.time()
    print(f'counting sort time: {end-start}seconds')
    # print(c)
    
    # check if the original arr was influenced
    # print(a)
    
listLength = [10,1000,5000,10000,20000]
for i in listLength:
    sortingTime(i)
    print()
    
# run `python3 algo.py > report.txt` to generate report
