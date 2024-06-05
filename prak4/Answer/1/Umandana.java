public class Umandana {
    /**
     * Mengembalikan kata yang telah diubah menjadi bahasa Umandana
     * Huruf a menjadi "aiden"
     * Huruf i menjadi "ipri"
     * Huruf u menjadi "upru"
     * Huruf e menjadi "epre"
     * Huruf o menjadi "opro"
     * Huruf mati yang tidak diikuti huruf vokal menjadi huruf tersebut + "es"
     * Suku kata "ng" yang tidak diikuti huruf vokal menjadi "strengen"
     * Suku kata "ng" yang diikuti huruf vokal tetap menjadi "ng"
     * Suku kata "ny" yang diikuti huruf vokal tetap menjadi "ny"
     * Selain ketentuan di atas, huruf/karakter tidak diubah
     * *
     * 
     * @param words
     * @return kata yang telah diubah menjadi bahasa Umandana
     * 
     */
    public static String toUmandana(String words) {
        String retval = new String();
        
        for(int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == 'a') retval += "aiden";
            else if (words.charAt(i) == 'i') retval += "ipri";
            else if (words.charAt(i) == 'u') retval += "upru";
            else if (words.charAt(i) == 'e') retval += "epre";
            else if (words.charAt(i) == 'o') retval += "opro";
            else if (words.charAt(i) == ' ') retval += " ";

            else if (words.charAt(i) == 'n') {
                if (i + 1 < words.length()) {
                    if (words.charAt(i+1) == 'g') {
                        if (i + 2 < words.length()) {
                            if (isVowel(words.charAt(i+2))) {
                                retval += "ng";
                                i++;
                            } 
                            else {
                                retval += "strengen";
                                i++;
                            }
                        } 
                        else {
                            retval += "strengen";
                            i++;
                        }
                    }

                    else if (words.charAt(i+1) == 'y') {
                        if (i + 2 < words.length()) {
                            if (isVowel(words.charAt(i+2))) {
                                retval += "ny";
                                i++;
                            } 
                            else {
                                retval += "nes";
                            }
                        } else {
                            retval += "nes";
                        }
                    }

                    else if (isVowel(words.charAt(i+1))) {
                        retval += words.charAt(i);
                    }

                    else {
                        retval += words.charAt(i) + "es";
                    }
                }
                else {
                    retval += words.charAt(i) + "es";
                }
            }

            else if (isConsonant(words.charAt(i))) {
                if (i + 1 < words.length()) {
                    if (isVowel(words.charAt(i+1))) {
                        retval += words.charAt(i);
                    } 
                    else {
                        retval += words.charAt(i) + "es";
                    }
                } 
                else {
                    retval += words.charAt(i) + "es";
                }
            }
            else{
                retval += words.charAt(i);
            }
        }
        return retval;
    }

    private static boolean isVowel(char c){
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
    }

    private static boolean isConsonant(char c){
        return !isVowel(c);
    }
    // public static String toUmandana(String words) {
    //     StringBuilder p = new StringBuilder(words);
    //     p.append(" ");
    //     String res = "";
    //     String[] w = p.toString().split("");
    //     for (int i = 0; i < w.length; i++) {
    //         if(w[i].equals("a")){
    //             w[i] = w[i].replaceAll(".", "aiden");
    //         }
    //         else if(w[i].equals("i")){
    //             w[i] = w[i].replaceAll(".", "ipri");
    //         }
    //         else if(w[i].equals("u")){
    //             w[i] = w[i].replaceAll(".", "upru");
    //         }
    //         else if(w[i].equals("e")){
    //             w[i] = w[i].replaceAll(".", "epre");
    //         }
    //         else if(w[i].equals("o")){
    //             w[i] = w[i].replaceAll(".", "opro");
    //         }
    //         else if(w[i].matches("n")){
    //             if(w[i+1].matches("g")){
    //                 if(w[i+2].matches("[^aiueo]")){
    //                     w[i] = w[i].replaceAll(".", "strenge");
    //                     w[i+1] = w[i+1].replaceAll(".", "n");
    //                 }
    //             }
    //             else{
    //                 if(w[i+1].matches("[^aiueo]")){
    //                     if(w[i+1].matches(" ")){
    //                         w[i] = w[i] + "es";
    //                     }
    //                     else{
    //                         w[i+1] = w[i+1] + "es";
    //                     }
    //                 }
    //             }
    //         }
    //         else if(w[i].matches("[bcdfghjklmnpqrstvwxyz]")){
    //             if(w[i+1].matches("[^aiueo]")){
    //                 if(w[i+1].matches(" ")){
    //                     w[i] = w[i] + "es";
    //                 }
    //                 else{
    //                 w[i+1] = w[i+1] + "es";
    //                 }
    //             }
    //         }

    //     }
    //     for (int i = 0; i < w.length-1; i++) {
    //         res += w[i];
    //     }
    //     return res.toString();
    // }

    /**
     * Mengembalikan kata Umandana ke bentuk normal
     * *
     * 
     * @param words kata dalam bahasa Umandana
     * @return kata telah diubah ke bentuk normal
     */
    public static String deUmandana(String words) {
        String s = new String(words);
        s = s.replaceAll("aiden", "a");
        s = s.replaceAll("ipri", "i");
        s = s.replaceAll("upru", "u");
        s = s.replaceAll("epre", "e");
        s = s.replaceAll("opro", "o");
        s = s.replaceAll("strengen", "ng");
        s = s.replaceAll("([^aiueo])es", "$1");
        return s.toString();

    }

    // public static void main(String[] args){
    //     System.out.println(Umandana.toUmandana("n e"));
    // }
}
