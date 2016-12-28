import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;


public class Ontology {

    static void insert(String s, OTrie oTrie) {
        String n = "";
        ArrayList<OTrieNode> nodes = new ArrayList();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < 0)
                return;
            if (s.charAt(i) == '(') {
                String p = "";
                i -= 2;
                for (; i >= 0 && s.charAt(i) != ' '; i--) {
                    p = s.charAt(i) + p;
                }
                OTrieNode parent = oTrie.addback(p);
                relate(parent, nodes);
                nodes.add(parent);
                continue;
            }
            if (s.charAt(i) == ' ') {
                nodes.add(oTrie.addback(n));
                n = "";
                continue;
            }
            n = s.charAt(i) + n;
        }
    }

    public static void find(String[] arr1) {
        ArrayList<String> list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        starwars gandalf = new starwars();
        try {
            gandalf.gandalf(list1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            gandalf.gandalf2(list2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //java.util.Date dat = new java.util.Date();
        //System.out.println(new Timestamp(dat.getTime()));

        String[] arr = list1.toArray(new String[list1.size()]);
        String[] arr2 = list2.toArray(new String[list2.size()]);

        int m = Integer.parseInt(arr[2]), k = Integer.parseInt(arr[m + 3]);
        OTrie otrie = new OTrie();
        insert(arr[1], otrie);

        //java.util.Date dat1 = new java.util.Date();
        //System.out.println(new Timestamp(dat1.getTime()));


        /*
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
        */
        String[] details;
        for (int i = 3; i < 3 + m; i++) {
            details = arr[i].split(":");
            OTrieNode t = otrie.get(details[0]);
            if (t.questionsTrie == null)
                t.questionsTrie = new OTrie();
            t.questionsTrie.addback(details[1]);
        }

        //java.util.Date dat2 = new java.util.Date();
        //System.out.println(new Timestamp(dat2.getTime()));


        int l = 0;
        for (int i = m + 4; i < m + 4 + k; i++) {
            int index = arr[i].indexOf(" ");
            OTrieNode topic = otrie.get(arr[i].substring(0, index));
            System.out.println(count(topic, arr[i].substring(index, arr[i].length())));
        }

        //java.util.Date dat3 = new java.util.Date();
        //System.out.println(new Timestamp(dat3.getTime()));

    }

    static int count(OTrieNode topic, String question) {
        int c = 0;
        if (topic.questionsTrie == null)
            topic.questionsTrie = new OTrie();
        c += topic.questionsTrie.getCount(question);

        for (OTrieNode child : topic.children) {
            c += count(child, question);
        }
        return c;
    }

    static void relate(OTrieNode parent, ArrayList<OTrieNode> children) {
        for (int i = children.size() - 1; i >= 0; i--) {
            if (children.get(i).val == ')') {
                children.remove(i);
                return;
            }
            parent.children.add(children.get(i));
            children.get(i).parents.add(parent);
            children.remove(i);
        }
    }
}

class OTrie {
    OTrieNode[] tArr = {new OTrieNode('('), new OTrieNode(')'), new OTrieNode('A'), new OTrieNode('B'), new OTrieNode('C'), new OTrieNode('D'), new OTrieNode('E'), new OTrieNode('F'), new OTrieNode('G'), new OTrieNode('H'), new OTrieNode('I'), new OTrieNode('J'), new OTrieNode('K'), new OTrieNode('L'), new OTrieNode('M'), new OTrieNode('N'), new OTrieNode('O'), new OTrieNode('P'), new OTrieNode('Q'), new OTrieNode('R'), new OTrieNode('S'), new OTrieNode('T'), new OTrieNode('U'), new OTrieNode('V'), new OTrieNode('W'), new OTrieNode('X'), new OTrieNode('Y'), new OTrieNode('Z'), new OTrieNode('a'), new OTrieNode('b'), new OTrieNode('c'), new OTrieNode('d'), new OTrieNode('e'), new OTrieNode('f'), new OTrieNode('g'), new OTrieNode('h'), new OTrieNode('i'), new OTrieNode('j'), new OTrieNode('k'), new OTrieNode('l'), new OTrieNode('m'), new OTrieNode('n'), new OTrieNode('o'), new OTrieNode('p'), new OTrieNode('q'), new OTrieNode('r'), new OTrieNode('s'), new OTrieNode('t'), new OTrieNode('u'), new OTrieNode('v'), new OTrieNode('w'), new OTrieNode('x'), new OTrieNode('y'), new OTrieNode('z'), new OTrieNode(' ')};

    OTrieNode addback(String word) {
        if (word.length() == 0)
            return null;
        OTrieNode parent = null;
        OTrieNode[] trail = tArr;
        for (int i = 0; i < word.length(); i++) {
            if (i != 0)
                trail = parent.nextTrie.tArr;
            int ascii = (int) word.charAt(i);
            if (ascii == 40)
                parent = trail[0];
            else {
                if (ascii == 41)
                    parent = trail[1];
                else {
                    if (ascii >= 97)
                        parent = trail[ascii - 97 + 28];
                    else {
                        if (ascii == 32)
                            parent = trail[54];
                        else
                            parent = trail[ascii - 65 + 2];
                    }
                }
            }
            parent.count++;
            if (parent.nextTrie == null) {
                parent.nextTrie = new OTrie();
            }
        }
        return parent;
    }

    int getCount(String word) {
        if (word.length() == 0)
            return 0;
        OTrieNode parent = null;
        OTrieNode[] trail = tArr;
        for (int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            if (ascii == 40)
                parent = trail[0];
            else {
                if (ascii == 41)
                    parent = trail[1];
                else {
                    if (ascii >= 97)
                        parent = trail[ascii - 97 + 28];
                    else if (ascii == 32)
                        parent = trail[54];
                    else
                        parent = trail[ascii - 65 + 2];
                }
            }
            if (parent == null)
                return 0;
            if (parent.nextTrie == null) {
                return 0;
            } else
                trail = parent.nextTrie.tArr;
        }
        return parent.count;
    }

    OTrieNode get(String word) {
        if (word.length() == 0)
            return null;
        OTrieNode parent = null;
        OTrieNode[] trail = tArr;
        for (int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            if (ascii == 40)
                parent = trail[0];
            else {
                if (ascii == 41)
                    parent = trail[1];
                else {
                    if (ascii >= 97)
                        parent = trail[ascii - 97 + 28];
                    else if (ascii == 32)
                        parent = trail[54];
                    else
                        parent = trail[ascii - 65 + 2];
                }
            }
            if (parent == null)
                return null;
            if (parent.nextTrie == null) {
                return null;
            } else
                trail = parent.nextTrie.tArr;
        }
        return parent;
    }
}

class OTrieNode {
    Character val;
    OTrie nextTrie;
    ArrayList<OTrieNode> children = new ArrayList(), parents = new ArrayList();
    //ArrayList<String> questions = new ArrayList();
    OTrie questionsTrie = null;
    int count;

    OTrieNode(char v) {
        val = v;
    }
}