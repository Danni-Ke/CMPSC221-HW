//how to generate three in one? Ask email
// can it be any easy way?
//how can I make users only choose one of them?
import java.util.HashMap;

public class DNADictionary {
    private HashMap<String, AminoAcid> codonMap;

    public DNADictionary() {
        this.codonMap = new HashMap<>();
        AminoAcid aa1 = new AminoAcid("Phenylalanine", "Phe", "F");
        this.codonMap.put("TTT", aa1);
        this.codonMap.put("TTC", aa1);
        AminoAcid aa2 = new AminoAcid("Leucine", "leu", "L");
        this.codonMap.put("TTA", aa2);
        this.codonMap.put("TTG", aa2);
        this.codonMap.put("CTT", aa2);
        this.codonMap.put("CTC", aa2);
        this.codonMap.put("CTA", aa2);
        this.codonMap.put("CTG", aa2);
        AminoAcid aa3 = new AminoAcid("Isoleucine", "IIe", "I");
        this.codonMap.put("ATT", aa3);
        this.codonMap.put("ATC", aa3);
        this.codonMap.put("ATA", aa3);
        AminoAcid aa4 = new AminoAcid("Methionine", "Met", "M");
        this.codonMap.put("ATG", aa4);
        AminoAcid aa5 = new AminoAcid("Valine", "Val", "V");
        this.codonMap.put("GTT", aa5);
        this.codonMap.put("GTC", aa5);
        this.codonMap.put("GTA", aa5);
        this.codonMap.put("GTG", aa5);
        AminoAcid aa6 = new AminoAcid("Serine", "Ser", "S");
        this.codonMap.put("TCT", aa6);
        this.codonMap.put("TCC", aa6);
        this.codonMap.put("TCA", aa6);
        this.codonMap.put("TCG", aa6);
        this.codonMap.put("AGT", aa6);
        this.codonMap.put("AGC", aa6);
        AminoAcid aa7 = new AminoAcid("Proline", "Pro", "P");
        this.codonMap.put("CCT", aa7);
        this.codonMap.put("CCC", aa7);
        this.codonMap.put("CCA", aa7);
        this.codonMap.put("CCG", aa7);
        AminoAcid aa8 = new AminoAcid("Threonine", "Thr", "T");
        this.codonMap.put("ACT", aa8);
        this.codonMap.put("ACC", aa8);
        this.codonMap.put("ACA", aa8);
        this.codonMap.put("ACG", aa8);
        AminoAcid aa9 = new AminoAcid("Alanine", "Ala", "A");
        this.codonMap.put("GCT", aa9);
        this.codonMap.put("GCC", aa9);
        this.codonMap.put("GCA", aa9);
        this.codonMap.put("GCG", aa9);
        AminoAcid aa10 = new AminoAcid("Tyrosine", "Tyr", "Y");
        this.codonMap.put("TAT", aa10);
        this.codonMap.put("TAC", aa10);
        AminoAcid aa11 = new AminoAcid("Ochre", "Stop", "Stop");
        this.codonMap.put("TAA", aa11);
        AminoAcid aa12 = new AminoAcid("Amber", "Stop", "Stop");
        this.codonMap.put("TAG", aa12);
        AminoAcid aa13 = new AminoAcid("Histidine", "His", "H");
        this.codonMap.put("CAT", aa13);
        this.codonMap.put("CAC", aa13);
        AminoAcid aa14 = new AminoAcid("Glutamine", "Gln", "Q");
        this.codonMap.put("CAA", aa14);
        this.codonMap.put("CAG", aa14);
        AminoAcid aa15 = new AminoAcid("Asparagine", "Asn", "N");
        this.codonMap.put("AAT", aa15);
        this.codonMap.put("AAC", aa15);
        AminoAcid aa16 = new AminoAcid("Lysine", "Lys", "K");
        this.codonMap.put("AAA", aa16);
        this.codonMap.put("AAG", aa16);
        AminoAcid aa17 = new AminoAcid("Aspartic acid", "Asp", "D");
        this.codonMap.put("GAT", aa17);
        this.codonMap.put("GAC", aa17);
        AminoAcid aa18 = new AminoAcid("Glutamic acid", "Glu", "E");
        this.codonMap.put("GAA", aa18);
        this.codonMap.put("GAG", aa18);
        AminoAcid aa19 = new AminoAcid("Cysteine", "Cys", "C");
        this.codonMap.put("TGT", aa19);
        this.codonMap.put("TGC", aa19);
        AminoAcid aa20 = new AminoAcid("Opal", "stop", "stop");
        this.codonMap.put("TGA", aa20);
        AminoAcid aa21 = new AminoAcid("Tryptophan", "Trp", "W");
        this.codonMap.put("TGG", aa21);
        AminoAcid aa22 = new AminoAcid("Arginine", "Arg", "R");
        this.codonMap.put("CGT", aa22);
        this.codonMap.put("CGC", aa22);
        this.codonMap.put("CGA", aa22);
        this.codonMap.put("CGG", aa22);
        this.codonMap.put("AGA", aa22);
        this.codonMap.put("AGG", aa22);
        AminoAcid aa23 = new AminoAcid("Glycine", "Gly", "G");
        this.codonMap.put("GGT", aa23);
        this.codonMap.put("GGC", aa23);
        this.codonMap.put("GGA", aa23);
        this.codonMap.put("GGG", aa23);


    }

    //codon= TTT
    public AminoAcid getAcidByCodon(String codon) {
        return this.codonMap.get(codon);
    }

    public String getAcidThreeLetter(String codon) {
        String threeLetter = " ";
        AminoAcid a = new AminoAcid();
        if(codon.contains("X")||codon.contains("N"))
            threeLetter=codon;
        else {
            a = codonMap.get(codon);
            threeLetter = a.getAcidThreeLetter();
        }
        return threeLetter;
    }
}
