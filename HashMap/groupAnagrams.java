class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> result = new ArrayList<>();
    if (strs.length == 0) {
      return result;
    }

    HashMap<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      String curr = strs[i];
      char[] charArray = curr.toCharArray();
      Arrays.sort(charArray);
      String sortedCurr = String.valueOf(charArray);

      if (!map.containsKey(sortedCurr)) {
        List<String> buffer = new ArrayList<>();
        buffer.add(curr);
        map.put(sortedCurr, buffer);
      } else {
        map.get(sortedCurr).add(curr);
      }
    }

    for (List<String> elem : map.values()) {
      result.add(elem);
    }

    return result;
  }
}