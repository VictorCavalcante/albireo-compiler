package br.ic.ufal.compiler;

import br.ic.ufal.compiler.scanner.Scanner;
import br.ic.ufal.compiler.token.InvalidTokenException;
import br.ic.ufal.compiler.token.Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Victor Cavalcante
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, InvalidTokenException {

        try {
            File albFile = new File(Main.getAbsolutePath("src/main/resources/HelloWorld.alb"));
            Scanner scanner = new Scanner(albFile);

            Token currentToken = scanner.nextToken();
            while (currentToken != null) {
                System.out.println(currentToken);
                currentToken = scanner.nextToken();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getAbsolutePath(String filename) {
        return System.getProperty("user.dir") + File.separator + filename;
    }

}