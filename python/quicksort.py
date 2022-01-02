def quicksort(arr):
    qc(arr, 0, len(arr)-1)
    
def qc(arr, l, r):
    if l >= r:
        return
    p = partition(arr, l, r)
    qc(arr, l, p-1)
    qc(arr, p+1, r)
    
def partition(arr, l, r):
    pivot = arr[r]
    i = l - 1
    for j in range(l, r):
        if arr[j] < pivot:
            i+=1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i+1], arr[r] = arr[r], arr[i+1] 
    return i+1
    

a1 = [3, 2, 1]
quicksort(a1)
print(a1)
assert a1 == [1, 2, 3]