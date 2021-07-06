package homework1;

public class TestClass {
    public static void main(String[] args) {
        Entity[] entities = {
                new Human(500,80),
                new Cat(400,80),
                new Robot(600, 50),
        };
        Obstruction[] obstructions = {
                new ThreadMill(500),
                new Wall(80),
        };
        runAndJump(entities,obstructions);
    }
    static void runAndJump (Entity[] entities, Obstruction[] obstructions){
        for (Entity entity : entities) {
            for (Obstruction obstruction : obstructions) {
                obstruction.appears(entity);
            }
        }
    }


}
