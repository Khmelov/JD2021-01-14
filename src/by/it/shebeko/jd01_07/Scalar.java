package by.it.shebeko.jd01_07;

class Scalar extends Var{

    private double value;  //создаем приватное поле, чтобы создать три конструктора на основе этого поля

    Scalar(double value) {   // 1 на вход конструктора дабл
        this.value = value;  //отдает дабл
    }
    Scalar(String str){           // 2 на вход конструктора строка
        this.value = Double.parseDouble(str); //эту строку преобразуем в дабл
    }
    Scalar(Scalar scalar){       // 3 на вход конструктор принимает экземпляр класса скаляр
        this.value = scalar.value;

    }

    @Override
    public String toString() {
        return Double.toString(value);
    }



}


