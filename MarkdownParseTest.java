
import static org.junit.Assert.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(5 + 10, 15);
    }

    @Test
    public void MarkdownParse() {
        assertEquals(MarkdownParse.getLinks("test-file.md"), List.of("https://something.com", "some-page.html"));
    }

    @Test
    public void testMarkDownParseTestFile() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("https://something.com", "some-page.html"));
    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("`google.com", "google.com", "ucsd.edu"));
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("a.com", "a.com(())", "example.com"));
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents),
                List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "(https://cse.ucsd.edu/"));
    }

}