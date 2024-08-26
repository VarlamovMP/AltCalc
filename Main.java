import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        char oper;
        String [] st;
        int i;
        System.out.println("Введи выражение в одну строку");
        Scanner scan = new Scanner(System.in);
        String stroka= scan.nextLine();

        if (stroka.contains(" + ")) {
            oper='+';
            st= stroka.split(" \\+ "); }
        else if  (stroka.contains(" - ")) {
            oper='-';
            st= stroka.split(" - "); }
        else if  (stroka.contains(" / ")) {
            oper='/';
            st= stroka.split(" / "); }
        else if  (stroka.contains(" * ")) {
            oper='*';
            st= stroka.split(" \\* "); }
        else throw new Exception("Не верное арифметическое действие ");
        if( st[0].startsWith("\"")==false || st[0].endsWith("\"")==false) throw new Exception("Первым элементом должна быть строка");
        if( st[0].length()>12 || st[1].length()>12) throw new Exception("Слишком длинные строки");

        if ((oper=='/'|| oper=='*')&& isNumeric(st[1]) == false ) {throw new Exception("делим или умножаем только на целое число");}

        if( (oper=='+'|| oper=='-') && ( st[1].startsWith("\"")==false || st[1].endsWith("\"")==false)) throw new Exception("Строку можно приплюсовать/минусовать только со строкой");

        if (oper=='+') SOUT(cut(st[0])+cut(st[1]) );

        if( oper=='*') {
           String stfin="";
            for ( i=0; i<mnogOrDelit(st[1]);i++) {
            stfin+= cut(st[0]);}
            if(stfin.length()>40) {
                StringBuffer strBuffer = new StringBuffer(stfin);
                strBuffer.setLength(40);
                System.out.println("\""+strBuffer.toString()+"...\"");}
            else SOUT(stfin);
            }
        if( oper=='/') {
            String strcut = st[0].substring(1,st[0].length()/mnogOrDelit(st[1]));
            SOUT(strcut);
        }
        if (oper== '-') {
            int index= cut(st[0]).indexOf(cut(st[1]));
            if (index==-1) { System.out.println(st[0]);}
            else {
               StringBuffer strBuffer = new StringBuffer(st[0]);
                strBuffer.replace(index+1,index+st[1].length()-1,"");
                System.out.println(strBuffer.toString());}

        }

        System.out.println("Программа завeршена");
    }

    public static boolean isNumeric(String str) {
        try { Integer.parseInt(str);
            return true;}
        catch (NumberFormatException e) { return false;}
    }

    public static int mnogOrDelit(String s) throws Exception {
        int x= Integer.parseInt(s);
        if(x<1 || x>10) throw new Exception("принимаем числа от 1 до 10 включительно");
        else return x;

    }
      public static String cut(String s){
            StringBuffer strBuffer = new StringBuffer(s);
            String strcut = strBuffer.substring(1,s.length()-1);
            return strcut;
        }
        static void SOUT(String fin) { System.out.println("\""+fin+"\"");}

}