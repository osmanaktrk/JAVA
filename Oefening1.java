import java.sql.SQLOutput;
import java.util.Scanner;

public class Oefening1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int grootfruitbak = 0;
        double totaalPrijs=0;
        double totaalPrijsBTW = 0;




        do {
            System.out.print("Hoeveel stukken wil je kopen (5-20)?: ");
            grootfruitbak = sc.nextInt();
            if (grootfruitbak < 5 || grootfruitbak > 20) {
                System.out.println("Het moet tussen 5 en 20 zijn");
            }
        }while (grootfruitbak < 5 || grootfruitbak > 20);

        String [] keuzes = new String[grootfruitbak];


        System.out.println("Keuzes: 'Grone Appel', 'Rode Appel', 'Peer'");
        System.out.println("Om grone appel te kiezen geef 'GA' in");
        System.out.println("Om rode appel te kiezen 'RA' in");
        System.out.println("Om peer te kiezen geef 'P' in");
        totaalPrijs = vulFruitBak(keuzes, totaalPrijs, grootfruitbak, sc);
        totaalPrijsBTW = berekenenTotaalFruitBakBTW(totaalPrijs,totaalPrijsBTW);
        System.out.println("De waarde van de mand in: "+totaalPrijs+" Euro");
        System.out.println("Inclusief met btw is dit: "+totaalPrijsBTW+" Euro");




    }

    public static double vulFruitBak(String [] keuzes, double totaalPrijs, int groodfruidbak , Scanner sc){
        String keuze;
        int teller = 0;
        do {
            System.out.print("Welke stukken fruit pluk je? (keuze: GA, RA, P): ");
            keuze = sc.nextLine();

            if (!keuze.equals("GA") && !keuze.equals("RA") && !keuze.equals("P")) {
                System.out.println("Foutive keuze, probier opnieuw");

            } else {
                keuzes[teller] = keuze;
                teller++;
                totaalPrijs =berekenentotaalfruitbak(keuze, totaalPrijs);

            }
        }while (teller!=groodfruidbak);



        return totaalPrijs;


    }

    public static double berekenentotaalfruitbak(String keuze, double totaalPrijs){

        double prijsRodeAppel = 1;
        double prijsGroneAppel = 0.5;
        double prijsPeer = 1.5;

        switch (keuze){

            case "GA":
                totaalPrijs+=prijsGroneAppel;

                break;


            case "RA":
                totaalPrijs+=prijsRodeAppel;

                break;



            case "P":
                totaalPrijs+=prijsPeer;
                break;





        }


        return totaalPrijs;
    }

    public static double berekenenTotaalFruitBakBTW(double totaalPrijs, double totaalPrijsBTW){

        totaalPrijsBTW =totaalPrijs+ ((totaalPrijs/100)*21);


        return totaalPrijsBTW;
    }




}
