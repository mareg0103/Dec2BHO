package at.mareg.numberconversion;

import java.util.Scanner;

public class Dec2BHO
{
  final static int BINARY = 2;
  final static int OCTAL = 8;
  final static int HEXADECIMAL = 16;

  public static void main (final String [] args)
  {
    String inStrChoice = "";
    String inStr;

    // Get new Choice to which format to convert a decimal number
    final Scanner in = new Scanner (System.in);
    System.out.println ("Please choose the number type to which you want to convert the decimal number:\n");
    System.out.println ("1. Binary");
    System.out.println ("2. Hexadecimal");
    System.out.println ("3. Octal");
    System.out.println ();
    System.out.println ("any other input quits the program");
    inStrChoice = in.nextLine ();

    // Check if the choice is an integer and if its value is from 1 to 3...
    final int checkChoice = _getAsInt (inStrChoice, 0);

    if (checkChoice <= 0 || checkChoice > 3)
    {
      // If choice not from 1 to 3, quit program
      System.out.println ("Program terminated. Have a nice Day!");
    }
    else
    {
      System.out.println ("Please the decimal number (as Integer) you want to convert:");
      inStr = in.nextLine ().toLowerCase ();

      // Check if input is an integer
      final int inInt = _getAsInt (inStr, -1);
      if (inInt >= 0)
      {
        String outStr = "";
        String numBase = "";

        if (inStrChoice.equals ("1"))
        {
          // Start the binary conversion
          outStr = calcValue (inStr, BINARY);
          numBase = "binary";
        }
        else
          if (inStrChoice.equals ("2"))
          {
            // Start the hex conversion
            outStr = calcValue (inStr, HEXADECIMAL);
            numBase = "hexadecimal";
          }
          else
            if (inStrChoice.equals ("3"))
            {
              // Start the octal conversion
              outStr = calcValue (inStr, OCTAL);
              numBase = "octal";
            }
        System.out.println ("The equivalent " +
                            numBase +
                            " number to decimal " +
                            inStr +
                            " is " +
                            outStr.toUpperCase ());
      }

      else
      {
        // If the inputed number is not an integer, quit program
        System.out.println (inStr + " is not an Integer Value. Program terminated...");
      }
    }

    in.close ();
  }

  private static String calcValue (final String val, final int BASE)
  {
    // If the delivered value is 0, return value
    if (val.equals ("0"))
    {
      return val;
    }

    final StringBuilder builder = new StringBuilder ();
    int num = Integer.parseInt (val);
    int remainder = 0;

    while (num > 0)
    {
      remainder = num % BASE;
      if (BASE == HEXADECIMAL)
      {
        String letter;
        switch (remainder)
        {
          case 10:
            letter = "a";
            break;
          case 11:
            letter = "b";
            break;
          case 12:
            letter = "c";
            break;
          case 13:
            letter = "d";
            break;
          case 14:
            letter = "e";
            break;
          case 15:
            letter = "f";
            break;
          default:
            letter = Integer.toString (remainder);
            break;
        }
        builder.insert (0, letter);
      }
      else
      {
        builder.insert (0, remainder);
      }
      num = num / BASE;
    }

    return builder.toString ();
  }

  private static int _getAsInt (final String sCheck, final int nDefault)
  {
    if (sCheck != null)
      try
      {
        return Integer.parseInt (sCheck);
      }
      catch (final NumberFormatException ex)
      {
        // fall through
      }
    return nDefault;
  }
}
