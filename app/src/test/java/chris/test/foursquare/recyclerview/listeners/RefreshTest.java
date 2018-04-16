package chris.test.foursquare.recyclerview.listeners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RefreshTest {
    @Mock
    private RefreshAction mockRefreshAction;
    @InjectMocks
    private Refresh sut;

    @Test
    public void whenOnRefreshThenCallRefreshActionRefresh() {
        doNothing().when(mockRefreshAction).refresh();

        sut.onRefresh();

        verify(mockRefreshAction).refresh();
    }
}
