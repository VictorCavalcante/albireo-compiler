package br.ic.ufal.compiler;

import br.ic.ufal.compiler.parser.Parser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertNotNull;

public class HelloWorldTest {

    private File albFile;

    @Before
    public void getSourceCodeFile() {
        albFile = new File(System.getProperty("user.dir") + File.separator + "src/main/resources/hello-world.alb");
    }

    @Test
    public void shouldParseHelloWorldCode() throws FileNotFoundException {
        Parser albParser = new Parser(albFile);
        albParser.listTokens();
        assertNotNull(albParser.scanner);
    }

}
