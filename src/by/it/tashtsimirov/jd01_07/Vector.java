package by.it.tashtsimirov.jd01_07;



class Vector extends Var {

    private final double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {

        String strVector2 = strVector.replaceAll("[^0-9. ,]", "");
        String[] strArr = strVector2.split(",");
        double[] valueD = new double[strArr.length];

        for(int i = 0; i < strArr.length; i++) {
            valueD[i] = Double.parseDouble(strArr[i]);
        }

        this.value = valueD;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

}
