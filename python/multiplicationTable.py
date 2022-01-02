def multiplicationTable(arr):
    if len(arr) == 0:
        return arr
    else:
        result = []
        for i in range(len(arr)):
            for j in range(len(arr)):
                result.append(arr[i]*arr[j])
        return result
                

print (multiplicationTable([10, 5, 2, 3]))        