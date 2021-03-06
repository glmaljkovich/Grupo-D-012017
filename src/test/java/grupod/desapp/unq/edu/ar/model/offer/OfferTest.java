package grupod.desapp.unq.edu.ar.model.offer;

import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by gabriel on 10/04/17.
 */
public class OfferTest {
    private Offer offer;
    private LocalDate start;
    private LocalDate end;

    @Before
    public void setUp() throws Exception {
        offer   = new ProductOffer();
        start   = LocalDate.of(2017, 3, 21);
        end     = start = LocalDate.of(2017, 4, 20);

    }

    @Test
    public void setStartDate() throws Exception {
        offer.setStartDate(start);

        assertEquals(start, offer.getStartDate());
    }

    @Test
    public void setEndDate() throws Exception {
        offer.setEndDate(end);

        assertEquals(end, offer.getEndDate());
    }

    @Test
    public void setDiscount() throws Exception {

        offer = new ProductOffer(start, end, 10, mock(Product.class));
        offer.setDiscount(20);

        assertEquals(Math.round(20), Math.round(offer.getDiscount()));
    }

}