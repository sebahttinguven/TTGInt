package bankAccount;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

   

    public static void main(String[] args) {
       
    	TTGIntAccountQuest3 account= new TTGIntAccountQuest3();
        List<String> satir =  account.dosyaOku();
        List<Map<String, Integer>> sonucMap =account.girisDegerleri(satir);
        account.sonuc(sonucMap);
    }

}