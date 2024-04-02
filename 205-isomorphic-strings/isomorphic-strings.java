class Solution {
    public boolean isIsomorphic(String s, String t) {
    int lastSeenPositionS []=new int[256];
    int lastSeenPositionT []=new int[256];   
    for(int i=0;i<s.length();i++){
      char charInS =s.charAt(i);
      char charInT= t.charAt(i);
      if(lastSeenPositionS[charInS]!=lastSeenPositionT[charInT]){
        return false;
      }
      lastSeenPositionS[charInS]=i+1;
      lastSeenPositionT[charInT]=i+1;
    }
      return true;
    }
}