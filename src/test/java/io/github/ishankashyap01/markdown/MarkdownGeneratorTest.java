package io.github.ishankashyap01.markdown;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Tests the markdown syntax for table generation
 */
class MarkdownGeneratorTest
{
	@Test
	void generatesReadableMarkdownTable()
    {
		String[][] table = {{"Name", "Age"}, {"Alice", "30"}, {"Bob", "25"}};
		String expected = 
        "| Name  | Age |\n" + 
        "|-------|-----|\n" + 
        "| Alice | 30  |\n" + 
        "| Bob   | 25  |\n";
		assertEquals(expected, MarkdownGenerator.generateTable(table));
	}

	@Test
	void throwsExceptionForJaggedRows()
	{
		String[][] table = {{"Name", "Age", "City"}, {"Alice", "30"}, {"Bob", "25", "Paris"}};
		// assertEquals(expected, MarkdownGenerator.generateTable(table));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> MarkdownGenerator.generateTable(table));
	}

	@Test
	void generatesSingleRowMarkdownTable()
	{
		String[][] table = {{"Name", "Age"}};
		String expected =
			"| Name | Age |\n" +
			"|------|-----|\n";
		assertEquals(expected, MarkdownGenerator.generateTable(table));
	}

	@Test
	void returnsEmptyStringForEmptyTable()
	{
		assertEquals("", MarkdownGenerator.generateTable(new String[0][]));
	}
}
