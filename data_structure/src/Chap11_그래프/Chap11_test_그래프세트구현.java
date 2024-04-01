package Chap11_그래프;


/* sets - graph의 최단경로에서 사용
*/
/*
class Sets {
	int[] parent;
	int n;
    public Sets(int sz)
    {

    }

    public void SimpleUnion(int i, int j)
    // Replace the disjoint sets with roots i and j, i != j with their union
    {

    }

    public int SimpleFind(int i)
    // Find the root of the tree containing element i
    {
    }

    void WeightedUnion(int i, int j)
    // Union sets with roots i and j, i != j, using the weighting rule.
    // parent[i]~=~-count[i] and parent[i]~=~-count[i].
    {

    }

    int CollapsingFind(int i)
    // Find the root of the tree containing element i.
    // Use the collapsing rule to collapse all nodes from @i@ to the root
    {

    }

    void display()
    {
    	System.out.println("index/value를 출력: ");
    	for (int i = 1; i <= n; i++) 
    		System.out.print("  "+ i);
    	System.out.println();
    	for (int i = 1; i <= n; i++) 
    		if (parent[i] < 0)
    			System.out.print(" " + parent[i]);
    		else
    			System.out.print("  " + parent[i]); 
    	System.out.println(); 	
    }
}
public class Chap11_test_그래프세트구현 {
	public static void main(String[] args) {
	Sets m = new Sets(8);
	m.display();
	System.out.println("find 5: " + m.CollapsingFind(5));
	m.WeightedUnion(1, 2);
	m.WeightedUnion(3, 4);
	m.WeightedUnion(5, 6);
	m.WeightedUnion(7, 8);
	m.display();
	System.out.println("find 5: " + m.CollapsingFind(5));
	System.out.println("find 5: " + m.CollapsingFind(6));
	
	m.WeightedUnion(1, 3);
	m.WeightedUnion(5, 7);
	m.display();
	System.out.println("find 5: " + m.CollapsingFind(5));
	System.out.println("find 6: " + m.CollapsingFind(6));
	System.out.println("find 7: " + m.CollapsingFind(7));
	System.out.println("find 8: " + m.CollapsingFind(8));
	if(m.SimpleFind(1) == m.SimpleFind(8))
		System.out.println("1과 8은 같은 집합에 속한다");
	else 
		System.out.println("1과 8은 다른 집합에 속한다");
	System.out.println("1의 집합 " + m.SimpleFind(1));
	System.out.println("8의 집합 " + m.SimpleFind(8));
	m.WeightedUnion(1, 5);
	m.display();
	System.out.println("find 1: " + m.CollapsingFind(1));
	System.out.println("find 2: " + m.CollapsingFind(2));
	System.out.println("find 3: " + m.CollapsingFind(3));
	System.out.println("find 4: " + m.CollapsingFind(4));
	System.out.println("find 5: " + m.CollapsingFind(5));
	System.out.println("find 6: " + m.CollapsingFind(6));
	System.out.println("find 7: " + m.CollapsingFind(7));
	System.out.println("find 8: " + m.CollapsingFind(8));
	
	m.display();
	System.exit(0);
	return;
}
}
*/