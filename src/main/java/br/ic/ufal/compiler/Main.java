package br.ic.ufal.compiler;

import br.ic.ufal.compiler.parser.Parser;
import br.ic.ufal.compiler.token.InvalidTokenException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Victor Cavalcante
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, InvalidTokenException {

        try {
            File albFile = new File(Main.getAbsolutePath("hello-world.alb"));
            Parser albParser = new Parser(albFile);

            albParser.listTokens();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getAbsolutePath(String filename) {
        return System.getProperty("user.dir") + File.separator + "src/main/resources/" + filename;
    }

}