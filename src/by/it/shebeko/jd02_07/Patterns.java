package by.it.shebeko.jd02_07;

public interface Patterns {
        String OPERATION = "(?<=[^{,=+*/-])[=+*/-]";
        String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
        String VECTOR = "\\{"+SCALAR+"?(,"+SCALAR+")*}" ;
        String MATRIX = "\\{"+VECTOR+"?(,"+VECTOR+")*}";
        String VAR_NAME = "[ёЁа-яА-ЯA-Za-z]";
}
