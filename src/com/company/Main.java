package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    //var1 x8 + x4 + x3 + x2 + 1

    public static void main(String[] args) {
        ArrayList<String> boolList = new ArrayList<>();
        String initialState = "001101110";
        String polynom      = "101110001";
        print("Начальное состояние: " + initialState);
        boolean[] initialStateBool = toBoolArr(initialState);
        boolean[] polynomBool = toBoolArr(polynom);
//        print(toString(arr));
        for (int i = 0; i < 255; i++) { // 2^8 - 1
            boolean[] newArr = new boolean[initialState.length()];
            boolList.add(toString(initialStateBool));
            print(toString(initialStateBool) + "\t" + Integer.parseInt(toString(initialStateBool), 2));
            for (int j = 0; j < initialState.length() - 1; j++) {
                newArr[j] = initialStateBool[j + 1];
            }
//            print(toString(newArr));
            boolean newBit = getNewBit(initialStateBool, polynomBool);
            newArr[initialState.length() - 1] = newBit;
            initialStateBool = newArr;
            if (boolList.indexOf(toString(initialStateBool)) != -1) {
                print("Период: " + boolList.size());
                break;
            }
        }
    }

    private static boolean getNewBit(boolean[] arr, boolean[] polynom) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ (arr[i] && polynom[i]);
        }
        return result;
    }

    private static boolean[] toBoolArr(String str) {
        boolean[] result = new boolean[str.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = str.charAt(i) == '0' ? false : true;
        }
        return result;
    }

    private static String toString(boolean[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] == false ? "0" : "1";
        }
        return result;
    }

    private static void print(String text) {
        System.out.println(text);
    }
}