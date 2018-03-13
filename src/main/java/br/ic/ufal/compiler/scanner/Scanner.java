package br.ic.ufal.compiler.scanner;

import br.ic.ufal.compiler.token.InvalidTokenException;
import br.ic.ufal.compiler.token.Token;
import br.ic.ufal.compiler.token.TokenCategory;
import br.ic.ufal.compiler.token.TokenTable;
import java.io.*;

public class Scanner {
    private static final int EOF = (char) -1;
    private static TokenCategory prevTokenCateg;
    private BufferedReader bufferReader;
    private char currentChar;
    private int row = 1, col = 1;

    public Scanner(File fileToParse) throws FileNotFoundException {
        bufferReader = new BufferedReader(new FileReader(fileToParse));
        currentChar = getNextChar();
    }

    public Token nextToken() throws InvalidTokenException {
        String lexicalValue = "";
        TokenCategory currCategory;

        iterateUntilValidChar();

        if (currentChar == EOF) {
            System.out.println("EOF");
            return null;
        }

        if (isDivisionSlash()) { // If it's not a division, it's a comment
            new Token(TokenCategory.OPARITDIV, "/", row, col);
        }

        iterateUntilValidChar();

        // ### Searching for ID or Keyword
        if (Character.isLetter(currentChar)) {
            lexicalValue += currentChar;
            currentChar = getNextChar();

            while (Character.isLetterOrDigit(currentChar)) {
                lexicalValue += currentChar;
                currentChar = getNextChar();
            }

            if (TokenTable.contains(lexicalValue)){
                currCategory = TokenTable.getTokenClass(lexicalValue);
            } else {
                currCategory = TokenCategory.ID;
            }
        }
        // ### Checking for Integer or Float
        else if (Character.isDigit(currentChar)) {
            lexicalValue += currentChar;
            currentChar = getNextChar();
            int dots = 0;

            while (Character.isDigit(currentChar) || currentChar == '.') {
                if (currentChar == '.') {
                    dots++;
                }
                lexicalValue += currentChar;
                currentChar = getNextChar();
            }

            if (dots > 1) {
                throw new InvalidTokenException(row, col,
                        "Invalid token. A float was expected: \"" + lexicalValue + "\"\n");
            }
            currCategory = TokenCategory.CONSNUM;
        }
        // ### Checking for String
        else if (currentChar == '"') {
            lexicalValue += currentChar;
            currentChar = getNextChar();

            while(currentChar != '"') {
                if (currentChar == '\n') {
                    throw new InvalidTokenException(row, col,
                            "Invalid token. A '\"' was expected: \"" + lexicalValue + "\"\n");
                }
                lexicalValue += currentChar;
                currentChar = getNextChar();
            }

            lexicalValue += currentChar;
            currentChar = getNextChar();
            currCategory = TokenCategory.CONSSTRING;
        }
        // ### Checking for Character
        else if (currentChar == '\'') {
            lexicalValue += currentChar;
            currentChar = getNextChar();

            if (currentChar != '\'') {
                lexicalValue += currentChar;
                currentChar = getNextChar();
            } else {
                throw new InvalidTokenException(row, col,
                        "Invalid token. A char was expected: \"" + lexicalValue + "\"\n");
            }

            if (currentChar == '\'') {
                lexicalValue += currentChar;
                currentChar = getNextChar();
                currCategory = TokenCategory.CONSCHAR;
            } else {
                throw new InvalidTokenException(row, col,
                        "Invalid token. A \"\'\" was expected: \"" + lexicalValue + "\"\n");
            }
        }
        // ### Checking for Operator
        else {
            lexicalValue += currentChar;

            if (TokenTable.contains(lexicalValue)) {
                currentChar = getNextChar();
                // 2-Digit Operators: ==  !=  >=  <=
                if (TokenTable.contains(lexicalValue+currentChar)) {
                    lexicalValue += currentChar;
                    currentChar = getNextChar();
                    currCategory = TokenTable.getTokenClass(lexicalValue);
                }
                // 1-Digit Operators: (  )  [  ]  {  }  ,  ;  .  +  -  *  /  %  =  !  >  <
                else {
                    if (lastTokenWasANumberOrId() && lexicalValue.equals("-")){
                        currCategory = TokenCategory.OPARITSUB;
                    } else if (!lastTokenWasANumberOrId() && lexicalValue.equals("-")){
                        currCategory = TokenCategory.OPNEGUN;
                    } else if (lastTokenWasACharOrString() && lexicalValue.equals("+")) {
                        currCategory = TokenCategory.OPCONC;
                    } else {
                        currCategory = TokenTable.getTokenClass(lexicalValue);
                    }
                }
            }
            // Logic Operators: ||  &&
            else {
                currentChar = getNextChar();
                if (TokenTable.contains(lexicalValue + currentChar)){
                    lexicalValue += currentChar;
                    currCategory = TokenTable.getTokenClass(lexicalValue);
                    currentChar = getNextChar();
                } else {
                    throw new InvalidTokenException(row, col, "Invalid token: \"" + lexicalValue + "\"\n");
                }
            }
        }

        prevTokenCateg = currCategory;
        return new Token(currCategory, lexicalValue, row, col);
    }

    private char getNextChar() {
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

    private void iterateUntilValidChar() {
        while (Character.isWhitespace(currentChar)){
            if (currentChar == '\n') {
                col = 0;
                row++;
            }
            currentChar = getNextChar();
        }
    }

    private boolean isDivisionSlash() {
        if (currentChar == '/') {
            currentChar = getNextChar();

            if (currentChar == '/') {
                // Go to next line
                currentChar = getNextChar();
                while (currentChar != '\n') {
                    col = 0;
                    row++;
                    currentChar = getNextChar();
                }
                currentChar = getNextChar();
                iterateUntilValidChar();
                isDivisionSlash();
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean lastTokenWasANumberOrId() {
        return (prevTokenCateg == TokenCategory.ID
                || prevTokenCateg == TokenCategory.CONSNUM
                || prevTokenCateg == TokenCategory.BRACKEND
                || prevTokenCateg == TokenCategory.PARENEND);
    }

    private boolean lastTokenWasACharOrString() {
        return (prevTokenCateg == TokenCategory.CONSCHAR || prevTokenCateg == TokenCategory.CONSSTRING);
    }

}
