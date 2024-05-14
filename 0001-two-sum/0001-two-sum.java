class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> indicesByValue = groupIndicesByValue(nums);

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (indicesByValue.containsKey(x)) {

                List<Integer> list = indicesByValue.get(x);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) != i) {
                        result[0] = i;
                        result[1] = list.get(j);
                        return result;
                    }
                }
                
            }
        }

        return result;
    }
    
    private Map<Integer, List<Integer>> groupIndicesByValue(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0, nums.length)
            .forEach(idx -> {
                if (map.containsKey(nums[idx])) {
                    map.get(nums[idx]).add(idx);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(idx);
                    map.put(nums[idx], list);
                }
            });
        return map;
    }
}