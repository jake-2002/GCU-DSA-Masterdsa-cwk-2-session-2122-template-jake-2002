package view;

import datastructures.BinarySearchTree;
import datastructures.Node;
import helpers.OutputHelper;
import model.DisplayOrder;
import model.StudentMarks;

public class aView {
    public void displayBSTItemAsc(Node<StudentMarks> root){
        if (root.leftNode != null) {
            displayBSTItemAsc(root.leftNode);
        }
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", root.getNodeData().getStudentID(), root.getNodeData().getFName(), root.getNodeData().getSName(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.rightNode != null) {
            displayBSTItemAsc(root.rightNode);
        }
    }

    public void displayBSTItemDesc(Node<StudentMarks> root){
        if (root.rightNode != null) {
            displayBSTItemAsc(root.rightNode);
        }
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", root.getNodeData().getStudentID(), root.getNodeData().getFName(), root.getNodeData().getSName(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.leftNode != null) {
            displayBSTItemAsc(root.leftNode);
        }
    }

    public void displayBST(BinarySearchTree<StudentMarks> theBST, DisplayOrder order){
        System.out.println(OutputHelper.repeat("-", 162));
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Student ID", "Given Name", "Surname", "CT1", "CT2", "CT3", "Module Mark");
        System.out.println(OutputHelper.repeat("-", 162));

        switch(order) {
            case ASCENDING:
                displayBSTItemAsc(theBST.getRoot());
                break;
            case DESCENDING:
                displayBSTItemDesc(theBST.getRoot());
                break;
            default:
                System.out.println("ERROR -----> SOMETHING WENT WRONG");
                break;
        }
        System.out.println(OutputHelper.repeat("-", 162));
    }

    public void displayABSTItem(StudentMarks anItem){
        System.out.println(OutputHelper.repeat("-", 162));
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Student ID", "Given Name", "Surname", "CT1", "CT2", "CT3", "Module Mark");
        System.out.println(OutputHelper.repeat("-", 162));
        System.out.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", anItem.getStudentID(), anItem.getFName(), anItem.getSName(), anItem.getCT1(), anItem.getCT2(), anItem.getCT3(), anItem.getModuleMark());
        System.out.println(OutputHelper.repeat("-", 162));
    }

    public void displayStudentScoreInChart(Node<StudentMarks> root){
    }

    public void displayAsChart(BinarySearchTree<StudentMarks> theBST){
        // Add your code here
    }
}
