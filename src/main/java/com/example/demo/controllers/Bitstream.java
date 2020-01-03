package com.example.demo.controllers;

import java.util.BitSet;

public class Bitstream {
    private static final int LENGTH = 1000;
    private BitSet value;


    public Bitstream() {
        this.value = generateRandomSequence(LENGTH);
    }

    public Bitstream(BitSet value) {
        this.value = value;
    }

    public Bitstream(String value) {
        try{
            this.value = toBitSet(value);
        } catch (InvalidSizeException e) {
            e.printStackTrace();
            this.value = new BitSet(LENGTH);
        }
    }


    private BitSet toBitSet(String text) throws InvalidSizeException {
        if (text.length() * 8 > LENGTH) throw new InvalidSizeException("Input text is too long!");
        else {
            BitSet newBitSet = new BitSet(LENGTH);
            int bitSetIndex = 0;
            for (int i = 0; i < text.length(); i++) {
                int charVal = text.charAt(i);
                for (int j = 0; j < 8; j++) {
                    if (charVal % 2 == 1) {
                        newBitSet.set(bitSetIndex);
                    }
                    bitSetIndex++;
                    charVal =charVal/2;
                }
            }


            return newBitSet;
        }

    }

    private BitSet generateRandomSequence(int length) {
        BitSet sequence = new BitSet(length);
        for (int i = 0; i < length; i++) {
            double val;
            do {
                val = Math.random();
            } while (val == 0.5);
            if (val > 0.5) {
                sequence.set(i);
            }

        }
        return sequence;
    }

    public Bitstream xor(Bitstream bs) {
        BitSet seq1 = (BitSet) this.value.clone();
        BitSet seq2 = (BitSet) bs.getValue().clone();
        seq1.xor(seq2);

        return new Bitstream(seq1);
    }
    public Bitstream flip(){
        BitSet sequence = (BitSet) this.value.clone();
        sequence.flip(0, LENGTH);
        return new Bitstream(sequence);
    }

    public String convertToString(){
        String sequence = "";
        for(int i = 0; i< LENGTH /8; i++){
            int c = 0;
            for(int j =0;j<8;j++){
                if(this.value.get(i*8+j))
                    c+= (int) (Math.pow(2,j));
            }
            char val = (char) c;
            sequence = sequence + val;

        }
        return  sequence;
    }

    public BitSet getValue() {
        return value;
    }

    public void setValue(BitSet value) {
        this.value = value;
    }

    public static int getLength() {
        return LENGTH;
    }

    public class InvalidSizeException extends Exception {
        public InvalidSizeException(String message) {
            super(message);
        }
    }

    public static String decrypt(Bitstream b1, Bitstream b2, Bitstream b3, String message){


        Bitstream messageStream = new Bitstream(message);

        Bitstream b1Stream = messageStream.xor(b1.xor(b3));
        Bitstream b2Stream = (b1.xor(b2));
        Bitstream b3Stream = (b2.xor(b3));

        return b1Stream.xor(b2Stream.xor(b3Stream)).convertToString();
    }

}