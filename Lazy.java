/**
 *
 * @author Iraku Harry, College of Computing and Information Sciences, Makerere University
 */
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Random;
import java.util.Timer;

public class Lazy {
    
    
    public Object[] createArray(Object ... obj)
    {
        //This method creates an Object array of elements from the variable argument which can be of any
        //object data type
        //You must cast the elements to the required data type in order to use them.
        Object[] x = new Object[obj.length];
        int j = 0;
        for(Object i: obj)
        {
            x[j] = i;
            j++;
        }
        return x;
    }
    
    public int factorsCount(int num)
    {
        int count = 0;
        for(int i = 1; i <= num; i++)
        {
            if(num%i == 0) count++;
        }
        return count;
    }
    
    public int[] factorsArray(int num)
    {
        int[] x = new int[factorsCount(num)+1];
        for(int i = 1; i <= num; i++)
        {
            if(num%i == 0) x[i-1] = i;
        }
        return x;
    }
    
    public boolean isPrime(int num)
    {
        int count = 2, factors = 0;
        while((count>1)&&(count<num))
        {
            if(num==2) return true;
            else if(num%count==0) return false;
            else count++;
        }
        return true;
    }
    
    public boolean isMultiple(int divisor, int quotient)
    {
        boolean output = false;
        if(divisor%quotient == 0) output = true;
        return output;
    }
    
    public int parseString(String s)
    {
        //This method interpretes a quadratic equation a user inputs as text String
        //This method is still full of bugs
        String num = new String();
        String regex1 = "(\\d+)([x][\\^][3])";
        Pattern p = Pattern.compile(regex1, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        try
        {
            if(m.find())
            {
                System.out.println(m.group(1));
                num = m.group(2);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return Integer.parseInt(num);
    }
    
    public void pause(int seconds) throws InterruptedException
    {
        Thread.sleep(seconds * 1000);
    }
    
    public void prints(Object obj)
    {
        System.out.println(obj);
    }
    
    public int random(int lower_limit, int upper_limit)
    {
        Random rand = new Random();
        int output = lower_limit + rand.nextInt(upper_limit);
        return output;
    }
    
    public String readFile(String source) throws Exception
    {
        
        String output = null;
        if(source.equals("cons"))
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            output = in.readLine();
            prints(output);
            in.close();
        }
        else
        {
            BufferedReader in = new BufferedReader(new FileReader(source));
            while((output = in.readLine()) != null)
            {
                prints(output);
            }
            in.close();
        }
        return output;
    }
    
    public void sort(int[] array)
    {
        for(int i = 0; i<array.length-1; i++)
        {
            for(int j = 0; j<array.length-1; j++)
            {
                if(array[j] > array[j+1])
                {
                    swapElements(array, j, j+1);
                }
            }
        }
    }
    
    public void sorted(Integer[] numObj)
    {
        for(int i = 0; i<numObj.length-1; i++)
        {
            for(int j = 0; j<numObj.length-1; j++)
            {
                if(Integer.compare(numObj[j].intValue(), numObj[j+1]) == 1)
                {
                    swapElements(numObj, j, j+1);
                }
            }
        }
    }
    
    public void sortex(Object[] obj)
    {
        //erroneous method
        if(obj.getClass().equals(new Character[0]))
        {
            for(int i = 0; i<obj.length-1; i++)
            {
                for(int j = 0; j<obj.length-1; j++)
                {
                    if((char)obj[j] > (char)obj[j+1])
                    {
                        char temp = (char)obj[j];
                        obj[j] = obj[j+1];
                        obj[j+1] = temp;
                    }
                }
            }
        }
    }
    
    public String superscript(int date)
    {
        String s;
        switch(date)
        {
            case 1:
                s = "st";
                break;
            case 2:
                s = "nd";
                break;
            case 3:
                s = "rd";
                break;
            default:
                s = "th";
        }
        return s;
    }
    
    public void swapElements(Integer[] array, int i, int j)
    {
        int temp = array[i].intValue();
        array[i] = array[j];
        array[j] = Integer.valueOf(temp);
    }
    
    public void swapElements(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void swap(IntWrapper a, IntWrapper b)
    {
        IntWrapper temp = new IntWrapper(a.x);
        a.x = b.x;
        b.x = temp.x;
    }
    
    
    
    public void unicode()
    {
        for(int i=65; i<123; i++)
        {
            System.out.print(i + " is " + (char)i + ", ");
            if(isMultiple(i,10)) prints("\n");
        }
    }
    
    public Integer[] wrapArray(int[] array)
    {
        Integer[] obj = new Integer[array.length];
        for(int i=0; i<array.length; i++)
        {
            obj[i] = Integer.valueOf(array[i]);
        }
        return obj;
    }
    
    static class IntWrapper
    {
        public int x;
        public IntWrapper(int x)
        {
            this.x = x;
        }
    }
}
