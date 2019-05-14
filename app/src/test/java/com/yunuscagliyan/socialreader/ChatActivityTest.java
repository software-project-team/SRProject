package com.yunuscagliyan.socialreader;

        import com.yunuscagliyan.socialreader.groups.chatActivity;
        import org.junit.Test;
        import static org.mockito.Mockito.mock;
        import static org.mockito.Mockito.verify;

public class ChatActivityTest {
    @Test
    public void test() {

        chatActivity chatActivity = mock(chatActivity.class);
        chatActivity.sendmessage("test_string");
        verify(chatActivity).sendmessage("test_string");
    }
}