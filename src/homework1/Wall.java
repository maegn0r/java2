package homework1;

public class Wall implements Obstruction{
    @Override
    public void appears(Entity entity) {
        entity.jump(wallHeight);
    }
    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }
}
