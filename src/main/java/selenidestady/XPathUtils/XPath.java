package selenidestady.XPathUtils;

public class XPath {

    public static String findByClass (String className)
    {
        String xp = "contains(concat(' ', normalize-space(@class), ' '), ' " + className +" ')";
        return xp;
    }
}
