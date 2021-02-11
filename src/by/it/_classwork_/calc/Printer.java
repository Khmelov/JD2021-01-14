package by.it._classwork_.calc;

class Printer {
    public void print(Var result) {
        if (result != null) {
            System.out.println(result);
        }
    }

    public void printEx(CalcException e) {
        System.out.println(e.getMessage());
    }
}
