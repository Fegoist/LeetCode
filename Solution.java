package ReverseInt;

class Solution
{
    public int reverse(int x)
    {
        boolean isPositive = true;
        if (x >= 0)
        {
            isPositive = true;
        }
        else
        {
            isPositive = false;
        }


        long absResLong = absReverse(Math.abs(x), depthOfInt(x));
        int absRes = (absResLong > (Math.pow(2, 31) - 1) || absResLong < -(Math.pow(2, 31) - 1)) ? 0 : (int) absResLong;

        if (isPositive)
        {
            return absRes;
        }
        else
        {
            return -absRes;
        }
    }

    public long absReverse(long srcInt, int depth)
    {
        long quotient, remainder = 0;

        if (depth >= 1)
        {
            quotient = srcInt / (long) Math.pow(10, depth);
            remainder = srcInt - quotient * (long) Math.pow(10, depth);
            int upDepth = depthOfInt(remainder);
            long upRemainder = absReverse(remainder, upDepth) * (long) Math.pow(10, depth - upDepth);
            return upRemainder + quotient;
        }
        else
        {
            return srcInt;
        }
    }

    public int depthOfInt(long x)
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
