package io.github.ishankashyap01.markdown;
/**
 * Generates a markdown table from a 2D array
 * @author Ishan Kashyap
 */
final class TableGenerator
{
    private TableGenerator() {}
    /**
     * Generates a table in markdown syntax
     * @param table 2D array
     * @return markdown syntax for table
     * @throws ArrayIndexOutOfBoundsException if any row's size is different than the
     * header
     */
    static String generateTable(String[][] table)
    {
        if(table.length == 0)
        {
            return "";
        }
        int[] columnWidth = getColumnWidth(table);
        StringBuilder builder = new StringBuilder();
        for(int row = 0; row < table.length; row++)
        {
            buildRow(builder, columnWidth, table[row]);
            if(row == 0)
            {
                buildHeader(builder, columnWidth);
            }
        }
        return builder.toString();
    }
    /**
     * Finds the length of the longest cell for each column
     * @param table 2D matrix
     * @return array containing max cell size
     */
    private static int[] getColumnWidth(String[][] table)
    {
        int[] columnWidth = new int[table[0].length];
        for(int column = 0; column < table[0].length; column++)
        {
            for(int row = 0; row < table.length; row++)
            {
                columnWidth[column] = Math.max(columnWidth[column], table[row][column].length());
            }
        }
        return columnWidth;
    }
    /**
     * Helper function that builds a row in markdown format
     * @param builder {@code StringBuilder} that stores the table
     * @param columnWidth width of each column
     * @param row row to build
     */
    private static void buildRow(StringBuilder builder, int[] columnWidth, String[] row)
    {
        builder.append("|");
        for(int column = 0; column < row.length; column++)
        {
            builder
            .append(" ")
            .append(row[column])
            .append(" ".repeat(columnWidth[column] - row[column].length()))
            .append(" |");
        }
        builder.append("\n");
    }
    /**
     * Helper function that builds the separator between the header and the body of the
     * table
     * @param builder {@code StringBuilder} that stores the table
     * @param columnWidth width of each column
     */
    private static void buildHeader(StringBuilder builder, int[] columnWidth)
    {
        builder.append("|");
        for(int column = 0; column < columnWidth.length; column++)
        {
            builder
            .append("-".repeat(columnWidth[column] + 2))
            .append("|");
        }
        builder.append("\n");
    }
}