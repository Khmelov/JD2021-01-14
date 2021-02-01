package by.it.zevalich.jd01_08;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        for (int i = 0; i < value.length; i++) {
            this.value = value;
        }
    }

    Vector(Vector vector){
        for (int i = 0; i < vector.value.length; i++) {
            this.value = vector.value;
        }
    }

    Vector(String strVector){
        String[] strArray = strVector.split("[, ]+");
        double[] value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
        for(int i = 0; i < value.length;i++){
            this.value = value;
        }
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