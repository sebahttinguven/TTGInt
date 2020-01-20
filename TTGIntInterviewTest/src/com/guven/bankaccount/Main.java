package com.guven.bankaccount;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

   

    public static void main(String[] args) {
       
    	TTGIntBankAccount account= new TTGIntBankAccount();
        List<String> satir =  account.dosyaOku();
        List<Map<String, Integer>> sonucMap =account.girisDegerleri(satir);
        account.sonuc(sonucMap);
    }

}