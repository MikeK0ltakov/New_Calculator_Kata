import java.util.TreeMap;
public class Int {
    TreeMap<String, Integer> strToInt = new TreeMap<>();
    public Int(){
        strToInt.put("1",1);
        strToInt.put("2",2);
        strToInt.put("3",3);
        strToInt.put("4",4);
        strToInt.put("5",5);
        strToInt.put("6",6);
        strToInt.put("7",7);
        strToInt.put("8",8);
        strToInt.put("9",9);
        strToInt.put("10",10);
    }
    public boolean isInt(String numb){
        return strToInt.containsKey(numb.charAt(0));
    }
    public int strInt(String s){
        int res;
        boolean isOnlyDigits = true;
        for(int i = 0; i < s.length() && isOnlyDigits; i++) {
            if(!Character.isDigit(s.charAt(i))) {
                isOnlyDigits = false;
            }
        }
        if (isOnlyDigits && strToInt.containsKey(s)){
            res = strToInt.get(s);
        }else if (isOnlyDigits){
            res = -1;
        } else {
            res = -2;
        }
        return res;
    }
}
