package br.ic.ufal.compiler.token;

public enum TokenCategory {
    EOF(0),
    ID(1),
    TYPE(2),
    CONSINT(3),
    CONSFLOAT(4),
    CONSBOOL(5),
    CONSCHAR(6),
    CONSSTRING(7),
    COMMASEP(8),
    DOTSEP(9),
    SEMICOLSEP(10),
    COLONSEP(11),
    PARENSTART(12),
    PARENEND(13),
    BRACKSTART(14),
    BRACKEND(15),
    CURLYSTART(16),
    CURLYEND(17),
    OPLOGICAND(18),
    OPLOGICOR(19),
    OPLOGICNOT(20),
    OPARITADD(21),
    OPARITSUB(22),
    OPARITMULT(23),
    OPARITDIV(24),
    OPARITMOD(25),
    OPNEGUN(26),
    OPEQUAL(27),
    OPNOTEQUAL(28),
    OPGT(29),
    OPLT(30),
    OPGTEQ(31),
    OPLTEQ(32),
    OPATTRB(33),
    OPCONC(34),
    INSIF(35),
    INSDO(36),
    INSELSE(37),
    INSWHILE(38),
    INSWCTRL(39),
    SWRETURN(40),
    SWEMPTY(41),
    SWREAD(42),
    SWPRINT(43),
    SWINIT(44),
    SWFUNC(45),
    SWGROUP(46);

    private final int value;

    TokenCategory(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}