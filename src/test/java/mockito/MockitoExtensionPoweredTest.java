package mockito;

import mockito.support.Collaborator;
import mockito.support.UnderTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@InitMocks
class MockitoExtensionPoweredTest {

  UnderTest subject;
  @Mock
  Collaborator collaboratorMock;

  @BeforeEach
  void setup() {
    subject = new UnderTest(collaboratorMock);
  }

  @Test
  void verify_collaborator_invocation() {
    subject.execute();
    verify(collaboratorMock).process();
  }

  @Test
  void mockParameter_should_be_available(@Mock Collaborator collaboratorParam) {
    assertNotNull(collaboratorParam);
  }

}
