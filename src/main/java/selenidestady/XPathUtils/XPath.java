package selenidestady.xpathutils;

public class XPath {

    public static String hasCssClass (String value)
    {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value +" ')";

    }
}
