package emailaddressbook_Composite;

import java.util.Iterator;

/**
 * NullIterator ile next degerinin null, hasNext degerinin false oldugu belirlenir. Bu sinif ile null kontrolleri yapilir.
 * @author Yunus CEVIK
 */
public class NullIterator implements Iterator<EmailAddressComponent> {

    @Override
    public EmailAddressComponent next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}