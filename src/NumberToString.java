import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        String[][] nameOfNumber = {
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"},
                {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
                {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"},
                {"hundred"}};
        int number;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter number 0 to 999: ");
            number = sc.nextInt();
        }while(1000 <= number || number <= 0);

        if (number < 10) {
            System.out.println("Number: " +number+" is " + nameOfNumber[0][number]);
        } else if (number < 20) {
            System.out.println("Number: " +number+" is " +nameOfNumber[1][number -10]);
        } else if (number < 100) {
            int tens = number/10-2;
            String nameTens = nameOfNumber[2][tens];
            if(number % 10 == 0) {
                System.out.println("Number: "+number+" is "+nameTens);
            } else {
                System.out.println("Number: "+number+" is "+nameTens+"-"+nameOfNumber[0][number%10]);
            }
        }else {
            int hundred = number / 100;
            int tenOfDigit = number % 100;
            int rowOfDigit = tenOfDigit % 10;
            if(tenOfDigit < 10) {
                if (rowOfDigit != 0){
                    System.out.println("Number: "+number+" is "+nameOfNumber[0][hundred]+" hundred and "+nameOfNumber[0][rowOfDigit]);
                }else {
                    System.out.println("Number: "+number+" is "+nameOfNumber[0][hundred]+" hundred ");
                }
            } else if(tenOfDigit<20){
                System.out.println("Number: " +number+" is "+nameOfNumber[0][hundred]+" hundred " + nameOfNumber[1][tenOfDigit-10]);
            } else {
                tenOfDigit = tenOfDigit/10;
                String nameTenOfDigits = nameOfNumber[2][tenOfDigit-2];
                if(rowOfDigit !=0){
                    System.out.println("Number : " + number + " is " + nameOfNumber[0][hundred] + " hundred " + nameTenOfDigits + "-" + nameOfNumber[0][rowOfDigit]);
                }else{
                    System.out.println("Number : " + number + " is " + nameOfNumber[0][hundred] + " hundred " + nameTenOfDigits);
                }
            }
        }
    }
}
