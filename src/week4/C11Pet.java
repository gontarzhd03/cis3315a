package week4;

/**
 *
 * @author 55gontarhd03
 */
public abstract class C11Pet {
    private String petName;
    abstract public String speak();

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String toString() {
        return "C11Pet{" + "petName=" + petName + '}';
    }
}
