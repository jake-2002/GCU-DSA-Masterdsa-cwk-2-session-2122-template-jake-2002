package contollers;

import daos.bstDAOImpl;
import helpers.InputHelper;
import helpers.OutputHelper;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;


public class controller {
    private final bstDAOImpl<StudentMarks> bstDAO;
    private final InputHelper inputHelper;

    public controller() {
        this.bstDAO = new bstDAOImpl<>();
        this.inputHelper = new InputHelper();
    }

    /**
     * Displays the menu and uses an InputHelper object
     * to accept valid user choice.
     * An appropriate private method is called to implement the choice.
     */
    public void run() {
        boolean finished = false;

        int iChoice;
        this.setup();

        do {
            this.theMenu();
            iChoice = inputHelper.readInt("Enter choice", 5,1);
            switch (iChoice) {
                // Add more cases
                case 1:
                    viewStudentMarksAsc(DisplayOrder.ASCENDING);
                    System.out.println();
                    break;
                case 2:
                    viewStudentMarksDesc(DisplayOrder.DESCENDING);
                    System.out.println();
                    break;
                case 3:
                    findStudentMark();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("EXITING THE PROGRAM");
                    finished = true;
                    break;
                default: // invalid option
                    System.out.println("Oops! Something has went wrong!");
                    break;
            }
        }while(!finished);
    }

    private void theMenu() {
        System.out.println("STUDENT MARKS PROGRAM");
        System.out.println("---------------------");
        System.out.println("1: View All Student Marks (ASC)");
        System.out.println("2: View All Student Marks (DESC)");
        System.out.println("3: Find Mark");
        System.out.println("5: Exit Program");
    }

    private void findStudentMark() {
        System.out.println("Find A Student Mark");
        System.out.println("-------------------");
        double choice = inputHelper.readDouble("Please enter student mark to find");
        this.bstDAO.findData(choice);
    }

    private void viewStudentMarksDesc(DisplayOrder order) {
        System.out.format("Display Marks in %s order", order.toString());
        System.out.println("-------------------------");
        this.bstDAO.displayBST(order);
    }

    private void viewStudentMarksAsc(DisplayOrder order) {
        System.out.format("Display Marks in %s order", order.toString());
        System.out.println("-------------------------");
        this.bstDAO.displayBST(order);
    }

    private void setup(){
        this.bstDAO.loadFromFile("ClassTestData.txt");
    }

}
