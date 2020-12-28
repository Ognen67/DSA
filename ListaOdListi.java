import java.util.Arrays;
import java.util.Scanner;


public class ListaOdListi {
    static Scanner input = new Scanner(System.in);
    public void findMagicNumber(DLL<DLL<Integer>> list, int n, int m) {

        // Grab the first list of numbers as root
        DLLNode<DLL<Integer>> curr = list.getFirst();

        int result = 0;
        int[] sumOfEachList = new int[n];
        int index = 0;
        int count = 0;

        // Traverse each list of numbers
        while(curr != null)    {
            // Assign first item of each list as root
            DLLNode<Integer> node = curr.element.getFirst();
            System.out.print("List[" + index + "]: ");

            // Traverse each list from node (root node of each list until null is found)
            while(node != null)    {
                result += node.element;
                System.out.print(++count < m ? node.element + " + " : node.element + " = " + result);
                node = node.succ;
            }System.out.println("");

            sumOfEachList[index++] = result;
            result = 0;
            count = 0;
            curr = curr.succ;
        }

        System.out.println("\nEach List Sum: " + Arrays.toString(sumOfEachList));
        System.out.println("Multiply all elements together:");

        // Multiply each element together and print out magic number
        result = 1;
        for(int i = 0;i < sumOfEachList.length;i++)    {
            System.out.println("\t" + result + " * " +  sumOfEachList[i]);
            result *= sumOfEachList[i];
        }

        System.out.println("\nMagic Number: " + result);
    }

    public void printList(DLL<DLL<Integer>> list, int n, int m) {

    }

    public static void main(String[] args) {
        int n, m;

        n = input.nextInt();
        m = input.nextInt();
        int zbir = 0;
        int pr = 1;

        DLL<DLL<Integer>> list = new DLL<>();
        for(int i=0; i<n; i++) {
            DLL<Integer> ins = new DLL<>();
            for(int j=0; j<m; j++) {
                ins.insertLast(input.nextInt());
            }
            list.insertLast(ins);
        }

        ListaOdListi l = new ListaOdListi();
        l.findMagicNumber(list, n, m);

    }
}