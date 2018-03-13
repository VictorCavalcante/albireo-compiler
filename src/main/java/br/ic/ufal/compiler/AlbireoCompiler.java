package br.ic.ufal.compiler;

import br.ic.ufal.compiler.parser.Parser;
import br.ic.ufal.compiler.token.InvalidTokenException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Victor Cavalcante
 */
public class AlbireoCompiler {

    public static void main(String[] args) throws FileNotFoundException, InvalidTokenException {

        try {
            if (args.length > 0) {
                System.out.println(args[0]);
                File albFile = new File(AlbireoCompiler.getAbsolutePath(args[0]));
                Parser albParser = new Parser(albFile);

                albParser.listTokens();
            } else {
                System.out.println("Filename not specified");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getAbsolutePath(String filename) {
        return System.getProperty("user.dir") + File.separator + filename;
    }

}