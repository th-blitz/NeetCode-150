class MirrorReflection {

    private int mirrorReflectionSol1(int p, int q) {

         int gcd = gcd(p, q);
         int lcm = (p * q) / gcd;
         int numberOfBoxes =  lcm / p; //i.e LCM of p and q

         // If we have even number of boxes then we hit zero
         // Youtube Link: https://www.youtube.com/watch?v=B5LccRvDqmg

         if (numberOfBoxes % 2 == 0) return 0;


         // If we have even number of bounces then we hit two
         if ((lcm / q) % 2 == 0) return 2;
         else return 1;
     }

    private int mirrorReflectionSol2(int p, int q) {
        if (q == 0) return 0;

        int gcd = gcd(p, q);

        p = p / gcd;
        q = q / gcd;

        if (q % 2 == 0) return 0;

        if (p % 2 == 0) return 2;

        return 1; // both are odd
    }

    private int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        MirrorReflection obj = new MirrorReflection();
        int s, t;

        if (args == null || args.length == 0) {
            System.out.println("Valid Anagram Program: ");
            System.out.println("Test Case: 1");
            s = 2;
            t = 1;
            System.out.println("S = " + s + " T = " + t);
            System.out.println("Reflective Point Hit: " + obj.mirrorReflectionSol2(s, t));

            System.out.println("-------------------------------------");

            System.out.println("Test Case: 2");
            s = 3;
            t = 1;
            System.out.println("S = " + s + " T = " + t);
            System.out.println("Reflective Point Hit: " + obj.mirrorReflectionSol2(s, t));
        } else {
            System.out.println("Arguments Passed: ");
            s = Integer.parseInt(args[0]);
            t = Integer.parseInt(args[1]);
            System.out.println("S = " + s + " T = " + t);
            System.out.println("Reflective Point Hit: " + obj.mirrorReflectionSol2(s, t));
        }
    }
}