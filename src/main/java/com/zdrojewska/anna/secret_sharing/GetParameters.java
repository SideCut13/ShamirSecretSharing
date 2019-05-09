package com.zdrojewska.anna.secret_sharing;

import java.util.List;
import java.util.Scanner;

public class GetParameters {
    private Scanner sc = new Scanner(System.in);

    public int getN(){
        System.out.println("Enter n:");
        int n = sc.nextInt();
        return n;
    }
    public int getK(){
        System.out.println("Enter k:");
        //max value from user (size of numeric space)
        int k = sc.nextInt();
        return k;
    }
    public int getSecret(){
        System.out.println("Enter secret:");
        int secret = sc.nextInt();
        return secret;
    }

}
