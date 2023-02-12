package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UFClientClass {

    private static int[] count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        int c = 0;
        int pr = 0;
        Random r = new Random();
        while (uf.components() > 1) {
            int p = r.nextInt(n);
            int q = r.nextInt(n);
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                c += 1;
            }
            pr += 1;

        }
        int[] count = {c, pr};
        return count;
    }

    public static void main(String[] args) {

        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of objects");
            while (sc.hasNext()) {

                int o = sc.nextInt();
                int count[] = count(o);
                int total = 0;
                for (int i = 0; i < 50; i++) {
                    total += count[1];
                }
                int avg = total / 50;
                System.out.println("objects = " + o + " pair = " + avg + " connections formed " + count[0]);
                System.out.println("Enter the number of objects");
            }


        }
    }
}