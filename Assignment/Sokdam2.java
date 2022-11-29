class SharedSokdam {
    public synchronized void Sokdam(String name, String sokdam){
        String[] sokdamArray = sokdam.split(" ");
        for (int i = 0; i < sokdamArray.length; i++) {
            System.out.println(name+" : "+sokdamArray[i]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

class SokdamThread extends Thread {
    private String name;
    private String sokdam;
    private SharedSokdam sokthread;

    public SokdamThread(String name, String sokdam, SharedSokdam sokthread){
        this.name = name;
        this.sokdam = sokdam;
        this.sokthread = sokthread;
    }

    public void run(){
        sokthread.Sokdam(name, sokdam);
    }

}

public class Sokdam2 {
    public static void main(String[] args) {
        SharedSokdam sok = new SharedSokdam();
        new SokdamThread("속담1","Time is money", sok).start();
        new SokdamThread("속담2","Time is money", sok).start();

    }
}
