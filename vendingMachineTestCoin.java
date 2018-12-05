/* Octavio Garcia
 * 
 * Homework # 3 for CSE-4322 Software Project Management
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
 * Then the vendingMachineTestCoin method is defined. This method defines the test cases as well as additional methods
 * see comments below for details of additional methods.
 */
@RunWith(JUnitParamsRunner.class)
public class vendingMachineTestCoin
{ 
	/*
	 * An instance of the vendingMachine class is created and named amount, this name was chosen because the
	 * method under test is coin. This instance is used to execute the test cases below.
	 */
	vendingMachine amount;
	
	/*
	 * This @Before statements indicates to Junit that this section of the code has to be executed
	 * before the tests can be executed. The method after the @Before statement creates a new instance 
	 * and allocates memory from the heap using the new operator.
	 */
	@Before
	public void setUp() throws Exception 
	{
		amount = new vendingMachine();
	}
	/*
	 * The @SuppressWarning("unused") is here to indicate to Junit that we are indeed trying to return an object from this
	 * method. If this statement is not used Junit will complain and the test suite will not execute. Within this method 
	 * vendingMachinCoin() an object will be returned and this object is a collection of the values that will be used to test the 
	 * coin method inside of the vendingMachine class. 
	 */
		@SuppressWarnings("unused")
	private static final Object[] vendingMachineCoin()
	{
		return $(	
				//Parameters are (1,2,3)
				//1 = input coin , 2 = input credit, 3 = expected result
				//test 1
				$(10,89,10),
				//test 2
				$(11,91,11), 
				//test 5
				$(9,91,9)   
				);
	}
	/*
	 * Here is where the test are executed the @Test and @Parameters indicate to Junit the test is to start execution here
	 * and where the parameters are going to be read from respectively.
	 * Initially JUnit will call the vendingMachineCoin method to gather the values for the test cases and then it will
	 * start executing the testCoin method below, reading in the values according to the parameter format in the header
	 * of the testCoin method below.
	 */
	@Test
	@Parameters(method ="vendingMachineCoin") 
	public void testCoin(int coin,int credit, int expected) 
	{
		/* 
		 * This if statement allows the test suite to test both branches of the second if statement inside the coin method under
		 * test. This is accomplished by first increasing the value of coin before the test is executed. 
		 */
		if(coin > 90)
		{
			amount.coin(coin);
		}
		/*
		 * The assertEqual below compares the expected result variable from the test cases with the actual result return from the 
		 * method under test. This is completed for each test case in the test suite.
		 */
		assertEquals(expected, amount.coin(coin));
	}
}
