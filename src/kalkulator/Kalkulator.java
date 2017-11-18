package kalkulator;

import java.util.Scanner;
/**
 *
 * @author Brendon
 */
public class Kalkulator {
    
    

    
    public static void main(String[] args) {
        // TODO code application logic here
        int a,b;
        
        String operacja;
        String [] tab= new String [3];
        
         Scanner wypisz= new Scanner(System.in);
         
        System.out.println("Wpisz działanie: ");
        
        operacja= wypisz.nextLine();
        
        tab= operacja.split(" ");
        
         
        a=zamianara(tab[0]);
        b=zamianara(tab[2]);
        
        int wynikKonwersjiRA = dzialanie(a,b,tab[1]);
        System.out.println("Wynik l.arabska: "+wynikKonwersjiRA);
        
        zamiana_ar(wynikKonwersjiRA);
        
        
    }
    
    public static int zamianara(String liczba)
    {
        int arabska=0;
        char[] znaki= {'I', 'V', 'X', 'L', 'C' , 'D', 'M'};
        int [] liczby= {1 ,5 ,10 ,50 ,100 ,500 ,1000 };
        char a;
        char b;
       int dlugosc= liczba.length();
       int wynik=0;
    
       arabska=kontrola(znaki,liczby,liczba);
       
       return arabska;
    }
    
    public static int kontrola( char[] znaki,int[] liczby, String liczba)
    {
     int wynik=0;
     char a;
     int al=0;
     int [] tab= new int [liczba.length()];
     
     
     
     for(int j=0; j<liczba.length(); j++)
     {
         a= liczba.charAt(j);   
         for(int i=0; i<7; i++)
        {
         if(a== znaki[i])
         {
             al= i;
         }
         
        }
         tab[j]= liczby[al];
     }
     
     for(int i=0; i<liczba.length()-1; i++)
     {
         if(tab[i]<tab[i+1])
             tab[i]= -1* tab[i];
         wynik= wynik+ tab[i];

     }
     
    wynik= wynik+ tab[liczba.length()-1];
          
     return wynik;
     
    }
    
    public static int dzialanie(int a, int b, String dz)
    {
        int wynik =0;
        
        
        switch(dz)
        {
            case ("+"):
                wynik= a+b;
                break;
            case ("*"):
                wynik= a*b;
                break;
            case ("-"):
                wynik= a-b;
                break;
                
        }
        
        
        return wynik;
    }

    private static void zamiana_ar(int wynikKonwersjiRA) {
        
        String result="";
        Integer[] tab = new Integer[4];
        
        
        Integer tmp = wynikKonwersjiRA;
        
        tab[0] = (Integer) (tmp / 1000);
        tab[1] = (Integer) (tmp-1000*tab[0])/100;
        tab[2] = (Integer) (tmp-1000*tab[0]-100*tab[1])/10;
        tab[3] = (Integer) (tmp-1000*tab[0]-100*tab[1]-10*tab[2])/1;
        
        //System.out.println(tab[0]+ " "+ tab[1]+ " "+ tab[2]+" "+tab[3]);
        
        result+= assemblyStringGivenTimes(tab[0], "M");
       
        if(tab[1]<4)
            result+= assemblyStringGivenTimes(tab[1], "C");
        else if (tab[1]==4)
             result+= "CD";
        else if (tab[1]==5)
             result+= "D";
        else if (tab[1]>5)
             result+= "D" + assemblyStringGivenTimes(tab[1]-5, "C");
        else if (tab[1]==9)
             result+= "CM";
        
        if(tab[2]<4)
            result+= assemblyStringGivenTimes(tab[2], "X");
        else if (tab[2]==4)
             result+= "XL";
        else if (tab[2]==5)
             result+= "L";
        else if (tab[2]>5)
             result+= "L" + assemblyStringGivenTimes(tab[2]-5, "X");
        else if (tab[2]==9)
             result+="XC";
            
        if(tab[3]<4)
            result+= assemblyStringGivenTimes(tab[3], "I");
        else if (tab[3]==4)
             result+= "IV";
        else if (tab[3]==5)
             result+= "V";
        else if (tab[3]>5)
             result+= "V" + assemblyStringGivenTimes(tab[3]-5, "I");
         else if (tab[3]==9)
             result+="IX";
       
        
        System.out.println("Wynik l.rzymska: "+result);
                
    }
    
    private static String assemblyStringGivenTimes(int number, String toAssembly ){
       String result="";
       for(int i=0;  i<number; i++){
            result= result + toAssembly;
       }
    
       return result;
   }
    
}
    



