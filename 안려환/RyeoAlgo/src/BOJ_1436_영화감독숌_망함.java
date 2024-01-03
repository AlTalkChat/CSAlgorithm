import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌_망함 {
    private static int pre = -1;  // 6만나기 전까진 여기를 카운트해서 올리고
    private static int post = 0;  // 6만나면 애를 더해서 올리고
    // 로직이 아예 잘못됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        0666 1666 2666 3666 4666 5666 6660 6661 6662 6663 6664 6665 6666 6667 6668 6669 7666 8666 9666 10666
//        11666 12666 13666 14666 15666 16660 16661 16662 16663 16664 16665 16666 16667 16668 16669 17666 18666 19666
//        20666 21666 22666 23666 24666 25666 26660 26661 26662 26663 26664 26665 26666 26667 26667 26669 27666 28666 29666
//        맨 앞에자리에 값을 추가해가면서 count 한다. 그러다가 6을 만나면 1의 자리에 값을 넣어준다.
        int postCount = 0,preCount = 0, result = 0;
        Boolean switcher = false;
        while (N > 0){
            if(switcher){
                System.out.println("post count:    " + postCount);
                result = postAdd();
                if(postCount == 8){
                    postCount = 0;
                    switcher = false;
                }else {
                    postCount += 1;
                }
            }else {
                System.out.println("pre count:    " + preCount);
                if(preCount == 6){
                    preCount += 1;
                    switcher = true;
                    result = sixPreAdd();
                    System.out.println("--------------6이다.   ");
                } else if (preCount == 10) {
                    result = preAdd();
                    preCount = 0;
                } else {
                    result = preAdd();
                    preCount += 1;
                }

            }
            System.out.println(result);
            N -= 1;
        }
        System.out.println(result);
    }

    // 하나는 6번 하나는 10번
    private static int preAdd(){
        pre++;
        StringBuffer temp = new StringBuffer();
        temp.append(pre);
        temp.append(666);
        return Integer.parseInt(temp.toString());
    }

    private static int sixPreAdd(){
        pre++;
        StringBuffer temp = new StringBuffer();
        System.out.println("when 6 pre is "+pre);
        temp.append(pre);
        temp.append(660);
        return Integer.parseInt(temp.toString());
    }
    private static int postAdd(){
        post++;
        StringBuffer temp = new StringBuffer();
        temp.append(pre);
        temp.append(66);
        temp.append(post);
        if(post == 9){
            post = -1;
        }
        return Integer.parseInt(temp.toString());
    }
}
