/*
 *    Rizat.Orazalina created on 14.12.2021
 */

package thread;

import java.util.Arrays;

public class Main {
    public static final int SIZE = 10_000_000;
    public static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }


    public static void firstMethod() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }


    public static void splitAndMergeExample(float[] initialArray) {

       // System.out.println(Arrays.toString(initialArray));

        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];

        System.arraycopy(initialArray, 0, leftHalf, 0, HALF);
        System.arraycopy(initialArray, HALF, rightHalf, 0, HALF);

       // System.out.println(Arrays.toString(leftHalf));
       // System.out.println(Arrays.toString(rightHalf));

        float[] mergedArray = new float[SIZE];

        Thread firstThread = new Thread(() -> {
            System.arraycopy(leftHalf, 0, mergedArray, 0, HALF);
        });

        Thread secondThread = new Thread(() -> {
            System.arraycopy(rightHalf, 0, mergedArray, HALF, HALF);
        });
        firstThread.start();
        secondThread.start();

       // System.out.println(Arrays.toString(mergedArray));
    }


    public static void secondMethod() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        splitAndMergeExample(arr);
        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }


}
