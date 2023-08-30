package com.company.helloworld;
import java.security.SecureRandom;
import java.util.Arrays;

public class helloWorld {
    public static void main(String[] args){
        SecureRandom random = new SecureRandom();


        byte[] values = new byte[124];
        random.nextBytes(values);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(values));
        System.out.println(random.nextInt(1,2));
        System.out.println(random.nextInt(1,3));
        System.out.println(random.nextInt(1,3));
        System.out.println(random.nextInt(1,3));
        System.out.println(random.nextInt(1,3));
        


    }
}
