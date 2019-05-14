package com.yunuscagliyan.socialreader;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yunuscagliyan.socialreader.Login.LoginActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnit4.class)
@PrepareForTest({ FirebaseDatabase.class})

public class LoginTest {

        private DatabaseReference mockedDatabaseReference;

        @Test
        public void init() {
            when(mockedDatabaseReference.child(anyString())).thenReturn(mockedDatabaseReference);

            doAnswer(new Answer<Void>() {
                @Override
                public Void answer(InvocationOnMock invocation) throws Throwable {
                    ValueEventListener valueEventListener = (ValueEventListener) invocation.getArguments()[0];

                    DataSnapshot mockedDataSnapshot = Mockito.mock(DataSnapshot.class);

                    valueEventListener.onDataChange(mockedDataSnapshot);

                    return null;
                }
            }).when(mockedDatabaseReference).addListenerForSingleValueEvent
                    (any(ValueEventListener.class));

            new LoginActivity().init();
        }
    }


