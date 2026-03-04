package rvt.boxInterface;

public class CD implements Packable {
    String artist;
    String name;
    int publicationYear;
    double weight = 0.1;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString(){
        return this.artist + ":" + this.name + " (" + this.publicationYear + ")";
    }
    
}
