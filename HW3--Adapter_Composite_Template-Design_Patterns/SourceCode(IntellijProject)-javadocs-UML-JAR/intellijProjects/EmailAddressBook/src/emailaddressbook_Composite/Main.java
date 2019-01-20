package emailaddressbook_Composite;

/**
 * Gruplara bagli olan kisilerin, ana bir grup icerisinde yer almasi sonucu ekrana ciktiyi saglayan main sinifidir.
 * @author Yunus CEVIK
 */
public class Main {
    public static void main(String args[]) {


        EmailAddressComponent allGroups = new EmailAddressGroup("ALL GROUPS", "allgroups@groups.com");

        EmailAddressComponent group1 =
                new EmailAddressGroup("FOOTBALL GROUP", "footballgroup@group.com");
        EmailAddressComponent group2 =
                new EmailAddressGroup("SINGER GROUP", "singergroup@group.com");
        EmailAddressComponent group3 =
                new EmailAddressGroup("IDLE GROUP", "idlegroup@group.com");

        //---------------------------------------------------------------------------------------------------------//
        allGroups.add(new EmailAddressPerson(
                "Fetin CÖMERT",
                "fetincomert@xyz.com",
                false));

        allGroups.add(group1);
        allGroups.add(group2);
        allGroups.add(group3);

        group1.add(new EmailAddressPerson(
                "Yunus ÇEVİK",
                "yunuscevik@football.com",
                true));
        group1.add(new EmailAddressPerson(
                "Alex De Souza",
                "alexdesouza@football.com",
                true));
        group1.add(new EmailAddressPerson(
                "Jerry Akaminko",
                "jerryakaminko@football.com",
                true));
        group1.add(new EmailAddressPerson(
                "Moussa Sow",
                "moussasow@football.com",
                true));

        group2.add(new EmailAddressPerson(
                "Hakkı Bulut",
                "hakkibulut@singer.com",
                true));
        group2.add(new EmailAddressPerson(
                "Kahtalı Mıçe",
                "kahtalimice@singer.com",
                true));
        group2.add(new EmailAddressPerson(
                "Tivorlu İsmail",
                "tivorluismail@singer.com",
                true));
        group2.add(new EmailAddressPerson(
                "Mahtmut Tuncer",
                "mahmuttuncer@singer.com",
                true));

        group3.add(new EmailAddressPerson(
                "Ajdar Anık",
                "ajdaranık@idle.com",
                true));
        group3.add(new EmailAddressPerson(
                "Hasan Ali Kaldırım",
                "hasanalikaldirim@idle.com",
                true));
        group3.add(new EmailAddressPerson(
                "Mehmet Ali Erbil",
                "memetalierbil@idle.com",
                true));
        group3.add(new EmailAddressPerson(
                "Yasiko Atto",
                "yasikoatto@idle.com",
                true));


        allGroups.add(new EmailAddressPerson(
                "Muhittin TUTUNAMAZ",
                "muhittintutunamaz@abc.com",
                false));

        AllEmailAddress allEmailAddress = new AllEmailAddress(allGroups);
        allEmailAddress.printGroups();
    }
}