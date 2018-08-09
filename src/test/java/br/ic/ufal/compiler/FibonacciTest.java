package br.ic.ufal.compiler;

import br.ic.ufal.compiler.parser.Parser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertNotNull;

public class FibonacciTest {

    private File albFile;

    @Before
    public void getSourceCodeFile() {
        albFile = new File(System.getProperty("user.dir") + File.separator + "src/main/resources/fibonacci.alb");
    }

    @Test
    public void shouldParseFibonacciCode() throws FileNotFoundException {
        Parser albParser = new Parser(albFile);
        albParser.listTokens();
        assertNotNull(albParser.scanner);
    }

}
