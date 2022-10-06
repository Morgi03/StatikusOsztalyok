package hu.petrik.statikusosztalyok;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public final class Veletlen {
    private Veletlen() {
    }

    private static final Random rnd = new Random();
    private static final List<String> vezNevek = feltolt("files/veznev.txt");
    private static final List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static final List<String> noiiKerNevek = feltolt("files/noikernev.txt");


    private static List<String> feltolt(String faljnev) {
        List<String> lista = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(faljnev));
            while (file.hasNext()) {
                String sor = file.nextLine();
                lista.add(sor);
            }
            file.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public static int velEgesz(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char velKarakter(char min, char max) {
        return (char) velEgesz(min, max);
    }

    public static String velVezetekNev() {
        return vezNevek.get(rnd.nextInt(vezNevek.size()));
    }

    /**
     * Véletlen magyar keresztnév generálása
     *
     * @param nem A generált név neme. Férfi esetén true, Nő esetén false.
     * @return A generált keresztnév
     */
    public static String velKeresztnev(boolean nem) {
        String keresztnev;
        if (nem) {
            keresztnev = velFerfiKeresztNev();
        } else {
            keresztnev = velNoiKeresztNev();
        }
        return keresztnev;
    }

    private static String velFerfiKeresztNev() {
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    private static String velNoiKeresztNev() {
        return noiiKerNevek.get(rnd.nextInt(noiiKerNevek.size()));
    }

    /**
     * Véletlen magyar név generálása
     *
     * @param nem A generált név neme. Férfi esetén true, Nő esetén false.
     * @return A generált név
     */
    public static String velTeljesNev(boolean nem) {
        return velVezetekNev() + " " + velKeresztnev(nem);
    }

    public static LocalDate velDatum(int ev1, int ev2) {
        int min = (int) LocalDate.of(ev1, 1, 1).toEpochDay();
        int max = (int) LocalDate.of(ev2+1, 1, 1).toEpochDay();
        long RandomNap = min + rnd.nextInt(max - min);

        LocalDate datum = LocalDate.ofEpochDay(RandomNap);
        return datum;
    }

    private static int sorszam = 0;
    public static String velEmail(String nev){
        nev = nev.replaceAll("[^\\p{ASCII}]", "");
        String[] temp = nev.toLowerCase().split(" ");
        sorszam++;
        return temp[0]+temp[1]+sorszam+"@gmail.com";
    }
    public static String velMobil(){
        return String.format("+36 (%d) %d-%d-%d",mobilSzolgaltatoRandom(),velEgesz(100,999),velEgesz(10,99),velEgesz(10,99));
    }
    private static int mobilSzolgaltatoRandom(){
        int num = velEgesz(1,4);
        switch (num){
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 50;
            case 4:
                return 70;
            default:
                return 20;
        }
    }
}
