package com.zdrojewska.anna.secret_sharing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

//TO DO: REFACTOR THIS CODE AND MOVE TO OTHER CLASS
public class App 
{
    public static int generateP(int s, int n){
        //generuj liczbę pierwszą p taką ze p > n i p > s
        Random rnd = new Random();
        int x = 0;
        while(!isPrime(x)){
            if(x < s || x <n)
            {
                x = rnd.nextInt(100)+ 0;
            }
        }
        //podaj t, n
        return x;
    }

    public static boolean isPrime(Integer x){
        if(x == 0 || x == 4){
            return false;
        }
        for (int i = 2; i <= x/2; i++) {
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> wyznaczA(int t){
        List<Integer> wyznaczoneA = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < t-1; i++) {
            int temp = rand.nextInt();
            wyznaczoneA.add(i, temp);
        }

        return wyznaczoneA;
    }
    public static List<Integer> wyznaczUdzialy(int s, List<Integer> wyznaczoneA, int p){
        List<Integer> udzialy = new ArrayList<>();
        int x = 0;
        int a = 0;
        for (int i = 0; i < wyznaczoneA.size(); i++) {
            a += wyznaczoneA.get(i);
            x = s + a * i % p;
            udzialy.add(i, x);
        }
        return udzialy;
    }

    public static int rozwiazanie(List<Integer> udzialy, int p, int t){
        int s = 0;
        for (int i = 0; i < t-1; i++) {
            s += udzialy.get(i);
        }
        int x0 = 0;
        int x = 0;
        for (int i = 0; i < t-1; i++) {
            x *= (x0 - i)/(x - i+1);
        }
        int rozw = s * (x % p);
        return rozw;

    }

    public static void main( String[] args )
    {
        TrivialSecretSharing trivialSecretSharing = new TrivialSecretSharing();
        List<Integer> shares = trivialSecretSharing.secretDivision();
        int secret = trivialSecretSharing.secretCalculation(shares);
        System.out.println(secret);

       /* //===========================================
        System.out.println("Podaj sekret:");
        int s = sc.nextInt();
        System.out.println("Podaj n:");
        int n1 = sc.nextInt();
        //t musi byc mniejsze lub równe n
        System.out.println("Podaj t:");
        int t = sc.nextInt();
        while(t > n1){
            t = sc.nextInt();
        }

        int p = generateP(s, n1);
        List<Integer> wyznaczAList = wyznaczA(t);
        List<Integer> udzialy = wyznaczUdzialy(s, wyznaczAList, p);
        System.out.println(udzialy.toString());
        int rozw = rozwiazanie(udzialy, p, t);*/



    }


}
