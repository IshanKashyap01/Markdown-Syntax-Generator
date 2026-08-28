package io.github.ishankashyap01.markdown;

/**
 * Generates markdown syntax for links, images and tables
 */
public final class MarkdownGenerator
{
    private MarkdownGenerator() {}
    /**
     * Generates link syntax in markdown
     * @param text text to be displayed
     * @param link location it takes you to upon clicking
     * @return markdown syntax for link
     */
    public static String generateLink(String text, String link)
    {
        return "[" + text + "]" + "(" + link + ")";
    }

    /**
     * Generates image syntax in markdown
     * @param alt text that shows up when the image cannot be loaded
     * @param link location of the image
     * @return markdown syntax for image
     */
    public static String generateImage(String alt, String link)
    {
        return "![" + alt + "]" + "(" + link + ")";
    }

    /**
     * Generates table syntax in markdown
     * @param cells 2D matrix of all the cells in the table
     * @return markdown syntax for table
     */
    public static String generateTable(String[][] cells)
    {
        return cells[0][0];
    }
}