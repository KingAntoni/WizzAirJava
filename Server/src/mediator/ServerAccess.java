package mediator;

public interface ServerAccess {
    void acquireRead();

    void acquireWrite();

    void releaseRead();

    void releaseWrite();
}
