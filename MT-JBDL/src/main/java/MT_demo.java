import java.util.ArrayList;

/**
 * Question : You have to find the sum of sqaures of differences between
 * even and odd numbers which are in range of 1 to N.
 * For example : Lets say you are given N = 100,
 * so you have to find what is the value of
 * (100^2 - 99^2) + (98^2 -97^2) + (96^2 -95^2) + .... (2^2 - 1^2).
 * The marking scheme would be as follows : Total Marks = 10 marks
 * Correct Answer = 4 marks (I will be validating the answer) Optimization - 4 marks
 * (depends on how much you can reduce the total time taken to run the program).
 * Code readablity : 2 marks Note: You have to upload the zip file of your project,
 * in case you are not able to create the zip file, upload only the java classes (2-3 classes)
 * excluding the .idea and other redundant classes *
 */
public class MT_demo {

    public static void main(String[] args) throws InterruptedException {


        int n = 100;
        long start = System.currentTimeMillis();

        ArrayList<MyThread> evenSquareJobs = new ArrayList<MyThread>();
        ArrayList<MyThread> oddSquareJobs = new ArrayList<MyThread>();
        long[] evenSquareResult;
        long[] oddSquareresult;

        for(int i=n;i > 0; i--){

            MyThread t = new MyThread(i);

            if(i%2 == 0)
            {
                evenSquareJobs.add(t);
            }
            else {
                oddSquareJobs.add(t);
            }
            t.start();
        }


        evenSquareResult = new long[evenSquareJobs.size()];
        oddSquareresult = new long[oddSquareJobs.size()];

        for(int i=0;i<evenSquareJobs.size();i++){
            evenSquareJobs.get(i).join();
            evenSquareResult[i] = evenSquareJobs.get(i).result;
        }


        for(int i=0;i<oddSquareJobs.size();i++){
            oddSquareJobs.get(i).join();
            oddSquareresult[i] = oddSquareJobs.get(i).result;
        }

        System.out.println("Squared Sum Diff : "+ (sum(evenSquareResult) - sum(oddSquareresult)));

        System.out.println(System.currentTimeMillis() - start);


    }

    private static class MyThread extends Thread{

        int num;
        long result;

        public MyThread(int num) {
            this.num = num;
            result = 1;
        }

        @Override
        public void run() {
            calculate();
        }

        public void calculate(){
            result = num * num;
        }
    }

    public static long sum(long[] arr){
        return Summation.parallelSum(arr);
    }

}
