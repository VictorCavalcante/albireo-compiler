package br.ic.ufal.compiler.token;

public class Token {

    public enum Category {
        EOF(0),
        ID(1),
        CONSNUMINT(2),
        CONSNUMFL(3),
        CONSLOGIC(4),
        CONSCHAR(5),
        CONSSTRING(6),
        PRIMINT(7),
        PRIMFL(8),
        PRIMCHAR(9),
        PRIMBOOL(10),
        PRIMSTRING(11),
        PARENSTART(12),
        PARENEND(13),
        BRACKSTART(14),
        BRACKEND(15),
        CURLYSTART(16),
        CURLYEND(17),
        COMMASEP(18),
        SEMICOLSEP(19),
        TERMINAL(20),
        COMMENT(21),
        OPLOGICAND(22),
        PLOGICOR(23),
        OPLOGICNOT(24),
        OPARITADD(25),
        OPARITMULT(26),
        OPNEGUN(27),
        OPREL1(28),
        OPREL2(29),
        OPATTRB(30),
        OPCONC(31),
        INSIF(32),
        INSDO(33),
        INSELSE(34),
        NSWHILE(35),
        INSWCTRL(36),
        SWRETURN(37),
        SWEMPTY(38),
        SWGROUP(39),
        SWREAD(40),
        SWPRINT(41),
        SWINIT(42),
        SWFUNC(43),
        SWVECTOR(44);

        private int value;

        Category(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private Category category;
    private String lexicalValue;
    private int lin, col;

    public Token(Category category,
                 String lexicalValue,
                 int lin,
                 int col) {
        this.category = category;
        this.lexicalValue = lexicalValue;
        this.lin = lin;
        this.col = col;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getLexicalValue() {
        return this.lexicalValue;
    }

    @Override
    public String toString() {
        return  "[" + this.lin + ", " + this.col + "] " +
                "(" + category + ", " + category.getValue() + ") " +
                "{" + this.lexicalValue + "} \n";
    }
}
