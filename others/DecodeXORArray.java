package bitwiseoperation;

public class DecodeXORArray {
    public static void main(String[] args) {
        int[] output = decode(new int[]{1,2,3}, 1);
        for (int n: output) {
            System.out.println(n);
        }

    }

    public static int[] decode(int[] encoded, int first) {
        int[] output = new int[encoded.length+1];
        output[0] = first;
        for (int i=1; i <= encoded.length; i++) {
            output[i] = encoded[i-1] ^ output[i-1];
        }

        return output;

    }
}
