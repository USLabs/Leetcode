/**
 * Created by techmint on 12/5/16.
 */
public class google2_1 {
    public static int solution(int min, int max, Tree t)
    {
        if(t==null)
            return 0;
        if(isValid(min, max, t))
            return count(t);
        return Math.max(solution(min, max, t.l), solution(min, max, t.r));
    }

    public static boolean isValid(int min, int max, Tree t){
        if(t==null)
            return true;
        if(t.val<max && t.val>min)
        {
            if(isValid(min, max, t.l) && isValid(min, max, t.r))
            {
                return true;
            }
        }
        return false;
    }

    public static int count(Tree t)
    {
        if(t==null)
            return 0;
        if(t.l == null)
            return 1 + count(t.r);
        if(t.r==null)
            return 1 + count(t.l);
        return 1 + count(t.l) + count(t.r);
    }
}

class Tree{
    int val;
    public Tree l = null;
    public Tree r = null;
    Tree(int x)
    {
        val = x;
    }
}