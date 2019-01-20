package emailaddressbook_Composite;

/**
 * Tum gruplarin ekrana yazdirilmasi icin icerisinde abstract sinifin tipinde member bulundurulan sinif.
 * @author Yunus CEVIK
 */
public class AllEmailAddress {
    private EmailAddressComponent allEmailAddress;

    /**
     * Tum gruplarin objesini alan Constructor
     * @param allEmailAddress Tum gruplarin paramatresi
     */
    public AllEmailAddress(EmailAddressComponent allEmailAddress) {
        this.allEmailAddress = allEmailAddress;
    }

    /**
     * Tum gruplar ekrana yazdirilir.
     */
    public void printGroups() {
        allEmailAddress.print();
    }
}