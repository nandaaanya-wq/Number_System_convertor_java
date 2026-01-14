
package com.mycompany.aanya_azure_xi;
import java.util.Scanner;
public class Aanya_Azure_XI {
//input validation
//fractional part    
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the original number");
        String n=sc.next();
        System.out.println("Enter number system of the number");
        String s=sc.next();
        s=s.toLowerCase();
        System.out.println("Enter 1 to convert to Binary");
        System.out.println("Enter 2 to convert to decimal");
        System.out.println("Enter 3 to convert to octal");
        System.out.println("Enter 4 to convert to hexadecimal");
        int c=sc.nextInt();
        Aanya_Azure_XI o1=new Aanya_Azure_XI();
        
        switch (c){
            case 1:
                if (!s.equals("binary"))
                    o1.binary(s, n);
                break;
           case 2:
                if (!s.equals("decimal"))
                    o1.decimal(s,n);
                break;
            case 3:
                if (!s.equals("octal"))
                    o1.octal(s,n);
                break;
            case 4:
                if(!s.equals("hexadecimal"))
                    o1.hexadecimal(s,n);
                break;
            default: System.out.println("Invalid input");
                
                    
        }
    }
    //converting one decimal character to corresponding binary
    String to_binary(char s){
        int num=Character.getNumericValue(s);
        String result="";
        while (num>0){
                int rem=num%2;
                result=rem+result;
                num=num/2;
            }
        return result;
    }
    //converting a binary string of digits into correspoinding decimal
    int to_decimal(String n){
        int result=0;
        int power=0;
        for (int i=n.length()-1; i>=0; i--){
            char c=n.charAt(i);
            if (c=='1'){
                int temp=(int)Math.pow(2, power);
                result=result+temp;
            }
          power=power+1;  
        }
        return result;
    }
    void binary (String s, String n){
        String result="";
        //code to convert decimal number into binary
        if (s.equals("decimal")){
            int num=Integer.parseInt(n);
            while (num>0){
                int rem=num%2;
                result=rem+result;
                num=num/2;
            }
            System.out.println(""+result);
        }
        //code to conert octal number to binary 
        if (s.equals("octal")){
            for (int i=0; i<n.length(); i++){
                char c=n.charAt(i);
                String b=to_binary(c);
                //while loop for adding leading zeros to make length of 3
                while (b.length()<3){
                   b="0"+b;
             }
                result=result+b;
                
            }
            System.out.println(""+result);
        }
        //code to convert Hexadecimal number to binary 
        if (s.equals("hexadecimal")){
            for (int i=0; i<n.length(); i++){
                char c=n.charAt(i);
                String b=to_binary(c);
                //while loop for adding leading zeros to make length of 4
                while (b.length()<4){
                   b="0"+b;
             }
                result=result+b;
                
            }
            System.out.println(""+result);
        }
        
    }
    void octal(String s, String n){
       String result="";
       //code to convert decimal number to octal
       if (s.equals("decimal")){
            int num=Integer.parseInt(n);
            while (num>0){
                int rem=num%8;
                result=rem+result;
                num=num/8;
            }
            System.out.println(""+result);
    }
       //code to convert binary number to octal
       if (s.equals("binary")){
           String res="";
           while (n.length()%3!=0){
               //adding leading zeroes to make into groups of 3 
               n='0'+n;
           }
           for (int i=0; i<n.length(); i=i+3){
               String group=n.substring(i, i+3);
               //converting each group of 3 into its octal equivalent 
               int r=to_decimal(group);
               String r1=Integer.toString(r);
               res=res+r1;
           }
           System.out.println(""+res);
       }
       //converting hexadecimal number to octal
       if (s.equals("hexadecimal")){
          //conveting hexadecimal number to binary
          for (int i=0; i<n.length(); i++){
                char c=n.charAt(i);
                String b=to_binary(c);
                //while loop for adding leading zeros to make length of 4
                while (b.length()<4){
                   b="0"+b;
             }
                result=result+b;
                
            }
            n=result;
            String res="";
            //converting binary number to octal 
           while (n.length()%3!=0){
               //adding leading zeroes to make into groups of 3 
               n='0'+n;
           }
           for (int i=0; i<n.length(); i=i+3){
               String group=n.substring(i, i+3);
               //converting each group of 3 into its octal equivalent 
               int r=to_decimal(group);
               String r1=Integer.toString(r);
               res=res+r1;
           }
           System.out.println(""+res);
       }
}
    void hexadecimal(String s, String n){
        String result="";
        //code to convert decicmal to hexadecimal
        char a[]={'0', '1', '2', '3', '4', '5','6', '7', '8', '9', 'A', 'B', 
            'C', 'D', 'E', 'F'};
        if (s.equals("decimal")){
            int num=Integer.parseInt(n);
            while (num>0){
                int rem=num%16;
                result=a[rem]+result;
                num=num/16;
            }
            System.out.println(""+result);
    }
        //code to convert binary to hexadecimal
        if (s.equals("binary")){
            while (n.length()%4!=0){
                //adding leading zeros to make groups of 4
                n='0'+n;
            }
            String r1="";
            for (int i=0; i<n.length(); i=i+4){
                String group=n.substring(i, i+4);
                //converting each group of 4 into its hexadeicmal equivalent
                int r=to_decimal(group);
                if (r>=10 && r<=15){
                    //converting integer to its equivalent character
                    char c=(char)(r-10+'A');
                    String ch=Character.toString(c);
                    r1=r1+ch;
                }
                else{
                    r1=r1+Integer.toString(r);
                }
               }
            System.out.println(""+r1);
        }
        //converting octal to hexadecimal
        if (s.equals("octal")){
            //converting octal number to binary
            for (int i=0; i<n.length(); i++){
                char c=n.charAt(i);
                String b=to_binary(c);
                //while loop for adding leading zeros to make length of 3
                while (b.length()<3){
                   b="0"+b;
             }
                result=result+b;
                
            }
            //converting binary to hexadecimal
            n=result;
            while (n.length()%4!=0){
                //adding leading zeros to make groups of 4
                n='0'+n;
            }
            System.out.println("n="+n);
            String r1="";
            for (int i=0; i<n.length(); i=i+4){
                String group=n.substring(i, i+4);
                //converting each group of 4 into its hexadeicmal equivalent
                int r=to_decimal(group);
                if (r>=10 && r<=15){
                    //converting integer to its equivalent character
                    char c=(char)(r-10+'A');
                    String ch=Character.toString(c);
                    r1=r1+ch;
                }
                else{
                    r1=r1+Integer.toString(r);
                }
               }
            System.out.println(""+r1);
        }
    }
    void decimal (String s, String n){
        int power=0;
        int result=0;
        //code to convert binary number to decimal
        if (s.equals("binary")){
            for (int i=n.length()-1; i>=0; i--){
                //taking out individual characters
                char c=n.charAt(i);
                if (c=='1'){
                    //multyplying each individual character with base
                    int temp=(int)Math.pow(2,power);
                    result+=temp;
                }
                power=power+1;
            }
            System.out.println(""+result);
        }
        //code to convert octal number to decimal
        if (s.equals("octal")){
            result=0;
            power=0;
            for (int i=n.length()-1; i>=0; i--){
                //taking out individual characters
                char c=n.charAt(i);
                if (c!='0'){
                    //multyplying each individual character with base 
                    int temp=(int)Math.pow(8, power);
                    //converting character into integer
                    int digit=c-'0';
                    result=result+(digit*temp);
                }
                power=power+1;
               
            }
            System.out.println(""+result);
        }
        //code to convert hexadecimal number to decimal
        if (s.equals("hexadecimal")){
            result=0;
            power=0;
            int digit;
            for (int i=n.length()-1; i>=0; i--){
                char c=n.charAt(i);
                if (c!='0'){
                    int temp=(int)Math.pow(16, power);
                    //checking if character is between 0 and 9 
                    if (c>='0' && c<='9'){
                    //converting character into integer
                    digit=c-'0';
                    result=result+(digit*temp);
                    }
                    //checking if character is between A and F
                    if (c>='A' && c<='F'){
                        //converting character into integer
                        digit=10+(c-'A');
                        result=result+(digit*temp);
                    }
                   }
                power=power+1;
             }
            System.out.println(""+result);
        }
    }
}
