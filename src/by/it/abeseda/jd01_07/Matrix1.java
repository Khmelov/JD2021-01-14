package by.it.abeseda.jd01_07;

public class Matrix1 extends Var{

    private double [][] value;


    // конструктор двумерный массив двумерный массив

    Matrix1(double[][] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            st.append("{");
            for (int j = 0; j < value.length ; j++) {
                st.append(value[i][j]);
                if (j< value.length-1) {
                    st.append(",");}
            }
            st.append("}");
            if (i< value.length-1){
                st.append(",");
            }
        }
        st.append("}");
        return st.toString();
    }

    // из двумерного массива в строку
    // спросить у Александра про matcher.group - т.к. не разобралась

    Matrix1(String strMatrix) {
        String str=strMatrix.replace("{{","").
                replace("}}","")
                .replace(" ","").trim();
        String[] strArray=str.split("[},{]+");

        String [][] middleArray= new String[2][strArray.length/2];
        for (int i = 0; i < strArray.length-2; i++) {
            middleArray[0][i]=strArray[i];
            middleArray[1][i]=strArray[i+2];
        }

        double[][] finishArray = new double[2][2];
        for (int i = 0; i < middleArray.length; i++) {
            for (int j = 0; j < middleArray[i].length; j++) {
                finishArray[i][j]=Double.parseDouble(middleArray[i][j]);
            }
        }
        this.value=finishArray;
    }

    //ничего не понятный объект в объект

    Matrix1(Matrix1 matrix){
        this.value=matrix.value;
    }




}



