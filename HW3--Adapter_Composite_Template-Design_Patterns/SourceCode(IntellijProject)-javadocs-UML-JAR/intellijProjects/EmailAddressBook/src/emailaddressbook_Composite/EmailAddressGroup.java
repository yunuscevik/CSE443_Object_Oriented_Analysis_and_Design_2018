package emailaddressbook_Composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Yunus CEVIK
 */
public class EmailAddressGroup extends EmailAddressComponent {
    private Iterator<EmailAddressComponent> iterator = null;
    private ArrayList<EmailAddressComponent> emailAddressComponents = new ArrayList<EmailAddressComponent>();

    private String name;
    private String email;

    /**
     * Isim ve E-mail alan Constructor
     * @param name Isim
     * @param email E-mail
     */
    public EmailAddressGroup(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gruplari veya kisileri eklemeye yarayan metot.
     * @param emailAddressComponent EmailAddressGroup veya EmailAddressPerson tipinde parametre.
     */
    public void add(EmailAddressComponent emailAddressComponent) {
        emailAddressComponents.add(emailAddressComponent);
    }

    /**
     * Gruplari veya kisileri silmeye yarayan metot.
     * @param emailAddressComponent EmailAddressGroup veya EmailAddressPerson tipinde parametre.
     */
    public void remove(EmailAddressComponent emailAddressComponent) {
        emailAddressComponents.remove(emailAddressComponent);
    }

    /**
     * Group icerisindeki kisilerin index degerine gore eleman verir.
     * @param index Hangi indekste oldugunu belirten parametre.
     * @return Group icerisindeki kisilerin index degerine gore elemani return eder.
     */
    public EmailAddressComponent getChild(int index) {
        return emailAddressComponents.get(index);
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Iterator eger null ise yeni iterator olusturulur. Eger varsa var olan iterator verilir.
     * @return Olusturulan yada var olan iterator objesi return edilir.
     */
    public Iterator<EmailAddressComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(emailAddressComponents.iterator());
        }
        return iterator;
    }

    /**
     * Group isimleri ile birlikte grup içerisinde yer alan kisilerin ekran ciktisinin sunuldugu  metot.
     */
    public void print() {
        System.out.print("\n" + getName());
        System.out.println("  ( " + getEmail() + " )");
        System.out.println("------------------------------------------");

        Iterator<EmailAddressComponent> iterator = emailAddressComponents.iterator();
        while (iterator.hasNext()) {
            EmailAddressComponent emailAddressComponent = iterator.next();
            emailAddressComponent.print();
        }
    }


}