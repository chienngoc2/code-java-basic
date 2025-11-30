
package manager;


import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Feast implements Serializable {

    private String feastCode, feastName, feastIngredients;
    private int feastPrice;

    public Feast() {
    }

    public Feast(String feastCode, String feastName, int feastPrice, String feastIngredients) {
        this.feastCode = feastCode;
        this.feastName = feastName;
        this.feastPrice = feastPrice;
        this.feastIngredients = feastIngredients;
    }

    public Feast(String feastCode) {
        this.feastCode = feastCode;
    }

    @Override
    public boolean equals(Object obj) {
        Feast f = (Feast) obj;
        return this.feastCode.equals(f.feastCode);
    }

    public String getFeastCode() {
        return feastCode;
    }

    public void setFeastCode(String feastCode) {
        this.feastCode = feastCode;
    }

    public String getFeastName() {
        return feastName;
    }

    public void setFeastName(String feastName) {
        this.feastName = feastName;
    }

    public int getFeastPrice() {
        return feastPrice;
    }

    public void setFeastPrice(int feastPrice) {
        this.feastPrice = feastPrice;
    }

    public String getFeastIngredients() {
        return feastIngredients;
    }

    public void setFeastIngredients(String feastIngredients) {
        this.feastIngredients = feastIngredients;
    }

@Override
    public String toString() {
        String formatedIngredients = feastIngredients.replace("#", "\n");
        return String.format(
                "%-11s: %s\n%-11s: %s\n%-11s: %,d Vnd\n%-11s:\n%s",
                "Code", feastCode,
                "Name", feastName,
                "Price", feastPrice,
                "Ingredients", formatedIngredients);
    }
}


