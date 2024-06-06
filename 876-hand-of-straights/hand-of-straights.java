class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        for (int card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }
        
        for (int card : cardCounts.keySet()) {
            if (cardCounts.get(card) > 0) {
                for (int i = 1; i < groupSize; i++) {
                    if (cardCounts.getOrDefault(card + i, 0) < cardCounts.get(card)) {
                        return false;
                    }
                    cardCounts.put(card + i, cardCounts.get(card + i) - cardCounts.get(card));
                }
            }
        }
        
        return true;    
    }
}