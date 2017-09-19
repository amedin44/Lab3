//import java.awt.font.TextHitInfo;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/***
 *
 * @author amedin44
 *
 */
public class Lab3 {
    /***
     *
     * @param args makes program run
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a link: ");
        String link = input.nextLine();
        String doc = urlToString(link);
        System.out.println(doc);
        int lengthOfDoc = doc.length();
        int numOfWord = 0;
        for (int i = 0; i < lengthOfDoc; i++) {
            boolean currentLetterSpace = doc.substring(i, i + 1).equals(" ");
            boolean nextLetterSpace = doc.substring(i + 1, i + 2).equals(" ");
            if (!currentLetterSpace && nextLetterSpace) {
                numOfWord++;
            }
        }
        System.out.println(numOfWord);
        input.close();
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
