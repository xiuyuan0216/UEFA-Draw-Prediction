import java.util.*;
public class EuropeanChampionTrialTwo {
    public static void main(String[] args){
        String[] two = {"PSG","Atletico Madrid","Sporting CP","Inter Milan","Benfica","Villarreal","Salzburg","Chelsea"};
        String[] one = {"Man City","Liverpool","Ajax","Real Madrid","Bayern Munchen","Man United","Lille","Juventus"};
        int[][] AdjMatrix = {{0,1,1,1,1,1,0,1},
                             {1,0,1,0,1,1,1,1},
                             {1,1,0,1,1,1,1,1},
                             {1,1,1,0,1,1,1,0},
                             {1,1,1,1,0,1,1,1},
                             {1,1,1,0,1,0,1,1},
                             {1,1,1,1,1,1,0,1},
                             {0,0,1,1,1,0,1,0}};
        String[] list = {"0","1","2","3","4","5","6","7"};
        List<String> allPermutations = permutations(Arrays.asList(list));
        int count1 = 0;
        int count2 = 0;
        for(String a:allPermutations){
            if(AdjMatrix[0][Integer.parseInt(a.substring(0,1))]==1 
            && AdjMatrix[1][Integer.parseInt(a.substring(1,2))]==1 
            && AdjMatrix[2][Integer.parseInt(a.substring(2,3))]==1
            && AdjMatrix[3][Integer.parseInt(a.substring(3,4))]==1
            && AdjMatrix[4][Integer.parseInt(a.substring(4,5))]==1
            && AdjMatrix[5][Integer.parseInt(a.substring(5,6))]==1
            && AdjMatrix[6][Integer.parseInt(a.substring(6,7))]==1
            && AdjMatrix[7][Integer.parseInt(a.substring(7,8))]==1){
                count1++;
                if(Integer.parseInt(a.substring(7,8))==7){
                    count2++;
                }
            }
            
        }
        System.out.println((double)count2/count1);
    }
    public static List<String> permutations(List<String> a){
        List<String> result = new ArrayList<>();
        if(a.size() == 1){
            result.add(a.get(0));
            return result;
        }else{
            for(String k: a){
                List<String> aCopy = new ArrayList<>();
                for(String n:a){
                    aCopy.add(n);
                }
                aCopy.remove(k);
                List<String> lastResult = permutations(aCopy);
                List<String> NowResult = new ArrayList<String>();
                for(int i = 0; i<lastResult.size();i++){
                    NowResult.add(lastResult.get(i) + k);
                }
                result.addAll(NowResult);
            }
            return result;
        }

    }
}
