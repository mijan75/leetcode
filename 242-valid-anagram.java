public boolean isAnagram(String s, String t) {
	if (s.length() != t.length()) return false;

	Map<Character, Integer> sourceMap = new HashMap<>();
	Map<Character, Integer> destiantionMap = new HashMap<>();

	for (char c : s.toCharArray()) {
		sourceMap.put(c, sourceMap.getOrDefault(c, 0) + 1);
	}

	for (char c : t.toCharArray()) {
		destiantionMap.put(c, destiantionMap.getOrDefault(c, 0) + 1);
	}

	for (Map.Entry<Character, Integer> entry : sourceMap.entrySet()) {
		Character key = entry.getKey();

		if (sourceMap.get(key).equals(destiantionMap.get(key)))
			continue;
		return false;
	}
	return true;
}

// Better Solution

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}