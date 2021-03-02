package by.it.nakhankov.jd02_04;

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
