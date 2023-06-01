public class LC12_IntegerToRoman {

    public static void main(String[] args) {
        int num = 3;
        LC12_IntegerToRoman m = new LC12_IntegerToRoman();
        String result = m.intToRoman(num);
        System.out.print(result);
    }

    public String intToRoman(int num) { // 9 5 4 1
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
