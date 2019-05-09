package com.zdrojewska.anna.secret_sharing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrivialSecretSharing {

    private GetParameters getParameters = new GetParameters();
    private int k = 0;

    public List<Integer> secretDivision(){
        k = getParameters.getK();
        int n = getParameters.getN();
        int secret = getParameters.getSecret();

        Random rand = new Random();
        List<Integer> shares = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            int temp = rand.nextInt(k);
            shares.add(i, temp);
        }
        int calculatedSecret = secret;
        for (int i = 0; i < n-1; i++) {
            calculatedSecret -= shares.get(i);
        }
        shares.add(calculatedSecret % k);
        return shares;
    }

    public int secretCalculation(List<Integer> shares){
        int secret = 0;
        for (int i = 0; i < shares.size(); i++) {
            secret += shares.get(i);
        }
        return secret % k;
    }
}
