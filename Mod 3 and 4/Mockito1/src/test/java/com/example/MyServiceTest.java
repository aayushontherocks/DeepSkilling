package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MyServiceTest {

     @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVoidMethodInteraction() {
        Notifier mockNotifier = mock(Notifier.class);
        MyService service = new MyService(mockNotifier);

        service.doSomethingImportant();

        verify(mockNotifier).sendNotification("Important task done");
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Simulate different return values for each call
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");

        MyService service = new MyService(mockApi);

        // Call the method three times and assert each return
        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Third Call", service.fetchData());
    }

     @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        Notifier mockNotifier = mock(Notifier.class);
        Logger mockLogger = mock(Logger.class);

        // Set up service with mock dependencies
        MyService service = new MyService(mockApi);
        service.setNotifier(mockNotifier);
        service.setLogger(mockLogger); // assume setter for logger exists

        when(mockApi.getData()).thenReturn("Data");

        service.doImportantWorkflow();  // assume this triggers logger, api, notifier in order

        // Verify order
        InOrder inOrder = inOrder(mockLogger, mockApi, mockNotifier);

        inOrder.verify(mockLogger).log("Starting workflow");
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockNotifier).sendNotification("Workflow completed");
    }

    // Comment out or fix depending on method availability
//    @Test
//    public void testArgumentMatching() {
//        ExternalApi mockApi = mock(ExternalApi.class);
//        when(mockApi.getData(anyString())).thenReturn("Mocked");
//
//        MyService service = new MyService(mockApi);
//        String result = service.fetchData("abc123");
//
//        assertEquals("Mocked", result);
//        verify(mockApi).getData(anyString());
//        verify(mockApi).getData(eq("abc123"));
//    }
}
