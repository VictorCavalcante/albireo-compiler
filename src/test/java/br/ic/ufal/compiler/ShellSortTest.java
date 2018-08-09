package br.ic.ufal.compiler;

import br.ic.ufal.compiler.parser.Parser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;

public class ShellSortTest {

    private File albFile;

    @Before
    public void getSourceCodeFile() {
        albFile = new File(System.getProperty("user.dir") + File.separator + "src/main/resources/shell-sort.alb");
    }

    @Test
    public void shouldParseShellSortCode() throws FileNotFoundException {
        Parser albParser = new Parser(albFile);
        albParser.listTokens();
        assertNotNull(albParser.scanner);
    }

}
