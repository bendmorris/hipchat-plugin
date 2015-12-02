package jenkins.plugins.hipchat.model;

import static org.assertj.core.api.Assertions.*;

import hudson.model.AbstractBuild;
import jenkins.model.Jenkins;
import jenkins.plugins.hipchat.Messages;
import jenkins.plugins.hipchat.utils.BuildUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationTypeTest {

    @Mock
    Jenkins jenkins;
    @Mock
    BuildUtils buildUtils;
    @Mock
    AbstractBuild<?, ?> build;

    @Test
    public void testGetMessage() throws Exception {
        assertNotificationMessage(NotificationType.ABORTED, Messages.Aborted());
        assertNotificationMessage(NotificationType.BACK_TO_NORMAL, Messages.BackToNormal());
        assertNotificationMessage(NotificationType.FAILURE, Messages.Failure());
        assertNotificationMessage(NotificationType.NOT_BUILT, Messages.NotBuilt());
        assertNotificationMessage(NotificationType.STARTED, Messages.Started());
        assertNotificationMessage(NotificationType.SUCCESS, Messages.Success());
        assertNotificationMessage(NotificationType.UNSTABLE, Messages.Unstable());
        assertNotificationMessage(NotificationType.BROKEN, Messages.Broken());
    }

    private void assertNotificationMessage(NotificationType type, String message) {
        assertThat(type.getMessage(buildUtils, jenkins, build, "Hello World $STATUS"))
                .contains("Hello World " + message);
    }
}
