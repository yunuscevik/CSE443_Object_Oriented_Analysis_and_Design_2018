package Part1;

/**
 * State Design Pattern' i calistirmak icin tetikleyici sinif.
 * @author Yunus CEVIK
 */
public class Main {
    public static void main(String[] args) {
        Student student = null;

        //ready -> unable to become a rod for an axe
        System.out.println("****************************************************");
        System.out.println("* Test: ready -> unable to become a rod for an axe *");
        System.out.println("****************************************************");
        student = new Student();
        student.buyingGTX1080();

        student = new Student();
        student.cheating();
        System.out.println("--------------------  END STATE --------------------\n");
        //ready -> fit -> graduate
        System.out.println("****************************************************");
        System.out.println("* Test: ready -> fit -> graduate                   *");
        System.out.println("****************************************************");
        student = new Student();
        student.exercise();
        student.perseveranceAndHardWork();
        System.out.println("--------------------  END STATE --------------------\n");
        //ready -> graduate
        System.out.println("****************************************************");
        System.out.println("* Test: ready -> graduate                          *");
        System.out.println("****************************************************");
        student = new Student();
        student.perseveranceAndHardWork();
        System.out.println("--------------------  END STATE --------------------\n");
        //ready -> needing sleep -> chronic illness
        System.out.println("****************************************************");
        System.out.println("* Test: ready -> needing sleep -> chronic illness  *");
        System.out.println("****************************************************");
        student = new Student();
        student.outTillLate();
        student.coffeeAndWork();
        System.out.println("--------------------  END STATE --------------------\n");
        //ready -> needing sleep -> ready
        System.out.println("****************************************************");
        System.out.println("* Test: ready -> needing sleep -> ready            *");
        System.out.println("****************************************************");
        student = new Student();
        student.outTillLate();
        student.sleep();
        System.out.println("--------------------  END STATE --------------------\n");
        //unsupported actions
        System.out.println("****************************************************");
        System.out.println("* Test: unsupported actions                        *");
        System.out.println("****************************************************");
        student.coffeeAndWork();
        System.out.println("....................................................");
        student.exercise();
        student.cheating();
        System.out.println("....................................................");
        student.perseveranceAndHardWork();
        student.sleep();
        System.out.println("--------------------  END STATE --------------------\n");
    }
}