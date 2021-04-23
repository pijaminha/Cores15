import java.util.Comparator;

public class ComparadorCorPorCodigo implements Comparator<Cor> {

    @Override
    public int compare(Cor c1, Cor c2) {
        return Integer.compare(c1.getCodigo(), c2.getCodigo());
    }
    
}
