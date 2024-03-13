
import java.util.Scanner;
public class Matrix {
    private int rows;
    private int columns;
    private double[][] data;
    private String name;
    public void setRows(int rows) {
        this.rows = rows;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
    public void setData(double[][] data) {
        this.data = data;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getColumns() {
        return columns;
    }
    public double[][] getData() {
        return data;
    }
    public int getRows() {
        return rows;
    }
    public String getName() {
        return name;
    }

    Matrix (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of rows :");
        rows = sc.nextInt();
        System.out.print("Enter no of Columns :");
        columns = sc.nextInt();
        data = new double[rows][columns];
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                data[i][j] = 0;
            }
        }
    }
    Matrix(int rows,int columns){
        this.rows=rows;
        this.columns=columns;
        data = new double[rows][columns];
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                data[i][j] = 0;
            }
        }
    }

    public void setElements(){
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                System.out.println("Enter The["+(i+1)+"]["+(j+1)+"]th Element:");
                double temp = sc.nextDouble();
                data[i][j] = temp;
            }
        }
    }
    public void getElements(){
        for(int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix obj1,Matrix obj2){
        Matrix result = new Matrix(obj1.rows,obj1.columns);
        if(obj1.rows!=obj2.rows || obj1.columns != obj2.columns){
            System.out.println("Addition Not possible");
            //System.exit(0);
        }else{
            for (int i=0;i<rows;i++){
                for (int j=0;j<columns;j++){
                    result.data[i][j] = obj1.data[i][j] + obj2.data[i][j];
                }
            }
        }
        return result;
    }
    public Matrix diff(Matrix obj1,Matrix obj2){
        Matrix result = new Matrix(obj1.rows,obj1.columns);
        if(obj1.rows!=obj2.rows || obj1.columns != obj2.columns){
            System.out.println("Difference Not possible");
            //System.exit(0);
        }else{
            for (int i=0;i<rows;i++){
                for (int j=0;j<columns;j++){
                    result.data[i][j] = obj1.data[i][j] - obj2.data[i][j];
                }
            }
        }
        return result;
    }
    public Matrix product(Matrix obj1,Matrix obj2) {
        Matrix result = new Matrix(obj1.rows, obj2.columns);
        if (obj1.columns != obj2.rows) {
            System.out.println("Multiplication Not possible");
            //System.exit(0);
        } else {
            for (int i = 0; i < obj1.rows; i++) {
                for (int j = 0; j < columns; j++) {
                    for (int k = 0; k < obj1.columns; k++) {
                        result.data[i][j] += obj1.data[i][k] * obj2.data[k][j];
                    }
                }
            }
        }
        return result;
    }

    public Matrix transpose(Matrix obj1){
        Matrix result = new Matrix(obj1.columns,obj1.rows);
        for(int i=0;i<result.rows;i++){
            for(int j=0;j<result.columns;j++){
                result.data[i][j] = obj1.data[j][i];
            }
        }
        return result;
    }
    public String toString(Matrix obj1){
        name = " ";
        for(int i=0;i<obj1.rows;i++){
            for(int j=0;j<obj1.columns;j++){
                String temp = String.valueOf(obj1.data[i][j]);
                name = name.concat(temp.concat(" "));
            }
        }
        return name;
    }
}
