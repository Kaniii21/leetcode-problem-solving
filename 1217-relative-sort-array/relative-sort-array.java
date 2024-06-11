class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
     Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            indexMap.put(arr2[i], i);
        } 
        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Integer, (a, b) -> {
            if (indexMap.containsKey(a) || indexMap.containsKey(b)) {
                return indexMap.getOrDefault(a, arr2.length) - indexMap.getOrDefault(b, arr2.length);
            }
            return a - b;
        });
        
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1Integer[i];
        }  
        return arr1;   
    }
}