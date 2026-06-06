class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        backtrack(nums, new ArrayList<>());
        return ans;
    }
    private void backtrack(int[] nums, List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int num : nums){
            if(curr.contains(num))
            continue;
            curr.add(num);
            backtrack(nums, curr);
            curr.remove(curr.size() - 1);
        }
    }
}