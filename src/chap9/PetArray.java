package chap9;

/**
 * CRUD - create, retrieve, update & delete
 * @author Hank Gontarz
 */
public class PetArray {
    private Pet[] pets;
    private int n;

    public PetArray() {
        pets = new Pet[100];
        n = 0;
    }
    public void create(Pet pet) {
        this.pets[n] = pet;
        n++;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++) {
            sb.append(pets[i]).append("\n");
        }
        return sb.toString();
    }
}
