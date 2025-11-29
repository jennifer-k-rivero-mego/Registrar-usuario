package utility;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setUp(){
        new BrowserDriver();
    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        BrowserDriver.close();
    }

}
