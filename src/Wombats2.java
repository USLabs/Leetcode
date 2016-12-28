import java.util.Stack;

public class Wombats2 {

    public static int find(Tetrahedron root) {
        return findUtil(root, new Stack());
    }

    public static void unmarkVisited(Stack<Tetrahedron> stack1) {
        Tetrahedron a;
        Stack<Tetrahedron> temp = new Stack();
        while (!stack1.isEmpty()) {
            a = stack1.pop();
            a.isVisited = false;
            temp.push(a);
        }
        while (!temp.isEmpty()) {
            stack1.push(temp.pop());
        }
    }

    public static void markVisited(Stack<Tetrahedron> stack1) {
        Tetrahedron a;
        Stack<Tetrahedron> temp = new Stack();
        while (!stack1.isEmpty()) {
            a = stack1.pop();
            a.isVisited = true;
            temp.push(a);
        }
        while (!temp.isEmpty()) {
            stack1.push(temp.pop());
        }
    }

    public static int findUtil(Tetrahedron root, Stack<Tetrahedron> stack) {
        int res = 0;
        if (root == null)
            return res;
        Stack<Tetrahedron> parentsMarked = new Stack<>();
        if (!root.isVisited) {
            res += findParent(root, parentsMarked);
        }

        Stack<Tetrahedron> stacky = new Stack<>();
        Stack<Tetrahedron> stack2 = new Stack<>();

        for (Tetrahedron c : root.children) {
            if (c == null)
                continue;
            int ch = findUtil(c, stack2);
            if (ch > 0) {
                res += ch;
                while (!stack2.isEmpty()) {
                    stacky.push(stack2.pop());
                }
            }
        }
        if (res <= 0) {
            unmarkVisited(stacky);
            unmarkVisited(parentsMarked);
            return 0;
        }
        while (!parentsMarked.isEmpty()) {
            stack.push(parentsMarked.pop());
        }
        while (!stacky.isEmpty()) {
            stack.push(stacky.pop());
        }

        return res;
    }

    public static int findParent(Tetrahedron p, Stack<Tetrahedron> stack) {
        p.isVisited = true;
        stack.push(p);
        int res = p.x;
        for (Tetrahedron a : p.parents) {
            if (a == null)
                continue;
            if (!a.isVisited) {
                res += findParent(a, stack);
            }
        }
        return res;
    }
}


class Tetrahedron {
    int x;
    boolean isVisited = false;
    int cost = Integer.MAX_VALUE;
    int take = 0;
    Tetrahedron[] parents = new Tetrahedron[3], children = new Tetrahedron[3];

    Tetrahedron(int x) {
        this.x = x;
    }

    public void addChildren(Tetrahedron a) {
        int i = 0;
        while (true) {
            if (i == 3)
                return;
            if (this.children[i] == null) {
                this.children[i] = a;
                return;
            }
            i++;
        }
    }

    public void addParent(Tetrahedron a) {
        int i = 0;
        while (true) {
            if (i == 3)
                return;
            if (this.parents[i] == null) {
                this.parents[i] = a;
                return;
            }
            i++;
        }
    }
}
