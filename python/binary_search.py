
class Solution:
    def binary_search(self,arr,target):
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return

    def binary_search2(self ,arr , target):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = (low + high) // 2
            if arr[mid] >= target:
                high = mid
            else:
                low = mid + 1
        if arr[high] == target:
            return high
        return -1       

    def binary_search3(self ,arr , target):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = (low + high) // 2 + 1
            if arr[mid] <= target:
                low = mid
            else:
                high = mid - 1
        if arr[high] == target:
            return high
        return -1   

    def binary_search4(self ,arr , target, flag):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = (low + high) // 2
            if arr[mid] == target:
                if flag == 0:
                    high = mid
                else :
                    low = mid
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        if arr[high] == target:
            return high
        return -1   

if __name__ == "__main__":
    c = Solution()
    # print(c.binary_search([1,2,3,4,5,6],4))

    # print(c.binary_search2([1,3,4,4,5],3))

    # print(c.binary_search3([1,3,3,4,5],3))
    print(c.binary_search4([3,3,3,4,5],3,0))



