package edu.neu.coe.info6205.sort.elementary;

import com.google.common.collect.Lists;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BenchmarkInsertionSort {
    private static final int REPETATION = 200;
    private static final int START = -500;
    private static final int END = 500;
    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        final List<Integer[]> randNumList = Lists.newArrayList(

                rndmNmArrGen(20), rndmNmArrGen(40), rndmNmArrGen(80), rndmNmArrGen(160), rndmNmArrGen(320), rndmNmArrGen(640), rndmNmArrGen(1280), rndmNmArrGen(2560), rndmNmArrGen(5120), rndmNmArrGen(10240), rndmNmArrGen(20480), rndmNmArrGen(40960)


        );

        for (Integer[] randomlyGenNo : randNumList) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("No of element N: " + randomlyGenNo.length);
            Arrays.sort(randomlyGenNo, Collections.reverseOrder());
            benchmarkCallTimerFunction("Array In Reverse Order", randomlyGenNo);
            benchmarkCallTimerFunction("Array In Random Order", randomlyGenNo);
            Arrays.sort(randomlyGenNo, 0, (randomlyGenNo.length) / 2);
            benchmarkCallTimerFunction("Array In Partial Order", randomlyGenNo);
            Arrays.sort(randomlyGenNo);
            benchmarkCallTimerFunction("Array In Order", randomlyGenNo);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++1");
        }
    }

    private static Integer[] rndmNmArrGen(int k) {
        Integer[] randomNumbers = new Integer[k];

        for (int j = 0; j < k; j++) {
            randomNumbers[j] = RANDOM.nextInt(END + 1 - START) + START;
        }
        return randomNumbers;
    }

    public static void benchmarkCallTimerFunction(final String description, final Integer[] inArr) {
        final Consumer<Integer[]> insertionSort = InsertionSort::sort;
        final Supplier<Integer[]> input = () -> Arrays.copyOf(inArr, inArr.length);

        final Benchmark_Timer<Integer[]> benchmark_timer = new Benchmark_Timer<>(description, null, insertionSort, null);
        final double meanOfArraySortingTimeInMilliSeconds = benchmark_timer.runFromSupplier(input, REPETATION);

        System.out.println(description + " : mean sort time (in ms): " + meanOfArraySortingTimeInMilliSeconds);
    }


}
