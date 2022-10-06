package hu.petrik.statikusosztalyok;

public class Main {
  //  int nemStatikusAdattag;
  //  static int statikusTag;

    public static void main(String[] args) {
       /*
        Main obj = new Main();
        System.out.println(obj.nemStatikusAdattag);
        System.out.println(Main.statikusTag);
       */
        for (int i = 0; i < 100; i++) {
            System.out.println(Veletlen.velEgesz(5,10));
        }
    }

}
