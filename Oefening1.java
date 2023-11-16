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

        vulFruitbak(grootfruitbak,keuzes);

        totaalPrijs = berekenenTotaalFruitBak(keuzes);
        System.out.println("De waarde van je mand is: "+totaalPrijs+" Euro");
        totaalPrijsBTW = berekenenTotaalFruitBakBtw(totaalPrijs);
        System.out.println("Inclusief met btw is dit: "+totaalPrijsBTW+" Euro");







    }


    public static void vulFruitbak(int grootfruitbak, String[] keuzes){
        Scanner sc = new Scanner(System.in);
        String keuze;


        System.out.println("Keuzes: 'Grone Appel', 'Rode Appel', 'Peer'");
        System.out.println("Om grone appel te kiezen geef 'GA' in");
        System.out.println("Om rode appel te kiezen 'RA' in");
        System.out.println("Om peer te kiezen geef 'P' in");


        for (int i = 0; i < grootfruitbak; i++){


            do {
                System.out.println("Welke stukken fruit pluk je? (keuze: GA, RA, P)");
                System.out.print("Keuze"+(i+1)+") ");
                keuze = sc.nextLine();

                if (!keuze.equals("GA") && !keuze.equals("RA") && !keuze.equals("P")) {
                    System.out.println("Foutive keuze, probier opnieuw");
                }

            } while (!keuze.equals("GA") && !keuze.equals("RA") && !keuze.equals("P"));

            keuzes[i] = keuze;

        }




    }

    public static double berekenenTotaalFruitBak(String [] keuzes){

        double rodeappel = 0;
        double groeneappel = 0;
        double peer = 0;
        double totaal = 0;



        for (int i = 0; i<keuzes.length; i++){

            switch (keuzes[i]) {


                case "GA":
                    groeneappel++;

                    break;


                case "RA":

                    rodeappel++;

                    break;


                case "P":

                    peer++;

                    break;

            }



        }

        totaal += (rodeappel*(1))+(groeneappel*(0.5))+(peer*(1.5));




        return totaal;
    }

    public static double berekenenTotaalFruitBakBtw(double totaalPrijs){

        double totaalbtw = totaalPrijs+(totaalPrijs/100)*21;

        return totaalbtw;
    }



}
