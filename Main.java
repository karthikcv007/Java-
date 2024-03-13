public class Main {
    public static void main(String[] args){
        System.out.println("Matrix 1");
        Matrix obj1 = new Matrix();
        obj1.setElements();
        System.out.println("Matrix 2");
        Matrix obj2 = new Matrix();
        obj2.setElements();
        Matrix obj3 = new Matrix(obj1.getRows(), obj1.getColumns());
        obj3 =  obj3.add(obj1,obj2);
        System.out.println("Addition");
        obj3.getElements();
        Matrix obj4 = new Matrix(obj1.getRows(),obj1.getColumns());
        obj4 = obj4.diff(obj1,obj2);
        System.out.println("Difference");
        obj4.getElements();
        Matrix obj5 = new Matrix(obj1.getRows(),obj2.getColumns());
        obj5 = obj5.product(obj1,obj2);
        System.out.println("Multiplication");
        obj5.getElements();
        Matrix obj6 = new Matrix(obj1.getColumns(), obj1.getRows());
        obj6 = obj6.transpose(obj1);
        System.out.println("Transpose");
        obj6.getElements();
        String value = obj6.toString(obj1);
        System.out.println("String");
        System.out.println(value);

    }
}