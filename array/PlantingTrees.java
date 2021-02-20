package array;

import java.util.Arrays;

public class PlantingTrees {
    public static void main(String[] args) {
        System.out.println(numberOfMovements(new int[]{1,1,2,1}));
    }

    public static int numberOfMovements(int[] trees) {
        int avg = (int) Math.ceil(Arrays.stream(trees).average().getAsDouble());
        int totalMoves = 0;

        for (int count: trees) {
            if (count < avg) totalMoves += avg - count;
        }

        return totalMoves;
    }
}
