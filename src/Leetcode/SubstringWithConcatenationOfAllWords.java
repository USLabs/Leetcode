package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by techmint on 9/27/16.
 */

public class SubstringWithConcatenationOfAllWords {
    public static final int baseChar = Character.getNumericValue('a');

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        Trie wordsTrie = new Trie();
        int totalLength = 0, backTracki;
        for (String word : words) {
            wordsTrie.add(word);
            totalLength += word.length();
        }

        Trie tempTrie = wordsTrie;
        ArrayList<Integer> backTrack = new ArrayList<>();
        ArrayList<TrieNode> backTrackNode = new ArrayList<>();
        TrieNode tempNode = null;
        ArrayList<TrieNode> trace = new ArrayList<>();
        for (int st = 0; st < s.length(); st++) {
            if (st != 0) {
                wordsTrie.restoreCount();
                trace.clear();
                backTrack.clear();
                backTrackNode.clear();
            }
            for (int i = st, len = s.length(); i < len && i < (st + totalLength); i++) {
                tempNode = tempTrie.tList.get(Character.getNumericValue(s.charAt(i)) - baseChar);
                if (tempNode.count > 0) {
                    tempNode.count = tempNode.count - 1;
                    trace.add(tempNode);
                    if (tempNode.deeper == true && tempNode.awake == false) {
                        backTrack.add(i);
                        backTrackNode.add(tempNode);
                        tempTrie = tempNode.nextTrie;
                    } else {
                        if (tempNode.leaf == true && tempNode.awake == false) {
                            if (i == (st + totalLength - 1)) {
                                result.add(st);
                            }
                            tempNode.awake = true;
                            tempTrie = wordsTrie;
                        } else {
                            if (tempNode.leaf == true && tempNode.awake == true) {
                                if (i == (st + totalLength - 1)) {
                                    result.add(st);
                                }
                                tempTrie = wordsTrie;
                            } else
                                tempTrie = tempNode.nextTrie;
                        }
                    }
                } else {
                    if (!backTrack.isEmpty()) {
                        //  restore till backtrack
                        //  backtrack
                        backTracki = backTrack.get(backTrack.size() - 1);
                        backTrack.remove(backTrack.size() - 1);
                        tempNode = backTrackNode.get(backTrackNode.size() - 1);
                        backTrackNode.remove(backTrackNode.size() - 1);

                        for (int j = i; j > backTracki; j--) {
                            trace.get(trace.size() - 1).count++;
                            trace.remove(trace.size() - 1);
                        }
                        tempNode.awake = true;
                        i = backTracki;
                        tempTrie = wordsTrie;

                    } else
                        break;
                }
            }
            tempTrie = wordsTrie;
        }
        return result;
    }

}

class Trie {
    public static final int baseChar = Character.getNumericValue('a');
    ArrayList<TrieNode> tList;

    Trie() {
        TrieNode[] arr = {new TrieNode('a'), new TrieNode('b'), new TrieNode('c'), new TrieNode('d'), new TrieNode('e'), new TrieNode('f'), new TrieNode('g'), new TrieNode('h'), new TrieNode('i'), new TrieNode('j'), new TrieNode('k'), new TrieNode('l'), new TrieNode('m'), new TrieNode('n'), new TrieNode('o'), new TrieNode('p'), new TrieNode('q'), new TrieNode('r'), new TrieNode('s'), new TrieNode('t'), new TrieNode('u'), new TrieNode('v'), new TrieNode('w'), new TrieNode('x'), new TrieNode('y'), new TrieNode('z')};
        tList = new ArrayList<TrieNode>(Arrays.asList(arr));
    }

    void add(String word) {
        Trie tempList = new Trie();
        tempList.tList = this.tList;
        TrieNode tempNode = null;
        for (int i = 0, len = word.length(); i < len; i++) {
            if (i != 0) {
                if (tempNode.nextTrie == null)
                    tempNode.nextTrie = new Trie();
                tempList = tempNode.nextTrie;
            }
            tempNode = tempList.tList.get(Character.getNumericValue(word.charAt(i)) - baseChar);
            tempNode.count++;
            tempNode.origcount++;
            if (i == len - 1)
                tempNode.leaf = true;
            else {
                if (tempNode.leaf == true)
                    tempNode.deeper = true;
            }
        }
    }

    void restoreCount() {
        for (TrieNode node : tList) {
            node.count = node.origcount;
            node.awake = false;
            if (node.leaf && node.nextTrie != null)
                node.deeper = true;
            else
                node.deeper = false;
            if (node.nextTrie != null)
                node.nextTrie.restoreCount();
        }
    }
}

