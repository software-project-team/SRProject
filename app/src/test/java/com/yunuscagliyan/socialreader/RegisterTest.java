package com.yunuscagliyan.socialreader;
import com.yunuscagliyan.socialreader.Utils.FirebaseMethods;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RegisterTest {

    @Test
    public void test() {

        FirebaseMethods firebaseMethods = mock(FirebaseMethods.class);
       firebaseMethods.registerNewEmail("test","test","test");
       verify(firebaseMethods).registerNewEmail("test","test","test");
    }
}
