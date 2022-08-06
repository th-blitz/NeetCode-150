class PoorPigs {
    // T: O(1), S: O(1)
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int periods = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(periods));
    }

    public static void main(String[] args) {
        PoorPigs obj = new PoorPigs();
        int buckets;
        int minutesToDie;
        int minutesToTest;

        if (args == null || args.length == 0) {
            System.out.println("Poor Pigs Program: ");
            System.out.println("Test Case: 1");
            buckets = 1000;
            minutesToDie = 15;
            minutesToTest = 60;
            System.out.println("Buckets = " + buckets + " Minutes to Die = " + minutesToDie + " Minutes to Test = " + minutesToTest);
            System.out.println("Minimum number of Pigs: " + obj.poorPigs(buckets, minutesToDie, minutesToTest));

            System.out.println("-------------------------------------");
        }
    }
}