/**
 * Created by zhao on 2018/9/1.
 */
public class Exercise {
    public double Power(double base, int exponent) {
        double result=1;
        if(exponent<0)
        {
            while(exponent<0)
            {
                result=base*result;
                exponent++;
            }
            return 1/result;
        }
        else if(exponent==0)
        {
            return 1;
        }
        else
        {
            while(exponent>0)
            {
                result=base*result;
                exponent--;
            }
            return result;
        }

    }
    public static void main(String[] args)
    {

    }
}
