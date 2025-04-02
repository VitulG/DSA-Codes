import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies {


    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        // step 1. create adjacency list and in_degree of the recipe
        int n = recipes.length;

        Set<String> availableSupplies = new HashSet<>(Arrays.asList(supplies));
        int[] in_degree = new int[n];

        Map<String, List<Integer>> adjList = new HashMap<>();

        for(int i=0; i<n; i++) { // I will check every recipe
            for(String ingredient : ingredients.get(i)) {  // and their ingredients
                if(!availableSupplies.contains(ingredient)) { // if it is not present then it has the dependency to create that ingredient first
                    in_degree[i]++; // increase the in_degree of that dependent recipe
                    adjList.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(i); // it means after creating that ingredient I will move to that dependent recipe from the ingredient -> i where the dependent recipe present
                }
            }
        }

        // step 2. we can proceed with those recipe which we can make independently put inside the queue
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            if(in_degree[i] == 0) {
                queue.offer(i);
            }
        }

        // step 3. using kahn's algo we can find which recipe we can make
        List<String> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(recipes[curr]);

            if (!adjList.containsKey(recipes[curr])) continue;

            for(int nextRecipe : adjList.get(recipes[curr])) {
                in_degree[nextRecipe]--;
                if(in_degree[nextRecipe] == 0) {
                    queue.offer(nextRecipe);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> firstIngredients = List.of("yeast","flour");
        List<String> secondIngredients = List.of("bread","meat");
        List<String> thirdIngredients = List.of("sandwich","meat","bread");
        List<List<String>> ingredients = List.of(firstIngredients, secondIngredients, thirdIngredients);

        System.out.println(findAllRecipes(new String[]{"bread","sandwich","burger"},
                ingredients,
                new String[]{"yeast","flour","meat"}));
    }
}
