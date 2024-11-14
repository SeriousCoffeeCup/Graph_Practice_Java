package demos;
import java.util.List;
import java.util.LinkedList;

public class String_Join_Demo {
//    public static <T> void main(String[] args){
//        List<T> array = new LinkedList<T>();
    public static void main(String[] args){
        List<Integer> array = new LinkedList<Integer>();
        array.add(11);
        array.add(22);
        array.add(33);
        array.add(44);
        array.add(55);

        //test this out, and replace the join in the
        // well this isnt an essential trait is it
//         String joined = String.join("+", array);

                StringBuilder delimitedList = new StringBuilder();

        for ( Integer w : array){
            delimitedList.append(w).append(", ");
        }
        if (delimitedList.length() > 0){
            delimitedList.setLength(delimitedList.length() - 2); // removing the last comma and space
        }
    }
}
