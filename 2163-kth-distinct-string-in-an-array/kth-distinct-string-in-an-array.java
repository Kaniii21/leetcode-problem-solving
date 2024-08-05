class Solution {
    public String kthDistinct(String[] arr, int k) {
    Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        for (String element : arr) {
            
            if (frequencyMap.get(element) == 1) {
                k--; 
                if (k == 0) {
                    return element;
                }
            }
        }
        return "";    
    }
}