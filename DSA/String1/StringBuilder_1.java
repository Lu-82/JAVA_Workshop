package DSA.String1;

public class StringBuilder_1 {
    public static void main(String[] args) {
        String st = "StringBuilder";
        StringBuilder builder = new StringBuilder(st);
        // for(int i = 0; i<26; i++){
        //     char ch = (char)('a'+ i);
        //     builder.append(ch);
        // }
        // System.out.println(builder.toString());


        
        builder.append("_ST");
        System.out.println("add character on the end of string");
        System.out.println(builder.toString());

        System.out.println("insert the character on a spacific Location");
        System.out.println(builder.insert(builder.length(), "JAVA"));

        System.out.println("reverse string");
        System.out.println(builder.reverse());

        System.out.println("Replace subString");
        System.out.println(builder.replace(0, 5, "String_Boots"));

        System.out.println("Delete some character from a string");
        System.out.println();
    }
}
