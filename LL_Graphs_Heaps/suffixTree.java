import java.util.ArrayList;
import java.util.*;

public class suffixtree{
   
    private static class node{
        string s = "";
        List<Integer> l = new ArrayList<>();

    }

    private static class tree{
        
        private List<node> nodeList = new ArrayList<>();

        public tree(String st){
            nodeList.add(new node);
        }
        for(int i=0;i<st.length();i++)
        {
            addSuffix(str.substring(i));
        }
    }

    private void addSuffix(String str){
        int n=0,i=0;
        while(i<str.length())
        {
            char b = str.charAt(i);
            List<Integer> child = nodeList.get(n).l;
            int x2=0;
            int n2;
            while(true)
            {
                if(x2==child.size())
                {
                    n2 = nodeList.size();
                    node temp = new node();
                    temp.s = str.substring(i);
                    nodeList.add(temp);
                    child.add(n2);
                    return ;
                }
                n2 = child.get(x2);
                if(nodeList.get(n2).s.charAt(0)==b) break;
                x2++;
            }
            String sub2 = nodeList.get(n2).s;
            int j=0;
            while(j<sub2.length())
            {
                if(str.charAt(i+j)!=sub2.charAt(j))
                {
                    int n3 = n2;
                    n2 = nodeList.size();
                    node temp = new node();
                    temp.s = sub2.substring(0,j);
                    temp.l.add(n3);
                    nodeList.add(temp);
                    nodeList.get(n3).s = sub2.substring(j);
                    nodeList.get(n).l.set(x2,n2);
                    break;
                }
                j++;
            }
            i+=j;
            n = n2;

        }
    }

    public void visualize(){
        if(nodeList.isEmpty())
        {
            System.out.println("<empty>");
            return;
        }
        visualize_f(0,"");
    }

    private void visualize_f(int n,String pre)
    {
        List<Integer> children = nodeList.get(n).l;
        if(children.isEmpty())
        {
            System.out.println("- " + nodeList.get(n).s);
            return;
        }
        System.out.println("--| " + nodeList.get(n).s);
        for(int i=0;i<children.size() - 1;i++)
        {
            Integer c = children.get(i);
            System.out.println(pre + "|--");
            visualize_f(c,pre + "| ");
        }
        System.out.println(pre + "!--");
        visualize_f(children.get(children.size()-1  ),pre+ "  ");
    }

    public static void main(String[] args) {
        new tree("banana$").visualize();
    }
}

