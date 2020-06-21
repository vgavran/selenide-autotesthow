package selenidestady.XPathUtils;

public class XPath {

    public static String findByCssClass (String value)
    {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value +" ')";

    }
}
