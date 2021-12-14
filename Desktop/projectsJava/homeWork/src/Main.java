import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main{


    public static boolean isPrime(int x){
        for(int i = 2; i < x; i++){
            if(x % i == 0){
               return false; 
            }
        }
        return true;
    }
    public static boolean isPalindrom(String x){
        for(int i = 0; i < x.length() / 2; i++){
            if(x.charAt(i) != x.charAt(x.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static int minimizeNumber(int x){
        int minimized = 0, last = x % 10;
        while(x > 9){
            x /= 10;
        }
        minimized += x;
        minimized *= 10;
        minimized += last;
        return minimized;
    }
    public static double big(double a, double b){

        if(a > b)
            return a;
        return b;
    }        
    public static void sumOf9() {
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(i + j == 9){
                    System.out.println(i + ":i." + j + ":j");
                }
            }
        }
    }
    public static void compareTwoStrings(String a, String b){
        System.out.println(a.compareToIgnoreCase(b));
    }
    
    public static boolean isInIt(String str, char c){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){
                return true;
            }
        }
        return false;
    }
    public static StringBuilder encrypt(String str){
        StringBuilder newStr = new StringBuilder(str);
        for(int i = 0; i < newStr.length(); i++){
            switch(newStr.charAt(i)){
                case 'a':
                newStr.setCharAt(i, '*');
                break;
                case 'u':
                newStr.setCharAt(i, '%');
                break;
                case 'e':
                newStr.setCharAt(i, '#');
                break;
                case 'i':
                newStr.setCharAt(i, '&');
                break;
                case 'o':
                newStr.setCharAt(i, '$');
                break;
                default: 
                break;
            }
        }
        return newStr;
    }
    public static String encryptString(String str){
        char[] strArr = new char[str.length()];
        for(int i = 0; i < str.length();i++){
            strArr[i] = str.charAt(i);
            switch(strArr[i]){
                case 'a':
                strArr[i] = '*';
                break;
                case 'u':
                strArr[i] = '%';
                break;
                case 'e':
                strArr[i] = '#';
                break;
                case 'i':
                strArr[i] = '&';
                break;
                case 'o':
                strArr[i] = '$';
                break;
                default: 
                break;
            }
        }
        String newStr = new String(strArr);
        return newStr;
    }
    public static String encryptSubstring(String str){
        for(int i = 0; i < str.length();i++){
            switch(str.charAt(i)){
                case 'a':
                str = str.substring(0, i) + '*' + str.substring( i + 1);
                break;
                case 'u':
                str = str.substring(0, i) + '%' + str.substring( i + 1);

                break;
                case 'e':
                str = str.substring(0, i) + '#' + str.substring( i + 1);

                break;
                case 'i':
                str = str.substring(0, i) + '&' + str.substring( i + 1);

                break;
                case 'o':
                str = str.substring(0, i) + '$' + str.substring( i + 1);

                break;
                default: 
                break;
            }
        }
        
        return str;
        
    }
    public static String decryptSubstring(String str){
        for(int i = 0; i < str.length();i++){
            switch(str.charAt(i)){
                case '*':
                str = str.substring(0, i) + 'a' + str.substring( i + 1);
                break;
                case '%':
                str = str.substring(0, i) + 'u' + str.substring( i + 1);

                break;
                case '#':
                str = str.substring(0, i) + 'e' + str.substring( i + 1);

                break;
                case '&':
                str = str.substring(0, i) + 'i' + str.substring( i + 1);

                break;
                case '$':
                str = str.substring(0, i) + 'o' + str.substring( i + 1);

                break;
                default: 
                break;
            }
        }
        
        return str;
    }

    public static int[] combineIntArr(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int bCounter = 0;
        System.out.println(c.length);
        for(int i = 0; i < c.length ;i++){
            if(i < a.length){
                c[i] = a[i];
            } else {
                c[i] = b[bCounter++];
            }
        }
        return c;
    }

    public static double biggestDouble(double[] data){
        double biggest = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] > biggest){
                biggest = data[i];
            }
        }
        return biggest;
    }

    public static double maxBig(double[][] data){
        double biggest = 0;
        for(int i = 0; i < data.length; i++){
            if (biggestDouble(data[i]) > biggest){
                biggest = biggestDouble(data[i]);
            }
        }
        return biggest;
    }
    public static void main(String[] args) {

        int[] numbers = {1,2,3,3,3,4};
        int[] newNUmbers = new int[numbers.length];
        int j = 0;
        newNUmbers[0] = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] != numbers[j]){
                j++;
                newNUmbers[j] = numbers[i];
            }
        }
        for(int i = 0; i < newNUmbers.length; i++){
            System.out.println(newNUmbers[i]);
        }


        double[][] data = {{3,5,120,7},{12,5,48,21},{54,51,56,4}};
        System.out.println(maxBig(data));
        

    }
}