package homework1;

public class Human implements Entity {

    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean isAlive = true;

    public Human(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void run(int size) {
        if (!isAlive) return;
        if (size <= maxRunDistance) {
            System.out.printf("Человек пробежал %s метров по беговой дорожке.%n", size);
        } else {
            System.out.printf("Человек пытался пробежать %s метров по беговой дорожке, но не смог.%n", size);
            isAlive = false;
        }
    }

    @Override
    public void jump(int height) {
        if (!isAlive) return;
        if (height <= maxJumpHeight) {
            System.out.printf("Человек перепрыгнул стену высотой %s метров.%n", height);
        } else {
            System.out.printf("Человек пытался перепрыгнуть стену высотой %s метров, но не смог.%n", height);
            isAlive = false;
        }
    }
}
