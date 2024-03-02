class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>keyToAnagrams= new HashMap<>();
        for(String str: strs){
            char[]chars=str.toCharArray();
            Arrays.sort(chars);
            String sortedStr=String.valueOf(chars);
            keyToAnagrams.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(keyToAnagrams.values());
        }
    }
