import java.util.*;

public class PGMRS_캐시 {
    public static void main(String[] args) {
//        String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String [] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        int cacheSize = 3;
        cacheRun cacheRun = new cacheRun();
        cacheRun.cacheRun(cities,cacheSize);
        System.out.println(cacheRun.result);
    }
}

class cacheRun{
    public int result = 0;
    public void cacheRun(String [] cities, int cacheSize){
        List<String>  list = new ArrayList<>();
        if(cacheSize == 0){
            for (int i = 0; i < cities.length; i++) {
                result += 5;
            }
            return;
        }

        for (int i = 0; i < cities.length; i++) {
            if(findIndex(list,cities[i])>-1){
                result += 1;
                list.remove(findIndex(list,cities[i]));
                list.add(cities[i]);
            }else {
                System.out.println(cities[i]);
                result += 5;
                if(list.size() == cacheSize){
                    list.remove(0);
                    list.add(cities[i]);
                }else {
                    list.add(cities[i]);
                }

            }
        }
    }

    public int findIndex(List<String> list , String city){
        for (int i = 0; i < list.size(); i++) {
            if(city.equals(list.get(i))){
                System.out.println(i);
                return i;
            }

        }
        return -1;
    }

}
