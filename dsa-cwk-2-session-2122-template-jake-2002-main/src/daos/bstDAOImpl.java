package daos;

import app.StudentMarksBST;
import datastructures.BinarySearchTree;
import helpers.Sorts;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;
import view.aView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bstDAOImpl<E> extends DAO<E>{

    private BinarySearchTree<StudentMarks> theBST;
    private aView theView;
    public static final char DELIMITER = ',';
    public static final char EOLN='\n';
    public static final String QUOTE="\"";
    public static final String USERDIRECTORY = System.getProperty("user.dir");

    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }

    public bstDAOImpl() {
        this.theBST = new BinarySearchTree<>();
        this.theView = new aView();
    }

    public BinarySearchTree<StudentMarks> getTheBST() {
        return theBST;
    }

    public void setTheBST(BinarySearchTree<StudentMarks> theBST) {
        this.theBST = theBST;
    }

    @Override
    public void loadFromFile(String filename) {
        String transactionFile = USERDIRECTORY +"\\" + filename;
        ArrayList<StudentMarks> dataSet = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
            String theStudentId;
            String theStudentFName;
            String theStudentSName;
            int theCT1;
            int theCT2;
            int theCT3;
            double theModuleMark;

            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                theStudentId = temp[0];
                theStudentFName = temp[1];
                theStudentSName = temp[2];
                theCT1 = Integer.parseInt(temp[3]);
                theCT2 = Integer.parseInt(temp[4]);
                theCT3 = Integer.parseInt(temp[5]);

                StudentMarks studentMark = new StudentMarks();
                studentMark.setStudentID(theStudentId);
                studentMark.setFName(theStudentFName);
                studentMark.setSName(theStudentSName);
                studentMark.setCT1(theCT1);
                studentMark.setCT2(theCT2);
                studentMark.setCT3(theCT3);
                theModuleMark = studentMark.calculateModuleMark();
                studentMark.setModuleMark(theModuleMark);

                dataSet.add(studentMark);
                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentMarksBST.class.getName()).log(Level.INFO, null, ex);
        }
        // sort the dataset
        this.theBST.createBalancedTree(dataSet, 0, dataSet.size() - 1);

    }

    @Override
    public void writeToFile(String filename) {
        // Add your code here
    }

    @Override
    public void add(E theData) {
        this.theBST.addNode((StudentMarks)theData);
    }

    @Override
    public void update(E theData) {

    }

    @Override
    public void findData(double theData) {
        StudentMarks dataToFind = new StudentMarks(theData);
        StudentMarks found = theBST.findItem(dataToFind);
        if(found != null) {
            this.theView.displayABSTItem(found);
        } else {
            System.out.format("The entry %s was not found\n", theData);
        }
    }

    @Override
    public E getData(String theData) {
        return null;
    }

    @Override
    public void removeData(int theData) {
        StudentMarks dataToFind = new StudentMarks(theData);
        StudentMarks found = theBST.findItem(dataToFind);
        if(found != null) {
            this.theBST.deleteNode(found);
            System.out.println("THE ENTRY HAS BEEN DELETED");
            this.theView.displayABSTItem(found);
        } else {
            System.out.format("The entry %s was not found\n", theData);
        }
    }

    public void displayBST(DisplayOrder order){
        this.theView.displayBST(this.theBST, order);
    }

    public void displayBSTChart(){
        // Add your code here
    }

}
