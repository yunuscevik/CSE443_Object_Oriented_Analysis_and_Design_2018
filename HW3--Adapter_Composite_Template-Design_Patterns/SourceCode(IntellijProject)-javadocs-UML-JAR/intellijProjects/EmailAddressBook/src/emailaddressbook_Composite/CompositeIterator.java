package emailaddressbook_Composite;

import java.util.Iterator;
import java.util.Stack;

/**
 * CompositeIterator stack icerisine alinan verilerin daha sonra hasNext ile kontrolune next ile bir sonraki veriyi cekmemize yarar.
 * @author Yunus CEVIK
 */
public class CompositeIterator implements Iterator<EmailAddressComponent> {
    Stack<Iterator<EmailAddressComponent>> stack = new Stack<>();

    /**
     * Constructor
     * @param iterator Iterator tipinde parametre alir.
     */
    public CompositeIterator(Iterator<EmailAddressComponent> iterator) {
        stack.push(iterator);
    }

    /**
     * Stack icerisindeki bir sonraki elemana bakar ve stack icerisine tekrardan ekler.
     * @return Eger eleman varsa bir sonraki elemani return eder yoksa null return eder.
     */
    @Override
    public EmailAddressComponent next() {
        if (hasNext()) {
            Iterator<EmailAddressComponent> iterator = stack.peek();
            EmailAddressComponent component = iterator.next();
            stack.push(component.createIterator());
            return component;
        } else
            return null;
    }

    /**
     * Stack icerisi bos mu diye bakilir. Eger iterator elemani buldu ise stackten cekilir iteratore verilir.
     * @return Stack icerisi bos mu diye bakar ve true yada false return eder.
     */
    @Override
    public boolean hasNext() {
        if (stack.empty())
            return false;
        else {
            Iterator<EmailAddressComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else
                return true;
        }
    }
}
