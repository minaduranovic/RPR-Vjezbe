package ba.unsa.etf.rpr;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//
import org.mockito.Mockito;
public class ImenikTest {

public static Imenik imenik=new Imenik();

@BeforeAll
    public static void postavi() {
    imenik.dodaj("Mina", new FiksniBroj(Grad.SARAJEVO, "123-456"));
    imenik.dodaj("Ajna", new MobilniBroj(61, "222-333"));
    imenik.dodaj("Amar", new MedunarodniBroj("+41", "656787"));
    }


    @Test
    public void dajBroj(){
    String broj=imenik.dajBroj("Mina");
    assertEquals(broj, "033/123-456");
    }
    @Test
    public void nemaBroja(){
        String broj=imenik.dajBroj("Sara");
        assertNull(broj);
    }
    @Test
    public void testMock(){
        Imenik i=Mockito.mock(Imenik.class);
        Mockito.when(i.dajBroj("Mina")).thenReturn("nema");

        String test=i.dajBroj("Mina");
        assertEquals(test, "nema");
    }

//    @Test
//    public void dodajFiksniException(){
//    assertThrows(BrojException.class)
//    }
}
