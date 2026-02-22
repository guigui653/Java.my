public class program {
    public static void main(String[] args) {

       String original = " abcd ADFJD ABC sasd ERFF";

       // Converte todos os caracteres para minúsculo
       String s01 = original.toLowerCase();
       // Converte todos os caracteres para maiúsculo
       String s02 = original.toUpperCase();
       // Remove espaços em branco nas extremidades (início e fim), mas mantém os do meio
       String s03 = original.trim();
       // Gera uma nova string a partir do caractere no índice 2 até o final
       String s04 = original.substring(2);
       // Gera uma nova string do índice 2 até o 9 (o caractere no índice 9 não entra)
       String s05 = original.substring(2, 9);
       // Substitui todas as ocorrências do caractere 'a' por 'x'
       String s06 = original.replace('a', 'x');
       // Substitui a sequência de caracteres "acb" por "xy" (se encontrar)
       String s07= original.replace("acb" , "xy");
       // Retorna o índice (posição) da primeira ocorrência de "bc"
       int i = original.indexOf("bc");
       // Retorna o índice da última ocorrência de "bc"
       int j = original.lastIndexOf("bc");

       System.out.println("Original : - " + original + "-");
       System.out.println("tolowerCase : - " + s01 + "-");
        System.out.println("toUpperCase : - " + s02 + "-");
        System.out.println("trim : - " + s03 + "-");
        System.out.println("substring(2) : - " + s04 + "-");
        System.out.println("substring(2,9) : - " + s05 + "-");
        System.out.println("replace('a', 'x') : - " + s06 + "-");
        System.out.println("replace('acb', 'xy') : - " + s07 + "-");
        System.out.println("indexOf('bc') : - " + i + "-");
        System.out.println("lastIndexOf('bc') : - " + j + "-");

    }

}
