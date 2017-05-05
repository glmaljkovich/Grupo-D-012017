package grupod.desapp.unq.edu.ar.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gabriel on 10/04/17.
 */
public class AlertTest {
    private Alert alert;
    private String message;

    @Before
    public void setUp(){
        message = "Aflojá alcoholico, cómo vas a comprar 20 vinos en un solo dia?";
        alert   = new Alert(message);
    }

    @Test
    public void getMessage() throws Exception {
        assertEquals(message, alert.getMessage());
    }

    @Test
    public void getDefaultMessage() throws Exception {
        alert = new Alert();
        assertEquals("", alert.getMessage());
    }

    @Test
    public void setEnabled() throws Exception {
        alert.setEnabled(true);

        assertTrue(alert.isEnabled());
    }

}