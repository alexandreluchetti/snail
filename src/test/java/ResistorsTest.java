import br.com.lucchetta.Resistors;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ResistorsTest {

    @Test
    public void resistorsTest() {
        Resistors resistors = new Resistors(new Scanner(System.in));

        String test1 = resistors.execute("10 ohms");
        String test2 = resistors.execute("100 ohms");
        String test3 = resistors.execute("220 ohms");
        String test4 = resistors.execute("330 ohms");
        String test5 = resistors.execute("470 ohms");
        String test6 = resistors.execute("680 ohms");
        String test7 = resistors.execute("1k ohms");
        String test8 = resistors.execute("2M ohms");

        System.out.println("10 ohms: " + test1.equals("Resultado => marrom preto preto dourado"));
        System.out.println("100 ohms: " + test2.equals("Resultado => marrom preto marrom dourado"));
        System.out.println("220 ohms: " + test3.equals("Resultado => vermelho vermelho marrom dourado"));
        System.out.println("330 ohms: " + test4.equals("Resultado => laranja laranja marrom dourado"));
        System.out.println("470 ohms: " + test5.equals("Resultado => amarelo violeta marrom dourado"));
        System.out.println("680 ohms: " + test6.equals("Resultado => azul cinza marrom dourado"));
        System.out.println("1k ohms: " + test7.equals("Resultado => marrom preto vermelho dourado"));
        System.out.println("2M ohms: " + test8.equals("Resultado => vermelho preto verde dourado"));
    }

}
