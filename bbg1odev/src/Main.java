public class Main {

    public static void main(String[] args) {
        String veri = "XII";
        //System.out.println(isInteger(veri));
        if (isInteger(veri)) {
            System.out.println(IntegerToRomanNumber(Integer.parseInt(veri)));
        }else
            romanToDecimal(veri);
    }

    static boolean isInteger(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }

    public static String IntegerToRomanNumber(int Sayi) {
        if (Sayi < 1 || Sayi > 3999)
            return "Girdiginiz sayi 1-3999 arasinda olmali.";
        String s = "";
        while (Sayi >= 1000) {
            s += "M";
            Sayi -= 1000;        }
        while (Sayi >= 900) {
            s += "CM";
            Sayi -= 900;
        }
        while (Sayi >= 500) {
            s += "D";
            Sayi -= 500;
        }
        while (Sayi >= 400) {
            s += "CD";
            Sayi -= 400;
        }
        while (Sayi >= 100) {
            s += "C";
            Sayi -= 100;
        }
        while (Sayi >= 90) {
            s += "XC";
            Sayi -= 90;
        }
        while (Sayi >= 50) {
            s += "L";
            Sayi -= 50;
        }
        while (Sayi >= 40) {
            s += "XL";
            Sayi -= 40;
        }
        while (Sayi >= 10) {
            s += "X";
            Sayi -= 10;
        }
        while (Sayi >= 9) {
            s += "IX";
            Sayi -= 9;
        }
        while (Sayi >= 5) {
            s += "V";
            Sayi -= 5;
        }
        while (Sayi >= 4) {
            s += "IV";
            Sayi -= 4;
        }
        while (Sayi >= 1) {
            s += "I";
            Sayi -= 1;
        }
        return s;
    }

    public static void romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        System.out.println(decimal);
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }


}