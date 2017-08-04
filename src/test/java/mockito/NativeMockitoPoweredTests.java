package mockito;

import mockito.support.Collaborator;
import mockito.support.UnderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class NativeMockitoPoweredTests {

  UnderTest subject;
  @Mock
  Collaborator collaboratorMock;

  @BeforeEach
  void setup() {
    MockitoAnnotations.initMocks(this);
    subject = new UnderTest(collaboratorMock);
  }

  @Test
  void verify_collaborator_invocation() {
    subject.execute();
    verify(collaboratorMock).process();
  }

}
