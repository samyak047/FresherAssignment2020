package assignment3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Controller {
    public static void start(){
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        while (true) {
            System.out.println("Choices :");
            System.out.println("1. Add New Node");
            System.out.println("2. Add New Dependency");
            System.out.println("3. Delete Dependency");
            System.out.println("4. Get Parent");
            System.out.println("5. Get Child");
            System.out.println("6. Get Ancestors");
            System.out.println("7. Get Decedents");
            System.out.println("8. Delete a Node");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("Enter the name of node : ");
                    String name = sc.next();
                    System.out.println("Enter the Additional info for node ( press 0 to end info )");
                    HashMap<String, String> info = new HashMap<String, String>();
                    while (true) {
                        System.out.print("Enter key : ");
                        String key = sc.next();
                        if (key.equals("0")) {
                            break;
                        }
                        System.out.print("Enter value : ");
                        String value = sc.next();
                        info.put(key, value);
                    }
                    System.out.println("Node is created : " + tree.addNewNode(name, info));
                    break;

                case 2:
                    System.out.print("Enter the Parent Node Id : ");
                    int parentNodeId = sc.nextInt();
                    System.out.print("Enter the Child Node Id");
                    int childNodeId = sc.nextInt();
                    try {
                        tree.addDependency(parentNodeId, childNodeId);
                        System.out.println("Depenedency added");
                    } catch (Exception e) {
                        System.out.print(e);
                    }
                    break;

                case 3:
                    System.out.print("Enter the Parent Node Id : ");
                    parentNodeId = sc.nextInt();
                    System.out.print("\nEnter the Child Node Id");
                    childNodeId = sc.nextInt();
                    try {
                        tree.deleteDependency(parentNodeId, childNodeId);
                        System.out.println("dependency deleted");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    System.out.print("Enter the nodeId : ");
                    int nodeId = sc.nextInt();
                    try {
                        TreeSet<Node> imediateParentNode = tree.getImediateParents(nodeId);
                        System.out.println(imediateParentNode);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.print("Enter the node id : ");
                    nodeId = sc.nextInt();
                    try {
                        TreeSet<Node> imediateChildNode = tree.getImediateChilds(nodeId);
                        System.out.println(imediateChildNode);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println("Enter the node id : ");
                    nodeId = sc.nextInt();
                    try {
                        TreeSet<Node> ancestors = tree.getAncestors(nodeId, new TreeSet<Node>());
                        System.out.println(ancestors);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 7:
                    System.out.println("Enter the node id : ");
                    nodeId = sc.nextInt();
                    try {
                        TreeSet<Node> decendetns = tree.getDecendents(nodeId, new TreeSet<Node>());
                        System.out.println(decendetns);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    System.out.println("Enter the node id : ");
                    nodeId = sc.nextInt();
                    try {
                        tree.deleteNode(nodeId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Please select valid option(0-8).");
            }
        }
    }

}
