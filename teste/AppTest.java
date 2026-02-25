import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {


    @Test
    public void deveFiltrarApenasPessoasDoGeneroFeminino() {
        List<Pessoa> lista = new ArrayList<>();

        Pessoa p1 = new Pessoa();
        p1.setNome("Maria");
        p1.setGenero("Feminino");

        Pessoa p2 = new Pessoa();
        p2.setNome("João");
        p2.setGenero("Masculino");

        Pessoa p3 = new Pessoa();
        p3.setNome("Ana");
        p3.setGenero("feminino");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        List<Pessoa> listaFiltrada = App.filtrarFeminino(lista);

        Assertions.assertEquals(2, listaFiltrada.size());

        Assertions.assertTrue(listaFiltrada.stream().allMatch(p -> p.getGenero().equalsIgnoreCase("Feminino")));

        Assertions.assertFalse(listaFiltrada.stream().anyMatch(p -> p.getNome().equals("João")));
    }
}
