package mockito.support;

public class UnderTest {

  private final Collaborator collaborator;

  public UnderTest(final Collaborator collaborator) {
    this.collaborator = collaborator;
  }

  public void execute() {
    collaborator.process();
  }
}
