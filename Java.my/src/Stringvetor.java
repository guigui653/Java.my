public class Stringvetor {
    public static void main (String[] args){

        String s = "Java";
        String[] vect = s.split(""); // Ordena o array alfabeticamente

        for (String letra : vect) {
            System.out.println(letra);
        }


    }
}
