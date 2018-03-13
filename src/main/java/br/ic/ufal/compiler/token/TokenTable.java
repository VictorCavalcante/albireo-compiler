package br.ic.ufal.compiler.token;

import java.util.HashMap;

public class TokenTable {

    private final static HashMap<String, TokenCategory> tokensMap = new HashMap<String, TokenCategory>();

    static {
        /* TYPES */
        tokensMap.put("int", TokenCategory.TYPE);
        tokensMap.put("float", TokenCategory.TYPE);
        tokensMap.put("char", TokenCategory.TYPE);
        tokensMap.put("boolean", TokenCategory.TYPE);
        tokensMap.put("charstring", TokenCategory.TYPE);

        /* BOOLEANS */
        tokensMap.put("yes", TokenCategory.CONSBOOL);
        tokensMap.put("no", TokenCategory.CONSBOOL);

        /* INSTRUCTIONS*/
        tokensMap.put("if", TokenCategory.INSIF);
        tokensMap.put("else", TokenCategory.INSELSE);
        tokensMap.put("while", TokenCategory.INSWHILE);
        tokensMap.put("whilecontrol", TokenCategory.INSWCTRL);

        /* SEPARATORS */
        tokensMap.put("(", TokenCategory.PARENSTART);
        tokensMap.put(")", TokenCategory.PARENEND);
        tokensMap.put("[", TokenCategory.BRACKSTART);
        tokensMap.put("]", TokenCategory.BRACKEND);
        tokensMap.put("{", TokenCategory.CURLYSTART);
        tokensMap.put("}", TokenCategory.CURLYEND);
        tokensMap.put(",", TokenCategory.COMMASEP);
        tokensMap.put(";", TokenCategory.SEMICOLSEP);
        tokensMap.put(".", TokenCategory.DOTSEP);

        /* OPERATORS */
        tokensMap.put("+", TokenCategory.OPARITADD);
        tokensMap.put("-", TokenCategory.OPARITSUB);
        tokensMap.put("*", TokenCategory.OPARITMULT);
        tokensMap.put("/", TokenCategory.OPARITDIV);
        tokensMap.put("%", TokenCategory.OPARITMOD);

        tokensMap.put("=", TokenCategory.OPATTRB);
        tokensMap.put("!", TokenCategory.OPLOGICNOT);
        tokensMap.put("||", TokenCategory.OPLOGICOR);
        tokensMap.put("&&", TokenCategory.OPLOGICAND);

        tokensMap.put("==", TokenCategory.OPEQUAL);
        tokensMap.put("!=", TokenCategory.OPNOTEQUAL);
        tokensMap.put(">", TokenCategory.OPGT);
        tokensMap.put("<", TokenCategory.OPLT);
        tokensMap.put(">=", TokenCategory.OPLTEQ);
        tokensMap.put("<=", TokenCategory.OPGTEQ);

        /* SPECIAL WORDS */
        tokensMap.put("initializeApp", TokenCategory.SWINIT);
        tokensMap.put("readin", TokenCategory.SWREAD);
        tokensMap.put("printout", TokenCategory.SWPRINT);
        tokensMap.put("foo", TokenCategory.SWFUNC);
        tokensMap.put("empty", TokenCategory.SWEMPTY);
        tokensMap.put("return", TokenCategory.SWRETURN);
    }

    public static TokenCategory getTokenClass(String lex) {
        return tokensMap.get(lex);
    }

    public static boolean contains(String lex) {
        return tokensMap.containsKey(String.valueOf(lex));
    }

}
