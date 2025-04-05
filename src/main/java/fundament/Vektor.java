package fundament;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Vektor extends RealMatrix {
    
    /**
     * 
     * @param rowNumber
     * @return {@code double} in row-index rowNumber
     */
    public double getNumberAt(int rowNumber) {
        if (rowNumber < 0 || rowNumber >= size()) {
            throw new IllegalArgumentException();
        }
        return get(rowNumber).get(0);
    }
    
    public void setNumberAt(int rowNumber, double newNumber) {
        if (rowNumber < 0 || rowNumber >= size()) {
            throw new IllegalArgumentException();
        }
        get(rowNumber).set(0, newNumber);
    }
    
    /**
     * adds each element in vektor to this vektors elements
     * @param vektor
     */
    public void add(Vektor vektor) {
        if (size() != vektor.size()) {
            throw new IllegalArgumentException();
        }
        // for (int i = 0; i < size(); i++) {
            //     setNumberAt(i, getNumberAt(i) + vektor.getNumberAt(i));
            // }
            IntStream.range(0, size())
            .forEach(i -> setNumberAt(i, getNumberAt(i) + vektor.getNumberAt(i)));
        }
        
        /**
         * subtracts each element
         * @param vektor
         */
        
        public void subtract(Vektor vektor) {
            if (size() != vektor.size()) {
                throw new IllegalArgumentException();
            }
            IntStream.range(0, size())
            .forEach(i -> setNumberAt(i, getNumberAt(i) - vektor.getNumberAt(i)));
        }
        
        /**
         * 
         * @param scalar
         * scales each entry by scalar
         */
        public void scale(double scalar) {
            forEach(r -> {
                r.set(0, r.get(0)*scalar);
            });
        }
        
        /**
         * 
         * @return {@code int} dimension of vektor
         */
        public int dim() {
            return size();
        }
        
        @Override
        public Vektor copy() {
            Vektor vektor = new Vektor();
            vektor.addAll(this);
            return vektor;
        }
        
        /**
         * Constructs a vektor consisting of n {@code Rows} of one double
         * 
         * @param doubles
         */
        public Vektor(Double... doubles) {
            Stream.of(doubles).map(d -> new RealRow(d))
            .forEach(r -> add(r));
        }
    
        /**
         * Constructs a vektor from casting integers to doubles
         * @param integers to cast to doubles
         */
        public Vektor(Integer... integers) {
            Stream.of(integers).mapToDouble(i -> (int) i).boxed()
            .map(d -> new RealRow(d)).forEach(r -> add(r));
        }
        
        public Vektor(Vektor vektor) {
            vektor.copy();
        }
        
        public Vektor() {
        }
    }
    