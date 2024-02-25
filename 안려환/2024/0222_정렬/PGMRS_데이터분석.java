import java.util.*;
class PGMRS_데이터분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int []> list = new ArrayList<>();
        for(int i = 0; i < data.length; i ++){
            switch(ext){
                case "code":
                    if(data[i][0] < val_ext){
                        list.add(data[i]);
                    }
                    break;
                case "date":
                    if(data[i][1] < val_ext){
                        list.add(data[i]);
                    }
                    break;
                case "maximum":
                    if(data[i][2] < val_ext){
                        list.add(data[i]);
                    }
                    break;
                case "remain":
                    if(data[i][3] < val_ext){
                        list.add(data[i]);
                    }
                    break;
            }  // 특정 값보다 작은 값만을 넣어준다.
        }

        switch(sort_by){
            case "code":
                Collections.sort(list, new Comparator<int []>() {
                    @Override
                    public int compare(int [] obj1, int [] obj2){
                        return obj1[0] - obj2[0];
                    }
                });
                break;
            case "date":
                Collections.sort(list, new Comparator<int []>() {
                    @Override
                    public int compare(int [] obj1, int [] obj2){
                        return obj1[1] - obj2[1];
                    }
                });
                break;
            case "maximum":
                Collections.sort(list, new Comparator<int []>() {
                    @Override
                    public int compare(int [] obj1, int [] obj2){
                        return obj1[2] - obj2[2];
                    }
                });
                break;
            case "remain":
                Collections.sort(list, new Comparator<int []>() {
                    @Override
                    public int compare(int [] obj1, int [] obj2){
                        return obj1[3] - obj2[3];
                    }
                });
                break;
        }  // 특정 값보다 작은 값만을 넣어준다.

        int [][] answer = new int[list.size()][4];

        for(int i = 0; i < list.size(); i++){
            answer [i] = list.get(i);
        }
        return answer;
    }
}