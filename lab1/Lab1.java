public class Lab1 {
    public static void main(String[] args) {
        int k = 8, l = 18;
//      k = количество элементов в массиве a, l = количество элементов в массиве x
        int f = 8, u = 18;
//      f = количество строк, u = количество столбцов в массиве с

        long[] a = new long[k];
        double[] x = new double[l];
        double[][] c = new double[f][u];

        int j = 2;
        for (int i = 0;i<k;i++){
            a[i] = j;
            j+=2;
        }
        for (int i = 0;i<l;i++) x[i]= GetRandom(-6.0, 4.0);

        for (int i = 0;i<f;i++){
            for (j = 0;j<u;j++){
                double tmp, tmp1;
                if (a[i]==4){
                    tmp = Math.pow(x[j], x[j])/Math.PI;
                    tmp = Math.pow(tmp,2);
                    tmp1 = Math.pow(x[j], 1/(4*x[j])) / 2;
                    tmp1 = Math.pow(tmp1, 2) + (3/4);
                    tmp1 = (2/3) / tmp1;
                    tmp = Math.pow(tmp,tmp1);
                }
                else
                    if (a[i]== 6 || a[i]== 8 || a[i]== 10 || a[i]== 14){
                        tmp = (Math.pow(Math.E,Math.sin(x[j])) - 1)/0.25;
                        tmp = Math.pow(tmp,2);
                    }
                    else{
                        tmp1 = (Math.pow(Math.E, x[j])/2)/3;
                        tmp1 = Math.pow(tmp1,2);
                        tmp = Math.pow(Math.E,tmp1) + 3;
                        tmp1 = (2/3)/ (Math.tan(x[j])-1);
                        tmp1 = Math.pow(0.25*(x[j]+1), tmp1);
                        tmp1 = Math.cos(tmp1);
                        tmp = tmp/tmp1;
                        tmp = Math.pow(tmp,3);
                    }
                c[i][j] = tmp;
            }
        }
        for (int i = 0;i<f;i++){
            for (j = 0;j<u;j++){
                System.out.printf("%.4f ", c[i][j]);
            }
            System.out.println();
        }
    }
    public static double GetRandom(double min, double max)
    {
        max -= min;
        return  (Math.random() * ++max) + min;
    }
}
