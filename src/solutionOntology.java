/**
 * Created by techmint on 12/25/16.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class solutionOntology {
    /*
    static void find(String[] arr) {
        int m = Integer.parseInt(arr[2]), k = Integer.parseInt(arr[m + 3]);
        OTrie otrie = new OTrie();
        OTrieNode temp;
        ArrayList<OTrieNode> nodes = new ArrayList();
        Stack<String> stack = new Stack();
        for (String word : arr[1].split(" ")) {
            stack.push(word);
        }
        while (!stack.isEmpty()) {
            String elem = stack.pop();
            if (elem.equals("(")) {
                temp = otrie.addback(stack.pop());
                relate(temp, nodes);
                nodes.add(temp);
                continue;
            }
            nodes.add(otrie.addback(elem));
        }

        String[] details;
        for (int i = 3; i < 3 + m; i++) {
            details = arr[i].split(":");
            otrie.get(details[0]).questions.add(details[1]);
        }

        for (int i = m + 4; i < m + 4 + k; i++) {
            int index = arr[i].indexOf(" ");
            OTrieNode topic = otrie.get(arr[i].substring(0, index));
            String question = arr[i].substring(index, arr[i].length());
            count(topic, question);
        }
    }

    static void count(OTrieNode topic, String question) {
        int c = 0;
        for (String q : topic.questions) {
            if (q.startsWith(question))
                c++;
        }
        for (OTrieNode child : topic.children) {
            for (String q : child.questions) {
                if (q.startsWith(question))
                    c++;
            }
        }
        System.out.println(c);
    }

    static void relate(OTrieNode parent, ArrayList<OTrieNode> children) {
        for (int i = children.size() - 1; i >= 0; i--) {
            if (children.get(i).val == ')') {
                children.remove(i);
                return;
            }
            parent.children.add(children.get(i));
            children.get(i).parents.add(parent);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> myinput = new ArrayList();
        while (sc.hasNext()) {
            myinput.add(sc.nextLine());
        }
        String[] arr = new String[myinput.size()];
        arr = myinput.toArray(arr);
        find(arr);
    }

    */
}

