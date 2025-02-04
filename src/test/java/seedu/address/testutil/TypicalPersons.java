package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BIRTHDAY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BIRTHDAY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends")
            .withBirthday("05021999").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends")
            .withBirthday("16042000").build();
    public static final Person BENSON_NO_BIRTHDAY = PersonBuilder.ofNoBirthday().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends")
            .build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").withBirthday("25011997").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends", "owesMoney")
            .withBirthday("08091990").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave")
            .withBirthday("12101990").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo")
            .withBirthday("07111990").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street")
            .withBirthday("12041990").withTags("football").withPin(true).build();
    public static final Person HANNAH = new PersonBuilder().withName("Hannah Worst").withPhone("1234567")
            .withEmail("hhhhannah@example.com").withAddress("12th street")
            .withBirthday("31011990").withPin(true).build();
    public static final Person HANNAH_NO_BIRTHDAY = PersonBuilder.ofNoBirthday()
            .withName("Hannah No Birthday Worst").withPhone("12334567")
            .withEmail("hhhhannah@example.com").withAddress("12th street").build();
    public static final Person INDIGO = new PersonBuilder().withName("Indigo Color").withPhone("24422984")
            .withEmail("color@rainbow.com").withAddress("big tokyo")
            .withBirthday("11101995").withPin(true).build();
    public static final Person INDIGO_NO_BIRTHDAY = PersonBuilder.ofNoBirthday()
            .withName("Indigo No Birthday Color").withPhone("17263722")
            .withEmail("color@rainbow.com").withAddress("big tokyo").withPin(true).build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india")
            .withBirthday("01102003").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave")
            .withBirthday("17121998").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND)
            .withBirthday(VALID_BIRTHDAY_AMY).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withBirthday(VALID_BIRTHDAY_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    /**
     * Returns an {@code AddressBook} based on {@code getTypicalPersons()} but which has no tags.
     *
     * @return Model containing tag-free contacts
     */
    public static AddressBook getNoTagTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            person = new PersonBuilder(person).withTags().build();
            ab.addPerson(person);
        }
        return ab;
    }

    /**
     * Returns an {@code AddressBook} based on {@code getTypicalPersons()} but with the specified tags.
     *
     * @param tags tags to give every contact in the model
     * @return Model containing all contacts with the specified tags
     */
    public static AddressBook getTaggedTypicalAddressBook(String ... tags) {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            person = new PersonBuilder(person).withTags(tags).build();
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(
                ALICE,
                BENSON,
                CARL,
                DANIEL,
                ELLE,
                FIONA,
                GEORGE,
                HANNAH,
                HANNAH_NO_BIRTHDAY,
                INDIGO,
                INDIGO_NO_BIRTHDAY
        ));
    }
}
