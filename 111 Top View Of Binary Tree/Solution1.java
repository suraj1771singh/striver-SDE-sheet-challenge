class Pair{

    BinaryTreeNode node;

    int hd;

 

    public Pair(BinaryTreeNode val, int level){

        this.node = val;

        this.hd = level;

    }

}

public class Solution {

    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {

        // Write your code here.

        ArrayList<Integer> res = new ArrayList<>();

        if(root == null) return res;

 

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

 

        q.add(new Pair(root, 0));

 

        while(!q.isEmpty()){

            Pair p = q.remove();

            int level = p.hd;

 

            BinaryTreeNode temp = p.node;

 

            if(map.get(level) == null){

                map.put(level, temp.val);

            }

 

            if(temp.left != null){

                q.add(new Pair(temp.left, level - 1));

            }

 

            if(temp.right != null){

                q.add(new Pair(temp.right, level + 1));

            }

 

        }

 

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            res.add(entry.getValue());

        }

 

        return res;

    }

}