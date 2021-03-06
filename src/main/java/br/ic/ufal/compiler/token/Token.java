package br.ic.ufal.compiler.token;

public class Token {
    private TokenCategory category;
    private String lexicalValue;
    private int row, col;

    public Token(TokenCategory category,
                 String lexicalValue,
                 int row,
                 int col) {
        this.category = category;
        this.lexicalValue = lexicalValue;
        this.row = row;
        this.col = col;
    }

    public TokenCategory getCategory() {
        return this.category;
    }

    public String getLexicalValue() {
        return this.lexicalValue;
    }

    @Override
    public String toString() {
        return  "[" + String.format("%04d", this.row) + ", " + String.format("%04d", this.col) + "] " +
                "(" + String.format("%04d", this.category.getValue()) + ", " + String.format("%10s", this.category) + ") " +
                "{" + this.lexicalValue + "}";
    }
}
