public List<List<String>> groupAnagrams(String[] strs) {
	Map<String, List<String>> map = new HashMap<>();
	List<String> visitedWord = new ArrayList<>();

	for (int i = 0; i < strs.length; i++) {
		String s = strs[i];
		if (!visitedWord.contains(s)) {
			visitedWord.add(s);
			map.put(s, new ArrayList<>());
		} else continue;
		if (i == strs.length - 1) continue;

		for (int j = i + 1; j < strs.length; j++) {
			if (isAnagram(s, strs[j])) {
				map.get(s).add(strs[j]);
				visitedWord.add(strs[j]);
			}
		}
	}
	List<List<String>> result = new ArrayList<>();
	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		String key = entry.getKey();
		List<String> value = entry.getValue();
		value.add(key);
		result.add(value);
	}
	return result;
}

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

// Better Solution

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String,
        ArrayList<String>>();
        for(String str: strs)
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String ns = new String(arr);
            if(map.containsKey(ns))
            {
                map.get(ns).add(str);
            }
            else
            {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }
        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet())
        {
            Collections.sort(entry.getValue());
        }
        result.addAll(map.values());
        return result;

    }
}

