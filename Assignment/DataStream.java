import java.io.*;

public class DataStream {
    public static void main(String[] args) {

        String data = "syj:\\Temp\\double.txt";
        double[] num = {1.0,2.0,3.0,4.0,5.0};
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(data));
            DataInputStream dis = new DataInputStream(new FileInputStream(data));) {

            for(double x : num)
                dos.writeDouble(x);
            dos.flush();

            for(int i=0; i<5; i++)
                System.out.println(dis.readDouble());
        } catch(IOException e) {}

    }
}
