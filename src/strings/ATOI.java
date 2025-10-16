package strings;

public class ATOI {

    public int myAtoi(String s) {
        // 1. Remove leading spaces only
        s = s.stripLeading();  // or s.trim()

        if (s.isEmpty()) return 0;

        // 2. Handle sign
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        // 3. Parse digits
        long number = 0; // use long to detect overflow
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            number = number * 10 + digit;

            // clamp to 32-bit int
            if (sign == 1 && number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -number < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            index++;
        }

        return (int)(sign * number);
    }

    //Recursive approach

        public int myAtoi1(String s) {
            int i=0;

            //Remove leading/trailing spaces
            while(i<s.length() && s.charAt(i)==' '){
                i++;
            }
            int sign=1;
            //Calculate sign
            if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
                sign=s.charAt(i)=='+'?1:-1;
                i++;
            }

            //Call the recursive helper function
            return helper(s,i,0,sign);
        }

        public int helper(String s, int i,int num, int sign){

            //If provided index is beyond the string length, return the number
            //Or if the character at the provided index is not a digit, return the number
            if(i>=s.length() || !Character.isDigit(s.charAt(i)))
                return (int)num*sign;

            //Clamp to a 32 bit integer
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && (s.charAt(i)-'0')>7))
                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;

            //Process the next digit | Construct the new number
            num=num*10+(s.charAt(i)-'0');

            //Recurse to the next character
            return helper(s,i+1,num,sign);

        }



    //Running some test cases
    public static void main(String[] args) {
        ATOI obj = new ATOI();
        int result = obj.myAtoi("4193 with words");
        System.out.println("Test 1: " + result + " (Expected: 4193)");
    }

}
