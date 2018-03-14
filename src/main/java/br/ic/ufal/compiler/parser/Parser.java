package br.ic.ufal.compiler.parser;

import java.io.File;
import java.io.FileNotFoundException;
import br.ic.ufal.compiler.scanner.Scanner;
import br.ic.ufal.compiler.token.InvalidTokenException;
import br.ic.ufal.compiler.token.Token;

public class Parser {
    public Scanner scanner;
    private String fileName;

    public Parser(File fileToParse) throws FileNotFoundException {
        scanner = new Scanner(fileToParse);
        fileName = fileToParse.getName();
    }

    public void listTokens(){
        try {
            Token currentToken = this.scanner.nextToken();

            System.out.println("Parsing: " + this.fileName);
            System.out.println("-----------------------------");
            while (currentToken != null) {
                System.out.println(currentToken);
                currentToken = this.scanner.nextToken();
            }
        } catch (InvalidTokenException e) {
            e.printStackTrace();
        }
    }

}
