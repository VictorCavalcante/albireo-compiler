package br.ic.ufal.compiler.lexer;

import br.ic.ufal.compiler.token.Token;
import java.util.LinkedList;

public class Lexer {

    private LinkedList<Token> tokens;
    private static Lexer lexer = null;

    private Lexer() {
        this.tokens = new LinkedList<Token>();
    }

    private void generateLexer() {
        System.out.println("Generate");
    }
}
