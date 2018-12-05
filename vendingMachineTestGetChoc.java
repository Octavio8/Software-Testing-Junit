/* Octavio Garcia
 * 
 * This test suite was created using Eclipse Version: Neon.3 Release (4.6.3)
 * which has a stable version of a JUnit test driver. 
 */

/*
 * The import statements below allow the set up of Junit test suites.
 * All imports are required, some of these imports are not standard in Eclipse,
 * to remove the errors the JUnitParams-1.0.4(2).jar file has to be added to the build path
 * this .jar file will enable the Junit import statements. This .jar file is included in the .zip file.
 * To add this .jar file to the project in Eclipse IDE, right click on the project and scroll down to 
 * build path, then in build path click on Configure build path which will open a dialog. In this dialog 
 * under Java Build Path click Add External Jars..., then navigate to the location in your machine where 
 * the .jar file exists and add it to the build path. Once this has been completed the errors for the 
 * import statements will disappear and the test suites are ready to be executed.
 */
import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/*
 * The @RunWith indicates to the compiler that the test cases are going to be
 * used with JUnitParamsRunner.class, this class allows me to create the test cases inside a java file. 
 * Then the vendingMachineTestGetChoc method is defined. This method defines the test cases as well as additional methods
 * see comments below for details of additional methods.
 */
@RunWith(JUnitParamsRunner.class)
public class vendingMachineTestGetChoc
{
	/*
	 * An instance of the vendingMachine class is created and named getChoc, this name was chosen because the
	 * method under test is getChoc. This instance is used to execute the test cases below.  
	 */
	vendingMachine getChoc;  
	 
	/*
	 * This @Before statements indicates to Junit that this section of the code has to be executed
	 * before the tests can be executed. The method after the @Before statement creates a new instance 
	 * and allocates memory from the heap using the new operator.
	 */
	@Before
	public void setUp() throws Exception  
	{
		getChoc = new vendingMachine();
	}
	/*
	 * The @SuppressWarning("unused") is here to indicate to Junit that we are indeed trying to return an object from this
	 * method. If this statement is not used Junit will complain and the test suite will not execute. Within this method 
	 * vendingMachineGetChoc() an object will be returned and this object is a collection of the values that will be used to test the 
	 * coin method inside of the vendingMachine class. 
	 */
	@SuppressWarnings("unused")
	private static final Object[] vendingMachineGetChoc()
	{
		return $(	
				//Parameters are (1,2,3)
				//1 = input chocolate , 2 = input credit, 3 = expected result
				//test 1
				$("c1",25,25), 
				//test 2
				$("c1",100, 10),
				//test 3
				$("c4",100,100)  
				);
	}  
	/*
	 * Here is where the test are executed the @Test and @Parameters indicate to Junit the test is to start execution here
	 * and where the parameters are going to be read from respectively.
	 * Initially JUnit will call the vendingMachineGetChoc method to gather the values for the test cases and then it will
	 * start executing the testGetChoc method below, reading in the values according to the parameter format in the header
	 * of the testGetChoc method below.
	 */
	@Test
	@Parameters(method ="vendingMachineGetChoc")
	public void testGetChoc(String chocolate, int credit, int expected) 
	{	
		/*
		 * To test the getChoc method there has to be an inventory of chocolates and the credit cannot be zero as well.
		 * This is the reason for the the first 2 statements below. These statements will increase these variables inside
		 * the vendingMachine class.
		 */
		getChoc.addChoc(chocolate);
		getChoc.coin(credit);
		/*
		 * The addChoc method inside the vendingMachine class uses both a String variable to manipulate
		 * the chocolates in inventory but the getChoc method inside the same class uses a StringBuffer,
		 * because of this the statement below is used to convert the String variable to StringBuffer variable 
		 * before the tests are executed and the results compared in the assertEquals statement. 
		 */
		StringBuffer choc = new StringBuffer(chocolate);
		assertEquals(expected, getChoc.getChoc(choc));
	}
}