class TrieNode {
    Character val;
    Trie nextTrie;
    int count;
    int origcount;
    boolean leaf = false;
    boolean deeper = false;
    boolean awake = false;

    TrieNode(char v) {
        val = v;
        count = 0;
        origcount = 0;
    }
}

class SubstringWithConcatenationOfAllWordsDriver {
    public static void mymain(String[] args) {
        long startTime = System.currentTimeMillis();

        //String s = "wordgood";
        //String s = "miudowshwyqwmysgveoymhuqvbuvtcdhmzkavejscaqqakwwpnwbuqtrtnomruvdthfplpjppzipjenarjdozwfsmugdobjjioyvdhnsivksbxuvhyjguqbgmhmclvmvjkrnuehcbrweprzypiglbhunrgqebezmoqzkwjnzcletedrtoyhphbeyhwckacwruydtjqslewficyeqwlheonexkjjmnffhfjcqbvcftjqvhunghumxkqwuzfiomowszaiavmirvymfualbwxagpwcrbnfnbdhaescbekscihjejuhfthokdsbgfjwimdksxnwezogixroglwogdeqjwupcdlmrrxmomislyavwrkeegskjwduvzkzexlxokjdwtxiuyfqrpwwxpijnndimnhqlvobfzeeteonctfvlbriscrgpvqekyuvvkxakdefhsulozhzcahvebdwytaitwgohfrtkxysssfgtohvpqsvrvrprramogdvluovtopngvtzlcwatpwmmnefhesvmvszrgumumacjvbuyzxtqvfdklirpcmdxecqmzdgldkwanqynnrdkzivkrmcvzfvfilshqauvlqwyiunyorinzdzsqbqrhlyrwqaptukgmggubusrnbemgdhyhxpqkqhgghvbdihpoojrkeixfmlnssmbrdrbtakcjhdopndedovnsekzsvnmqzpjcilwixytedhwqmatbxgtdsvyoimghcplkchvzhoglycbkevlddhhwcfmmtstvhgimodnvttirxkcdhphmyqicxuoqojmyqwkgzzdsvmmsyqyhhftgxekuybkpmyneuzkvyqotccocsmjztehqismjvwyhxnmtmwpmofgqhuuzifabkitscfdxdbeaqswcplpdqxwztsybyaekizekgijjlqmciiezvvfludmnvkqvkwfvvkhburnfjbjrjqrglwtgzfvwrmsdkzyglijfbynkzwbkmuqasjirodqhrilcjjkvtvcuupetoigacwaviioyogghorjacvvyrxsnpzgdhodlngivqzvefbowuxwzvrxmqrzfqhixwoljwtgmsbtafhwzgsablzpbrojhythwjshfnnsiqnixuezcyzejztmqkvzkrggaangqcayupislornmqtvrnjjzfjjyrpyuegmiimcxuuiinywgrrxgajfhuqhlhghlovtxhywbuhlifhoyanfdwmmqduekcnyqjtpqrouovhycrmcrbhwawjqzfwlhmjzvdrnwfjmcrkgiwibasyaojspqraxdmyyrpnnuxayomeyjnzlfzntkfiawkzbwyznnndkkfiarnycczphzccjkmmgwlktljizynlkutkmikqkkgtlivwshibewlzhwjixxtjrpwfzgwkqeddobajiimoezpmv";
        //String[] arr = {"mhuqvbuvtcdhmzkavejsca", "qqakwwpnwbuqtrtnomruvd", "thfplpjppzipjenarjdozw", "fsmugdobjjioyvdhnsivks", "bxuvhyjguqbgmhmclvmvjk", "rnuehcbrweprzypiglbhun", "rgqebezmoqzkwjnzcleted", "rtoyhphbeyhwckacwruydt", "jqslewficyeqwlheonexkj", "jmnffhfjcqbvcftjqvhung", "humxkqwuzfiomowszaiavm", "irvymfualbwxagpwcrbnfn", "bdhaescbekscihjejuhfth", "okdsbgfjwimdksxnwezogi", "xroglwogdeqjwupcdlmrrx", "momislyavwrkeegskjwduv", "zkzexlxokjdwtxiuyfqrpw", "wxpijnndimnhqlvobfzeet", "eonctfvlbriscrgpvqekyu", "vvkxakdefhsulozhzcahve", "bdwytaitwgohfrtkxysssf"};

        //String s = "miudowshwyqwmysgveoymhuqvbuvtcdhmzkavejscaqqakwwpnwbuqtrtnomruvdthfplpjppzipjenarjdozwfsmugdobjjioyvdhnsivksbxuvhyjguqbgmhmclvmvjkrnuehcbrweprzypiglbhunrgqebezmoqzkwjnzcletedrtoyhphbeyhwckacwruydtjqslewficyeqwlheonexkjjmnffhfjcqbvcftjqvhunghumxkqwuzfiomowszaiavmirvymfualbwxagpwcrbnfnbdhaescbekscihjejuhfthokdsbgfjwimdksxnwezogixroglwogdeqjwupcdlmrrxmomislyavwrkeegskjwduvzkzexlxokjdwtxiuyfqrpwwxpijnndimnhqlvobfzeeteonctfvlbriscrgpvqekyuvvkxakdefhsulozhzcahvebdwytaitwgohfrtkxysssfgtohvpqsvrvrprramogdvluovtopngvtzlcwatpwmmnefhesvmvszrgumumacjvbuyzxtqvfdklirpcmdxecqmzdgldkwanqynnrdkzivkrmcvzfvfilshqauvlqwyiunyorinzdzsqbqrhlyrwqaptukgmggubusrnbemgdhyhxpqkqhgghvbdihpoojrkeixfmlnssmbrdrbtakcjhdopndedovnsekzsvnmqzpjcilwixytedhwqmatbxgtdsvyoimghcplkchvzhoglycbkevlddhhwcfmmtstvhgimodnvttirxkcdhphmyqicxuoqojmyqwkgzzdsvmmsyqyhhftgxekuybkpmyneuzkvyqotccocsmjztehqismjvwyhxnmtmwpmofgqhuuzifabkitscfdxdbeaqswcplpdqxwztsybyaekizekgijjlqmciiezvvfludmnvkqvkwfvvkhburnfjbjrjqrglwtgzfvwrmsdkzyglijfbynkzwbkmuqasjirodqhrilcjjkvtvcuupetoigacwaviioyogghorjacvvyrxsnpzgdhodlngivqzvefbowuxwzvrxmqrzfqhixwoljwtgmsbtafhwzgsablzpbrojhythwjshfnnsiqnixuezcyzejztmqkvzkrggaangqcayupislornmqtvrnjjzfjjyrpyuegmiimcxuuiinywgrrxgajfhuqhlhghlovtxhywbuhlifhoyanfdwmmqduekcnyqjtpqrouovhycrmcrbhwawjqzfwlhmjzvdrnwfjmcrkgiwibasyaojspqraxdmyyrpnnuxayomeyjnzlfzntkfiawkzbwyznnndkkfiarnycczphzccjkmmgwlktljizynlkutkmikqkkgtlivwshibewlzhwjixxtjrpwfzgwkqeddobajiimoezpmv";
        //String[] arr = {"mhuqvbuvtcdhmzkavejsca", "qqakwwpnwbuqtrtnomruvd", "thfplpjppzipjenarjdozw", "fsmugdobjjioyvdhnsivks", "bxuvhyjguqbgmhmclvmvjk", "rnuehcbrweprzypiglbhun", "rgqebezmoqzkwjnzcleted", "rtoyhphbeyhwckacwruydt", "jqslewficyeqwlheonexkj", "jmnffhfjcqbvcftjqvhung", "humxkqwuzfiomowszaiavm", "irvymfualbwxagpwcrbnfn", "bdhaescbekscihjejuhfth", "okdsbgfjwimdksxnwezogi", "xroglwogdeqjwupcdlmrrx", "momislyavwrkeegskjwduv", "zkzexlxokjdwtxiuyfqrpw", "wxpijnndimnhqlvobfzeet", "eonctfvlbriscrgpvqekyu", "vvkxakdefhsulozhzcahve", "bdwytaitwgohfrtkxysssf"};
        //String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        //String[] arr = {"fooo","barr","wing","ding","wing"};
        // String[] arr = {"foo", "bar"};
        // String s = "barfoothefoobarman"
        String s = "hellowordbestgoodawordgoodwordhello";
        String[] arr = {"word", "best", "good", "goo", "da"};
        List<Integer> result = SubstringWithConcatenationOfAllWords.findSubstring(s, arr);
//        if(result.isEmpty())
//        {
//            System.out.println(-1);
//            return;
//        }
        for (int elem : result) {
            System.out.println(elem);
        }

        System.out.println(System.currentTimeMillis() - startTime);
    }
}