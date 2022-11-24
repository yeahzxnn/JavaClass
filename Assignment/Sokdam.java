public class Sokdam {
    public static void main(String[] args) {
        String Sokdam = "Time is money";
        String[] SokdamArray = Sokdam.split(" ");

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < SokdamArray.length; i++) {
                    System.out.println("속담1 : "+SokdamArray[i]);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
        for (int i = 0; i < SokdamArray.length; i++) {
            System.out.println("속담2 : "+SokdamArray[i]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
