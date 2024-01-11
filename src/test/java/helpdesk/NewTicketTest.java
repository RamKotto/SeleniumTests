package helpdesk;

import static ru.saraev.constants.helpdesk.HelpDeskConstants.COMMENT;
import static ru.saraev.constants.helpdesk.HelpDeskConstants.DESCRIPTION;
import static ru.saraev.constants.helpdesk.HelpDeskConstants.EMAIL;
import static ru.saraev.constants.helpdesk.HelpDeskConstants.SUMMARY;
import static ru.saraev.constants.tags.TestTags.NEW_FEATURE;
import static ru.saraev.constants.tags.TestTags.REGRESS;
import base_test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.saraev.pages.helpdesk.Homepage;
import ru.saraev.pages.helpdesk.TicketPage;
import ru.saraev.utils.StringUtils;

public class NewTicketTest extends BaseTest {

    @Test
    @Tags(value = {@Tag(REGRESS), @Tag(NEW_FEATURE)})
    public void createNewTicketTest() {
        TicketPage ticketPage = new Homepage()
            .setQueueFirstValue()
            .setSummary(StringUtils.getUniqueString(SUMMARY.getConstant()))
            .setDescription(DESCRIPTION.getConstant())
            .setEmail(EMAIL.getConstant())
            .clickSubmitButtonAndNavigateToTicketPage()
            .setComment(COMMENT.getConstant());

        Assertions.assertTrue(ticketPage.getTextFromSummary().contains(SUMMARY.getConstant()));
        Assertions.assertEquals(EMAIL.getConstant(), ticketPage.getTextFromEmailLabel());
        Assertions.assertTrue(ticketPage.isUpdateTicketButtonEnabled());
    }
}
