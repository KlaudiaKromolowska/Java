package MatrixPac;
import MatrixPac.Matrix;
import org.junit.Test;
import java.util.Random;

import static junit.framework.TestCase.*;

public class MatrixT {
    @Test
    public void testConstructorMatrix() throws Exception{
        double[][] tab = {{1, 2, 3},{4,5,6}};
        Matrix a = new Matrix(tab);
        assertEquals(a.cols, 3);
        assertEquals(a.rows, 2);
    }

    @Test
    public void asArray() throws Exception{
        double[][] tab = {{1, 2, 3},{4,5,6}};
        Matrix a = new Matrix(tab);
        for (int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                assertEquals(tab[i][j], a.data[a.cols*i + j], 0);
            }
        }
    }

    @Test
    public void get() throws Exception{
        double[][] tab =  {{1, 2, 3},{4,5,6}};
        Matrix a = new Matrix(tab);
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                assertEquals(tab[i][j], a.get(i,j), 0);
            }
        }
    }

    @Test
    public void set() throws Exception{
        Matrix a = new Matrix(2, 3);
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                a.set(i, j, i+j);
                assertEquals(i+j, a.data[a.cols*i+j], 0);
            }
        }
    }
    @Test
    public void testToString() throws Exception {
        String s= "[[1.0,2.3,4.56], [12.3,  45, 21.8]]";
        s= s.replaceAll("(\\[|\\]|\\s)+","");
        String[] t = s.split("(,)+");
        for(String x:t){
            System.out.println(String.format("\'%s\'",x ));
        }

        double[]d=new double[t.length];
        for(int i=0;i<t.length;i++) {
            d[i] = Double.parseDouble(t[i]);
        }

        double arr[][]=new double[1][];
        arr[0]=d;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    @Test
    public void testReshape() throws Exception {
        double[][] tab =  {{1, 2, 3},{4,5,6}};
        Matrix a = new Matrix(tab);
        double[][] tab2 =  {{5, 8},{4,5}, {1, 2}};
        Matrix b = new Matrix(tab2);
        assertEquals(a.cols*a.rows, b.cols*b.rows);
    }

    @Test
    public void testAdd() throws Exception {
        double[][] tab =  {{1, 2, 3},{4,5,6}};
        Matrix a = new Matrix(tab);
        Matrix b = new Matrix(tab);
        Matrix c = a.add(b);
        for (int i=0; i<a.rows; i++){
            for (int j=0; j<a.rows; i++){
                System.out.println(c.data[i+j]);
                assertEquals(a.data[i*a.cols+j], c.data[i*c.cols+j]);
            }
        }
    }
    @Test
    public void testSub() throws Exception {

    }
    @Test
    public void testMul() throws Exception {

    }
    @Test
    public void testDiv() throws Exception {

    }
    @Test
    public void testDot() throws Exception {

    }
    @Test
    public void testForbenius() throws Exception {

    }
    @Test
    public void testShow() throws Exception {

    }
    @Test
    public void testMax() throws Exception {

    }
    @Test
    public void testGetSubmatrix() throws Exception {
        Random generator = new Random();
        int m = generator.nextInt(100)+1;
        int n = generator.nextInt(100)+1;


        double[][] d = new double[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                d[i][j] = 10*generator.nextDouble()-5;
            }
        }

        Matrix mat = new Matrix(d);

        int fromRow;
        int toRow;
        int fromCol;
        int toCol;
        for(int i=0; i<100; i++){
            fromRow = generator.nextInt(2*m+m+1)-m;
            fromCol = generator.nextInt(2*n+n+1)-n;

            toRow = generator.nextInt(2*m+m+1)-m;
            toCol = generator.nextInt(2*n+n+1)-n;

            try{
                mat.getSubmatrix(fromRow,toRow,fromCol,toCol);
            }catch(RuntimeException err){
                assertEquals(fromRow>=toRow || fromCol>=toCol || toRow>mat.rows || toCol>mat.cols
                        || fromRow<0 || fromCol<0 || toRow<0 || toCol<0, true);
            }
        }
    }
}