package org.example;

import java.util.ArrayList;
import java.util.List;

class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination,
                           int[] candidates, int remainingTarget, int startIndex) {
        // Base case: if remaining target is 0, we've found a valid combination
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // If remaining target is less than 0, no need to continue
        if (remainingTarget < 0) {
            return;
        }

        // Explore further with each candidate starting from the current index
        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];

            // Add candidate to the current combination
            currentCombination.add(candidate);

            // Recursively explore with the updated remaining target
            backtrack(result, currentCombination, candidates, remainingTarget - candidate, i);

            // Remove the last candidate to explore other possibilities
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum cs = new combinationSum();

        // Example test cases
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(cs.combinationSum(candidates1, target1)); // Output: [[2, 2, 3], [7]]

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(cs.combinationSum(candidates2, target2)); // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(cs.combinationSum(candidates3, target3)); // Output: []
    }
}
