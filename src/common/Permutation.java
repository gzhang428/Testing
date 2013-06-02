package common;
public class Permutation
{
    public static void main(String[] args) {
        char buf[] = {'a','b','c'};
        perm(buf, 0, buf.length -1);
        
    }
    
    public static void perm(char[] buf, int start, int end){
        if(start == end){
            for(int i = 0;i <= end; i++){
                System.out.print(buf[i]+ " ");
            }
            System.out.println();
        }else{
            for(int i=start; i<=end; i++){
                //System.out.println("start: " + start + "-->"+buf[start]);
                char temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
                //System.out.println("-"+buf[start]+"--start----");
                perm(buf, start + 1, end);
                //System.out.println("---end----");
                temp = buf[start];
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

}