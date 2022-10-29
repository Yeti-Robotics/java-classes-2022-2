public class Main {
    public static void main(String[] args) {
        int number = 5;
        double decimal = 14;
        boolean ducks = false;
        char letter = 'm';
        String word = "moo";
        System.out.println(word);
        System.out.println("Hello world!");

        int uno = 1;
        int dos = 2;
        double pi = 3.14;
        double sum = uno + pi;
        System.out.println(5 / 2.0);
        System.out.println(57001 % 2);

        String boom = "7";
        String pow = "4";
        System.out.println(boom + pow + "boom");
        //The next line will crash the program
//        System.out.println(5 / 0);
        System.out.println(Math.sqrt(9));
        System.out.println(Math.pow(9, -2));
        System.out.println(Math.abs(-27));
        System.out.println(Math.PI);

        if (uno > dos || dos % uno == 0) {
            System.out.println("Something bad happened!");
        } else {
            System.out.println("It Worked!");
        }

        boolean a = true;
        boolean b = false;
        System.out.println(!a == b);

        int[] weather = {72, 64, 68, 73, 74, 27};
        System.out.println(weather[1]);
        weather[1] = 57;
        System.out.println(weather[1]);
        System.out.println(weather[5]);

        for(int i = 0; i < weather.length; i++) {
            weather[i] += 5;
        }

        for(int i = 0; i < weather.length; i++) {
            System.out.println(weather[i]);
        }

        System.out.println("We're curling hair!");
        boolean hairIsCurly = false;
        int numberOfCurls = 0;
        while(!hairIsCurly) {
            numberOfCurls++;
            if(numberOfCurls >= 15) {
                hairIsCurly = true;
            }
            System.out.println(numberOfCurls);
        }
    }
}