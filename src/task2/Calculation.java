package task2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Calculation {
    public static long calculateNthTerm(int n){
        int value = 0;
        Map<Integer,Integer> term = new LinkedHashMap<>();
        for(int i = 1;i<=8;i++){
            if(!term.containsKey(i) && i<=3){
                int key1 = i;
                int valu = i;
                term.put(key1,valu);
            }else{
                if(i%2==1){
                    int key2 = i;
                    int val2 = term.get(i-2)*3;
                    term.put(key2,val2);
                }
                else if(i%2==0){
                    int key3 = i;
                    int val3 = term.get(i-1)*2;
                    term.put(key3,val3);
                }
            }

        }
        value = term.get(n);

        return value;
    }


    public static void main(String[] args) {
        System.out.println(calculateNthTerm(1));
        System.out.println(calculateNthTerm(4));
        System.out.println(calculateNthTerm(7));
    }
}
