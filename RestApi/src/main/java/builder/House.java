package builder;

public class House {
    private String walls;
    private String roof;
    private String door;

    // Setter methods
    private void setWalls(String walls) {
        this.walls = walls;
    }

    private void setRoof(String roof) {
        this.roof = roof;
    }

    private void setDoor(String door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "House [walls=" + walls + ", roof=" + roof + ", door=" + door + "]";
    }

    // Builder as an Inner Class
    public class HouseBuilder {
        private House house;

        public HouseBuilder() {
            this.house = new House();
        }

        public HouseBuilder buildWalls(String walls) {
            house.setWalls(walls);
            return this;
        }

        public HouseBuilder buildRoof(String roof) {
            house.setRoof(roof);
            return this;
        }

        public HouseBuilder buildDoor(String door) {
            house.setDoor(door);
            return this;
        }

        public House build() {
            return house;
        }
    }


}
