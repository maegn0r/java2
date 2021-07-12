package homework1;

public class ThreadMill implements Obstruction{
    @Override
    public void appears(Entity entity) {
        entity.run(threadMillLength);
    }

    private int threadMillLength;

    public ThreadMill(int threadMillLength) {
        this.threadMillLength = threadMillLength;
    }
}
