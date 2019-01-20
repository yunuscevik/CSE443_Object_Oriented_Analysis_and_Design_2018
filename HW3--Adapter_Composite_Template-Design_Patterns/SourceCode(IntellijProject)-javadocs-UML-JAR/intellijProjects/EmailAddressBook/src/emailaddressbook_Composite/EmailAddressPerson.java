package emailaddressbook_Composite;

import java.util.Iterator;

/**
 * EmailAddressComponent sinifindan extends edilen EmailAddressPerson sinifi.
 * @author Yunus CEVIK
 */
public class EmailAddressPerson extends EmailAddressComponent {
    private String name;
    private String email;
    private boolean group;
    /**
     * Isim ve E-mail alan Constructor
     * @param name Isim
     * @param email E-mail
     * @param group Kisi grupa kayitlimi degilmi
     */
    public EmailAddressPerson(String name, String email, boolean group) {
        this.name = name;
        this.email = email;
        this.group = group;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public boolean isGroup() {
        return group;
    }

    /**
     * createIterator ile NullIterator olusturulur.
     * @return NullIterator olusturulur ve return edilir.
     */
    public Iterator<EmailAddressComponent> createIterator() {
        return new NullIterator();
    }

    /**
     * Kisilerin ekran ciktilari.
     */
    public void print() {
        if(isGroup())
            System.out.print("(Group: ✔)\t");
        else
            System.out.print("\n(Group: ✖)\t");
        System.out.print("  " + getEmail());
        System.out.println("  -> " + getName());
    }
}