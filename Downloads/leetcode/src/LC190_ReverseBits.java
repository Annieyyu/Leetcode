public class LC190_ReverseBits {

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        LC190_ReverseBits m = new LC190_ReverseBits();
        int result = m.reverseBits(n);
        System.out.print(result);
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = (n >> i) & 1;
            res = res | temp << (31 - i);
        }
        return res;
    }
}
