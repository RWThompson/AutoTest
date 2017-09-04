import org.junit.*;

/**
 * Created by Administrator on 04/09/2017.
 */
public class understandingJUnit {

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("Before Class");
    }

    @Before
    public void beforeTest() {
        System.out.println("Before");
    }

    @Test
    public void firstTest() {
        System.out.println("Test");
    }

    @After
    public void afterTest() {
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
