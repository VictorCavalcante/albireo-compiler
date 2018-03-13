package br.ic.ufal.compiler.token;

public enum TokenCategory {
    EOF(0),
    ID(1),
    TYPE(2),
    CONSNUM(3),
    CONSBOOL(4),
    CONSCHAR(5),
    CONSSTRING(6),

    COMMASEP(18),
    DOTSEP(0),
    SEMICOLSEP(19),
    QUOTE(0),
    DQUOTE(0),

    PARENSTART(12),
    PARENEND(13),
    BRACKSTART(14),
    BRACKEND(15),
    CURLYSTART(16),
    CURLYEND(17),

    OPLOGICAND(22),
    OPLOGICOR(23),
    OPLOGICNOT(24),
    OPARITADD(25),
    OPARITSUB(0),
    OPARITMULT(26),
    OPARITDIV(0),
    OPARITMOD(0),
    OPNEGUN(27),
    OPEQUAL(0),
    OPNOTEQUAL(0),
    OPGT(0),
    OPLT(0),
    OPGTEQ(0),
    OPLTEQ(0),
    OPATTRB(30),
    OPCONC(31),

    INSIF(32),
    INSELSE(34),
    INSWHILE(35),
    INSWCTRL(36),

    SWRETURN(37),
    SWEMPTY(38),
    SWREAD(40),
    SWPRINT(41),
    SWINIT(42),
    SWFUNC(43);
    //OPREL1(28),
    //OPREL2(29),
    //INSDO(33),
    //TERMINAL(20),
    //COMMENT(21),
    //CONSNUMINT(2),
    //CONSNUMFL(3),
    //PRIMINT(7),
    //PRIMFL(8),
    //PRIMCHAR(9),
    //PRIMBOOL(10),
    //PRIMSTRING(11),
    //SWGROUP(39),
    //SWVECTOR(44);

    private final int value;

    TokenCategory(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}