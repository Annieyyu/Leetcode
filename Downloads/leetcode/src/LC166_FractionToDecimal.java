import java.util.HashMap;

public class LC166_FractionToDecimal {

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        LC166_FractionToDecimal m = new LC166_FractionToDecimal();
        String result = m.fractionToDecimal(num1,num2);
        System.out.print(result);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        // corner case
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sb.append("-");
        }
        long dividend = Math.abs((long)numerator);
        long divisor = Math.abs((long)denominator);

        sb.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) return sb.toString();

        // remainder != 0
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return sb.toString();
    }
}
