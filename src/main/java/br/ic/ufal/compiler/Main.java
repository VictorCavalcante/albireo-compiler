package br.ic.ufal.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import br.ic.ufal.compiler.scanner.Scanner;

/**
 * @author Victor Cavalcante
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File albFile = new File(Main.getAbsolutePath("src/main/resources/HelloWorld.alb"));
        Scanner scanner = new Scanner();
    }

    private static String getAbsolutePath(String filename) {
        return System.getProperty("user.dir") + File.separator + filename;
    }

}