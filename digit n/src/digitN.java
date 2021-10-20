import java.util.Scanner;
public class digitN {

    public static void main(String[] args)
    {
        Scanner num = new Scanner(System.in);
        System.out.println("Enter the number");
        System.out.println();

        int n = num.nextInt();

        checkForThree(n);
        reverse(n);
        change(n);
        addOnes(n);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//вспомогательные методы
    public static int numberLenght(int n)
    {
        int count = 0;
        while (n >= 10)
        {
            n = n / 10;
            count++;
        }
        count++;
        return count;
    }

    public static int[] digitsOfNumber(int n )
    {
        int[] digits = new int[numberLenght(n)];

        for (int i = 0; i < digits.length; i++)
        {
            digits[i] = n % 10;
            n = n / 10;
        }
        return digits;
    }

    public static int stright( int n )
    {
        int strightNumber = 0;
        for(int i = digitsOfNumber(n).length - 1; i >= 0; i--)
        {
            strightNumber += digitsOfNumber(n)[i];
            if(i > 0) strightNumber = strightNumber * 10;
        }
        return strightNumber;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Задание 1
    public static void checkForThree (int n)
    {
     int kvadrat = n * n;
     for(int i = 0; i < digitsOfNumber(kvadrat).length; i++ )
     {
         if (digitsOfNumber(kvadrat)[i] == 3) System.out.println("3 presents");
         break;
     }
     System.out.println("3 is abscent");
    }


    // Задание 2
    public static void reverse( int n )
    {

        int reverseNumber = 0;

        for(int i = 0; i < digitsOfNumber(n).length; i++)
        {
            reverseNumber += digitsOfNumber(n)[i];
           if(i < digitsOfNumber(n).length - 1) reverseNumber = reverseNumber * 10;
        }
        System.out.println(reverseNumber);
    }

    // Задание 3
    public static void change(int n)
    {

        int stor =digitsOfNumber(stright(n))[0] ;
        int [] digitsOfChangedNumber = new int[digitsOfNumber(stright(n)).length];
        digitsOfChangedNumber = digitsOfNumber(stright(n));
        int changedNumber = 0;

        digitsOfChangedNumber[0] = digitsOfChangedNumber[digitsOfChangedNumber.length - 1];
        digitsOfChangedNumber[digitsOfChangedNumber.length - 1] = stor;

        for(int i = digitsOfNumber(n).length - 1; i >= 0; i--)
        {
            changedNumber += digitsOfChangedNumber[i];
            if(i > 0) changedNumber = changedNumber * 10;
        }
        System.out.println(changedNumber);
    }


    // Задание 1
    public static void addOnes (int n)
    {
        int added = 1;

        for(int i = 0; i < numberLenght(n); i++)
        {
            added*= 10;
        }

        added += stright(n);
        added *=10;
        added += 1;
        System.out.println(added);
    }


}
