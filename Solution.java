package ReverseInt;

class Solution
{
    /*
    {
        int i = 534236469;
        System.out.println("i:  " + i);
        System.out.println("i*10:  " + i * 10);
    }
    */
    public int reverse(int x)
    {
        if (x > (Math.pow(2, 32) - 1) / 10 || x < -(Math.pow(2, 32) - 1) / 10)
        {
            return 0;
        }

        boolean isPositive = true;
        if (x >= 0)
        {
            isPositive = true;
        } else
        {
            isPositive = false;
        }


        int absRes = absReverse(Math.abs(x), depthOfInt(x));

        if (isPositive)
        {
            return absRes;
        } else
        {
            return -absRes;
        }
    }

    public int absReverse(int srcInt, int depth)
    {

        int quotient, remainder = 0;

        if (depth >= 1)
        {
            quotient = srcInt / (int) Math.pow(10, depth);
            remainder = srcInt - quotient * (int) Math.pow(10, depth);

            //System.out.println("head: " + quotient + "  rest: " + remainder);
            int upDepth = depthOfInt(remainder);
            int upRemainder = absReverse(remainder, upDepth) * (int) Math.pow(10, depth - upDepth);
            return upRemainder + quotient;
        } else
        {
            return srcInt;
        }
    }

    public int depthOfInt(int x)
    {
        String strOfx = String.valueOf(Math.abs(x));
        int digiLen = strOfx.length() - 1;
        return digiLen;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int ori = 1534236469;
        int res = s.reverse(ori);
        System.out.println("Res: " + res);
    }

}
