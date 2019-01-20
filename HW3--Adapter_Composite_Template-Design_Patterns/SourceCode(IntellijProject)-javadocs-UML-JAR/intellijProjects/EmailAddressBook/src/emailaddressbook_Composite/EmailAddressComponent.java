package emailaddressbook_Composite;

import java.util.Iterator;

/**
 * Group ve Person icin belirtilmis abstract class.
 * @author Yunus CEVIK
 */
public abstract class EmailAddressComponent {

    public void add(EmailAddressComponent emailAddressComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(EmailAddressComponent emailAddressComponent) {
        throw new UnsupportedOperationException();
    }
    public EmailAddressComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getEmail() {
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<EmailAddressComponent> createIterator();

    public void print() {
        throw new UnsupportedOperationException();
    }

}