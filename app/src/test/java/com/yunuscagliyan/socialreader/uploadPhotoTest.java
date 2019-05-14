package com.yunuscagliyan.socialreader;

import com.yunuscagliyan.socialreader.Utils.FirebaseMethods;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
public class uploadPhotoTest {

    @Test
    public void test() {

        FirebaseMethods firebaseMethods = mock(FirebaseMethods.class);
        firebaseMethods.uploadNewPhoto("test_photo","test",0,"null",null);
        verify(firebaseMethods).uploadNewPhoto("test_photo","test",0,"null",null);
    }
}
