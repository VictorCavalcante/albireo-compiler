package br.ic.ufal.compiler.token;

public enum TokenCategory {
    EOF(0),
    ID(1),
    TYPE(2),
    CONSNUM(3),
    CONSBOOL(4),
    CONSCHAR(5),
    CONSSTRING(6),
    COMMASEP(7),
    DOTSEP(8),
    SEMICOLSEP(9),
    PARENSTART(10),
    PARENEND(11),
    BRACKSTART(12),
    BRACKEND(13),
    CURLYSTART(14),
    CURLYEND(15),
    OPLOGICAND(16),
    OPLOGICOR(17),
    OPLOGICNOT(18),
    OPARITADD(19),
    OPARITSUB(20),
    OPARITMULT(21),
    OPARITDIV(22),
    OPARITMOD(23),
    OPNEGUN(24),
    OPEQUAL(25),
    OPNOTEQUAL(26),
    OPGT(27),
    OPLT(28),
    OPGTEQ(29),
    OPLTEQ(30),
    OPATTRB(31),
    OPCONC(32),
    INSIF(33),
    INSDO(34),
    INSELSE(35),
    INSWHILE(36),
    INSWCTRL(37),
    SWRETURN(38),
    SWEMPTY(39),
    SWREAD(40),
    SWPRINT(41),
    SWINIT(42),
    SWFUNC(43);

    private final int value;

    TokenCategory(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}