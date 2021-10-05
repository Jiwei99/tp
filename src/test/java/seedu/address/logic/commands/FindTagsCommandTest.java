package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.PersonTagsContainsTagsPredicate;
import seedu.address.model.tag.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.*;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindTagsCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        List<Tag> firstTagList = new ArrayList<>();
        firstTagList.add(new Tag("first"));
        List<Tag> secondTagList = new ArrayList<>();
        secondTagList.add(new Tag("second"));
        PersonTagsContainsTagsPredicate firstPredicate =
                new PersonTagsContainsTagsPredicate(firstTagList);
        PersonTagsContainsTagsPredicate secondPredicate =
                new PersonTagsContainsTagsPredicate(secondTagList);

        FindTagsCommand findFirstTagCommand = new FindTagsCommand(firstPredicate);
        FindTagsCommand findSecondTagCommand = new FindTagsCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstTagCommand.equals(findFirstTagCommand));

        // same values -> returns true
        FindTagsCommand findFirstTagCommandCopy = new FindTagsCommand(firstPredicate);
        assertTrue(findFirstTagCommand.equals(findFirstTagCommandCopy));

        // different types -> returns false
        assertFalse(findFirstTagCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstTagCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstTagCommand.equals(findSecondTagCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        PersonTagsContainsTagsPredicate predicate = preparePredicate("sdfiojoij");
        FindTagsCommand command = new FindTagsCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        PersonTagsContainsTagsPredicate predicate = preparePredicate("friends");
        FindTagsCommand command = new FindTagsCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, DANIEL), model.getFilteredPersonList());
    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private PersonTagsContainsTagsPredicate preparePredicate(String userInput) {
        String[] userArguments = userInput.split("\\s+");
        List<Tag> tagList = Arrays.stream(userArguments).map(Tag::new).collect(Collectors.toList());
        return new PersonTagsContainsTagsPredicate(tagList);
    }
}
