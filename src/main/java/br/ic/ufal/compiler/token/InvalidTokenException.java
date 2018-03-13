package br.ic.ufal.compiler.token;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(int row, int col, String msg) {
        super("[" + row + ", " + col + "] " + msg);
    }
}