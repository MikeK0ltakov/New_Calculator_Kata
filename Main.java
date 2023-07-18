import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.nextLine();
        String ans = calculator.calc(num);
        System.out.print("\""+ans+"\"");
    }
}
class calculator{
    public static String calc(String viv){
        Int y = new Int();
        String[] actions = {" + ", " - ", " / ", " * "};
        String[] reaction = {" \\+ ", " - ", " / ", " \\* "};
        int ind = -1;
        boolean start = viv.startsWith("\"");
        try{
            if (!start){
                throw new ArithmeticException("Неправильный ввод");
        }
            for (int x = 0; x < actions.length; x++)
                if (viv.contains(actions[x])) {
                    ind = x;
                    break;
                }
            if (ind == -1) {
                throw new ArithmeticException("Неправильная операция");
            }
        }catch (ArithmeticException e){
            System.out.println(e);
            System.exit(0);
        }
        String[] data = viv.split(reaction[ind]);
        try{
            if ((ind == 2 | ind == 3) && data[1].startsWith("\"") && data[0].startsWith("\"")){
                throw new ArithmeticException("Неправильная операция");
            }
            if (!data[1].startsWith("\"") && data[0].startsWith("\"") && (ind == 0 | ind == 1)){
                throw new ArithmeticException("Неправильная операция");
            }
            if (data.length > 2 | data.length <= 1){
                throw new ArithmeticException("Введены некорректные данные");
            }
            int t = y.strInt(data[1].replace("\"", ""));
            if (t == -1 & !data[1].startsWith("\"")) {
                throw new ArithmeticException("Числа должны быть целыми и от 1 до 10 включительно");
            }
            if (data[0].length()>12 | data[1].length()>12){
                throw new ArithmeticException("Длина строк до 10");
            }
        }
        catch (ArithmeticException e){
            System.out.print(e);
            System.exit(0);
        }
        data[0] = data[0].replace("\"", "");
        data[1] = data[1].replace("\"", "");
        String result = switch(actions[ind]){
            case " + ":
                String s = data[0] + data[1];
                yield s;
            case " * ":
                String d = "";
                for (int i = 0; i< y.strInt(data[1]);i++){
                    d += data[0];
                }
                yield d;
            case " - ":
                String f = "";
                String repl =data[0].replace(data[1],"");
                f += repl;
                yield f;
            case " / ":
                String j = "";
                int l;
                l = data[0].length() / y.strInt(data[1]);
                char[] dst = new char[l];
                data[0].getChars(0,l,dst,0);
                for (char c : dst) {
                    j += c;
                }
                yield j;
            default:
                yield "0";
        };
    String newres = "";
    if (result.length()>40){
        char[] dst = new char[40];
        result.getChars(0,40,dst,0);
        for (char c : dst) {
            newres += c;
        }
        newres += "...";
        return newres;
    }else {
        return result;
    }
    }
}