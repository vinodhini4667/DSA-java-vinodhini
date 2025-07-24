import java.util.*;

class Main {
    public static int[] findNearestTowers(int[] towerHeights) {
        int n = towerHeights.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // initialize with -1

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        // Pass 1: Find nearest smaller tower to the left
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && towerHeights[leftStack.peek()] >= towerHeights[i]) {
                leftStack.pop();
            }
            if (!leftStack.isEmpty()) {
                result[i] = leftStack.peek(); // store index
            }
            leftStack.push(i);
        }

        // Pass 2: Find nearest smaller tower to the right and finalize decision
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && towerHeights[rightStack.peek()] >= towerHeights[i]) {
                rightStack.pop();
            }
            if (!rightStack.isEmpty()) {
                int rightIndex = rightStack.peek();

                if (result[i] != -1) {
                    int leftIndex = result[i];
                    int leftDist = Math.abs(leftIndex - i);
                    int rightDist = Math.abs(rightIndex - i);

                    if (leftDist == rightDist) {
                        // Same distance → choose smaller height
                        if (towerHeights[rightIndex] < towerHeights[leftIndex]) {
                            result[i] = rightIndex;
                        }
                    } else if (rightDist < leftDist) {
                        result[i] = rightIndex;
                    }
                } else {
                    result[i] = rightIndex;
                }
            }
            rightStack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] towerHeights = new int[n];
        for (int i = 0; i < n; i++) {
            towerHeights[i] = sc.nextInt();
        }

        // Processing
        int[] result = findNearestTowers(towerHeights);

        // Output
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
