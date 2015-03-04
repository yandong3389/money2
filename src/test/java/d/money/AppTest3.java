package d.money;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.alibaba.fastjson.JSONObject;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.Node;
import d.money.common.utils.NodeUtil;

/**
 * Unit test for simple App.
 */
public class AppTest3 extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest3(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest3.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);

		List<Node> dataList14 = new ArrayList<Node>();
		dataList14.add(new Node(1, 0, 1));
		dataList14.add(new Node(2, 1, 2));
		dataList14.add(new Node(3, 1, 2));
		dataList14.add(new Node(4, 2, 3));
		dataList14.add(new Node(5, 2, 3));
		dataList14.add(new Node(6, 3, 3));
		dataList14.add(new Node(7, 3, 3));
		dataList14.add(new Node(8, 4, 4));
		dataList14.add(new Node(9, 4, 4));
		dataList14.add(new Node(10, 5, 4));
		dataList14.add(new Node(11, 5, 4));
		dataList14.add(new Node(12, 6, 4));
		dataList14.add(new Node(13, 6, 4));
		dataList14.add(new Node(14, 7, 4));
		dataList14.add(new Node(15, 7, 4));
		NodeUtil.convertChild(dataList14);
//		NodeUtil.convertParent(dataList14);

		Node tree = dataList14.get(0);

		System.out.println(JSONObject.toJSONString(tree));

		
		test(tree);
	}
	
	
	public void test(Node node){
		
		System.out.println(node.getId());
		
		if (CollectionUtils.isNotEmpty(node.getChildren()) && node.getChildren().size() == 1 ) {
			test(node.getChildren().get(0));
		} else if (CollectionUtils.isNotEmpty(node.getChildren()) && node.getChildren().size() == 2 ) {
			test(node.getChildren().get(0));
			test(node.getChildren().get(1));
		}
	}
	
}
