package br.ic.ufal.compiler.scanner;

import java.io.*;
import br.ic.ufal.compiler.token.Token;

public class Scanner {

    private BufferedReader bufferReader;
    private char currentChar;
    private int row = 1;
    private int col = 1;

    public Scanner(File fileToParse) throws FileNotFoundException{
        bufferReader = new BufferedReader(new FileReader(fileToParse));
        currentChar = getNextChar();
        System.out.println(currentChar);
    }

    public Token nextToken() {
        return null;
    }

    private char getNextChar(){
        char nextChar;
        try {
            nextChar = (char) bufferReader.read();
            col++;
            return nextChar;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
