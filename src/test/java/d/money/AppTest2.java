package d.money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import d.money.common.utils.CollectionUtils;
import d.money.common.utils.Node;
import d.money.common.utils.NodeUtil;
import d.money.service.impl.UserInfoServiceImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest2 extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest2(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest2.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);

		UserInfoServiceImpl impl = new UserInfoServiceImpl();

		List<Node> dataList = new ArrayList<Node>();
		dataList.add(new Node(1, 0, 1, 1));
		impl.convertChild(dataList);
		impl.convertParent(dataList);
		List<Node> dataList1 = new ArrayList<Node>();
		dataList1.add(new Node(1, 0, 1, 1));
		dataList1.add(new Node(2, 1, 1, 2));
		impl.convertChild(dataList1);
		impl.convertParent(dataList1);
		List<Node> dataList2 = new ArrayList<Node>();
		dataList2.add(new Node(1, 0, 1, 1));
		dataList2.add(new Node(2, 1, 1, 2));
		dataList2.add(new Node(3, 1, 0, 2));
		impl.convertChild(dataList2);
		impl.convertParent(dataList2);
		List<Node> dataList3 = new ArrayList<Node>();
		dataList3.add(new Node(1, 0, 1, 1));
		dataList3.add(new Node(2, 1, 1, 2));
		dataList3.add(new Node(3, 1, 0, 2));
		dataList3.add(new Node(4, 2, 1, 3));
		impl.convertChild(dataList3);
		impl.convertParent(dataList3);
		List<Node> dataList4 = new ArrayList<Node>();
		dataList4.add(new Node(1, 0, 1, 1));
		dataList4.add(new Node(2, 1, 1, 2));
		dataList4.add(new Node(3, 1, 0, 2));
		dataList4.add(new Node(4, 2, 1, 3));
		dataList4.add(new Node(5, 2, 0, 3));
		impl.convertChild(dataList4);
		impl.convertParent(dataList4);
		List<Node> dataList5 = new ArrayList<Node>();
		dataList5.add(new Node(1, 0, 1, 1));
		dataList5.add(new Node(2, 1, 1, 2));
		dataList5.add(new Node(3, 1, 0, 2));
		dataList5.add(new Node(4, 2, 1, 3));
		dataList5.add(new Node(5, 2, 0, 3));
		dataList5.add(new Node(6, 3, 0, 3));
		impl.convertChild(dataList5);
		impl.convertParent(dataList5);
		List<Node> dataList6 = new ArrayList<Node>();
		dataList6.add(new Node(1, 0, 1, 1));
		dataList6.add(new Node(2, 1, 1, 2));
		dataList6.add(new Node(3, 1, 0, 2));
		dataList6.add(new Node(4, 2, 1, 3));
		dataList6.add(new Node(5, 2, 0, 3));
		dataList6.add(new Node(6, 3, 0, 3));
		dataList6.add(new Node(7, 3, 0, 3));
		impl.convertChild(dataList6);
		impl.convertParent(dataList6);
		List<Node> dataList7 = new ArrayList<Node>();
		dataList7.add(new Node(1, 0, 1, 1));
		dataList7.add(new Node(2, 1, 1, 2));
		dataList7.add(new Node(3, 1, 0, 2));
		dataList7.add(new Node(4, 2, 1, 3));
		dataList7.add(new Node(5, 2, 0, 3));
		dataList7.add(new Node(6, 3, 0, 3));
		dataList7.add(new Node(7, 3, 0, 3));
		dataList7.add(new Node(8, 4, 0, 4));
		impl.convertChild(dataList7);
		impl.convertParent(dataList7);
		List<Node> dataList8 = new ArrayList<Node>();
		dataList8.add(new Node(1, 0, 1, 1));
		dataList8.add(new Node(2, 1, 1, 2));
		dataList8.add(new Node(3, 1, 0, 2));
		dataList8.add(new Node(4, 2, 1, 3));
		dataList8.add(new Node(5, 2, 0, 3));
		dataList8.add(new Node(6, 3, 0, 3));
		dataList8.add(new Node(7, 3, 0, 3));
		dataList8.add(new Node(8, 4, 0, 4));
		dataList8.add(new Node(9, 4, 0, 4));
		impl.convertChild(dataList8);
		impl.convertParent(dataList8);
		List<Node> dataList9 = new ArrayList<Node>();
		dataList9.add(new Node(1, 0, 1, 1));
		dataList9.add(new Node(2, 1, 1, 2));
		dataList9.add(new Node(3, 1, 0, 2));
		dataList9.add(new Node(4, 2, 1, 3));
		dataList9.add(new Node(5, 2, 0, 3));
		dataList9.add(new Node(6, 3, 0, 3));
		dataList9.add(new Node(7, 3, 0, 3));
		dataList9.add(new Node(8, 4, 0, 4));
		dataList9.add(new Node(9, 4, 0, 4));
		dataList9.add(new Node(10, 5, 0, 4));
		impl.convertChild(dataList9);
		impl.convertParent(dataList9);
		List<Node> dataList10 = new ArrayList<Node>();
		dataList10.add(new Node(1, 0, 1, 1));
		dataList10.add(new Node(2, 1, 1, 2));
		dataList10.add(new Node(3, 1, 0, 2));
		dataList10.add(new Node(4, 2, 1, 3));
		dataList10.add(new Node(5, 2, 0, 3));
		dataList10.add(new Node(6, 3, 0, 3));
		dataList10.add(new Node(7, 3, 0, 3));
		dataList10.add(new Node(8, 4, 0, 4));
		dataList10.add(new Node(9, 4, 0, 4));
		dataList10.add(new Node(10, 5, 0, 4));
		dataList10.add(new Node(11, 5, 0, 4));
		impl.convertChild(dataList10);
		impl.convertParent(dataList10);
		List<Node> dataList11 = new ArrayList<Node>();
		dataList11.add(new Node(1, 0, 1, 1));
		dataList11.add(new Node(2, 1, 1, 2));
		dataList11.add(new Node(3, 1, 0, 2));
		dataList11.add(new Node(4, 2, 1, 3));
		dataList11.add(new Node(5, 2, 0, 3));
		dataList11.add(new Node(6, 3, 0, 3));
		dataList11.add(new Node(7, 3, 0, 3));
		dataList11.add(new Node(8, 4, 0, 4));
		dataList11.add(new Node(9, 4, 0, 4));
		dataList11.add(new Node(10, 5, 0, 4));
		dataList11.add(new Node(11, 5, 0, 4));
		dataList11.add(new Node(12, 6, 0, 4));
		impl.convertChild(dataList11);
		impl.convertParent(dataList11);
		List<Node> dataList12 = new ArrayList<Node>();
		dataList12.add(new Node(1, 0, 1, 1));
		dataList12.add(new Node(2, 1, 1, 2));
		dataList12.add(new Node(3, 1, 0, 2));
		dataList12.add(new Node(4, 2, 1, 3));
		dataList12.add(new Node(5, 2, 0, 3));
		dataList12.add(new Node(6, 3, 0, 3));
		dataList12.add(new Node(7, 3, 0, 3));
		dataList12.add(new Node(8, 4, 0, 4));
		dataList12.add(new Node(9, 4, 0, 4));
		dataList12.add(new Node(10, 5, 0, 4));
		dataList12.add(new Node(11, 5, 0, 4));
		dataList12.add(new Node(12, 6, 0, 4));
		dataList12.add(new Node(13, 6, 0, 4));
		impl.convertChild(dataList12);
		impl.convertParent(dataList12);
		List<Node> dataList13 = new ArrayList<Node>();
		dataList13.add(new Node(1, 0, 1, 1));
		dataList13.add(new Node(2, 1, 1, 2));
		dataList13.add(new Node(3, 1, 0, 2));
		dataList13.add(new Node(4, 2, 1, 3));
		dataList13.add(new Node(5, 2, 0, 3));
		dataList13.add(new Node(6, 3, 0, 3));
		dataList13.add(new Node(7, 3, 0, 3));
		dataList13.add(new Node(8, 4, 0, 4));
		dataList13.add(new Node(9, 4, 0, 4));
		dataList13.add(new Node(10, 5, 0, 4));
		dataList13.add(new Node(11, 5, 0, 4));
		dataList13.add(new Node(12, 6, 0, 4));
		dataList13.add(new Node(13, 6, 0, 4));
		dataList13.add(new Node(14, 7, 0, 4));
		impl.convertChild(dataList13);
		impl.convertParent(dataList13);
		List<Node> dataList14 = new ArrayList<Node>();
		dataList14.add(new Node(1, 0, 1, 1));
		dataList14.add(new Node(2, 1, 1, 2));
		dataList14.add(new Node(3, 1, 0, 2));
		dataList14.add(new Node(4, 2, 1, 3));
		dataList14.add(new Node(5, 2, 0, 3));
		dataList14.add(new Node(6, 3, 0, 3));
		dataList14.add(new Node(7, 3, 0, 3));
		dataList14.add(new Node(8, 4, 0, 4));
		dataList14.add(new Node(9, 4, 0, 4));
		dataList14.add(new Node(10, 5, 0, 4));
		dataList14.add(new Node(11, 5, 0, 4));
		dataList14.add(new Node(12, 6, 0, 4));
		dataList14.add(new Node(13, 6, 0, 4));
		dataList14.add(new Node(14, 7, 0, 4));
		dataList14.add(new Node(15, 7, 0, 4));
		impl.convertChild(dataList14);
		impl.convertParent(dataList14);

		// NodeUtil nodeUtil = new NodeUtil();

		@SuppressWarnings("unchecked")
		List<List<Node>> testList = Arrays.asList(dataList, dataList1,
				dataList2, dataList3, dataList4, dataList5, dataList6,
				dataList7, dataList8, dataList9, dataList10, dataList11,
				dataList12, dataList13, dataList14);

		for (List<Node> list : testList) {

			int nodeId = list.size();
			Node node = impl.x(list, nodeId);
			System.out.println(nodeId + " = "
					+ (node == null ? "无节点符合要求！" : node.getId()));
			
			if (node != null) {
				
				System.out.println("5%节点为：");
				List<Node> node5 = impl.y(node);
				if (CollectionUtils.isEmpty(node5)) {
					System.out.println("无!");
				} else {
					for (Node node2 : node5) {
						System.out.println(node2.getId());
					}
				}
			}
			
			 System.out.println();
			 System.out.println();
		}

//		 int nodeId = dataList8.size();
//		 Node node = impl.x(dataList8, nodeId);
//		 System.out.println(nodeId + " = "
//		 + (node == null ? "无节点符合要求！" : node.getId()));
//		 System.out.println("5%节点为：");
//		 List<Node> node5 = impl.y(node);
//		 for (Node node2 : node5) {
//			System.out.println(node2.getId());
//		}

		//
		// System.out.println( new NodeUtil().getChildNodes(dataList, 2));
		// System.out.println( new NodeUtil().getChildNodes(dataList, 3));

	}
}
