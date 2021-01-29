package by.it.abeseda.jd01_07;

class Vector extends Var{

    private double [] value;


    Vector(double[] value) {
        this.value = value;}

        @Override
    public String toString() {
        StringBuilder st=new StringBuilder("{");
        String delimetr="";
        for (double element: value) {
            st.append(delimetr).append(element);
            delimetr=", ";
        }
        st.append("}");
        return st.toString();
    }

    Vector(String strVector) {
        String line = strVector.replace("{","").replace("}","")
                .trim();
        String[] mid = line.split("[,]+");
        double[] end = new double[mid.length];
        for (int i = 0; i < mid.length; i++) {
            end[i] = Double.parseDouble(mid[i]);
        }
        this.value=end;
    }

    Vector(Vector vector){
       this.value=vector.value;
   }
}
