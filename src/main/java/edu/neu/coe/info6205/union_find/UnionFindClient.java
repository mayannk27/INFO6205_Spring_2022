package edu.neu.coe.info6205.union_find;
import java.util.Random;
import java.util.Scanner;

public class UnionFindClient {

    public static int randomNum(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    public static int count(int sites) {
        int pairs = 0;
        UF_HWQUPC p = new UF_HWQUPC(sites);
        while (p.components() != 1) {
            p.connect(randomNum(0, sites), randomNum(0, sites));
            pairs++;
        }
        return pairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sites (n): ");
        int sites = sc.nextInt();
        int iterations=20;
        for (int i = sites; i <= 1000000000; i=2*i) {
            double total=0;
            for(int j=0;j<iterations;j++){

                total+=count(i);
            }

            double conns = total/iterations;
            System.out.println("Sites: " + i + " & Total number of connections: "+ conns);
        }
    }
}
