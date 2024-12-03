package lab1.manip3;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

public class NumPair implements Writable {

    private int sum;
    private int count;

    // Constructeur par défaut
    public NumPair() {
        this.sum = 0;
        this.count = 0;
    }

    // Constructeur avec initialisation
    public NumPair(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }

    // Getters
    public int getSum() {
        return sum;
    }

    public int getCount() {
        return count;
    }

    // Méthode pour ajouter une nouvelle valeur
    public void add(int value) {
        this.sum += value;
        this.count++;
    }

    // Méthode pour calculer la moyenne
    public double getAverage() {
        return count == 0 ? 0 : (double) sum / count;
    }

    // Méthodes pour la sérialisation
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(sum);
        out.writeInt(count);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        sum = in.readInt();
        count = in.readInt();
    }

    // Affichage sous forme de chaîne
    @Override
    public String toString() {
        return "Sum: " + sum + ", Count: " + count;
    }
}
