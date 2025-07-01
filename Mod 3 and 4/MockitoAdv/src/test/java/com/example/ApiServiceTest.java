import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiServiceTest {
    @Test
    public void testServiceWithMockRestClient() {
        RestClient mockRestClient = mock(RestClient.class);  // Step 1
        when(mockRestClient.getResponse()).thenReturn("Mock Response");  // Step 2

        ApiService apiService = new ApiService(mockRestClient);  // Step 3
        String result = apiService.fetchData();  // Step 4

        assertEquals("Fetched Mock Response", result);  // verify output
    }
}
