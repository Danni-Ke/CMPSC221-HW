



public class AminoAcid {

    private String acidName;
    private String acidThreeLetter;
    private String acidSingleLetter;
    public AminoAcid() {}

    public AminoAcid(String acidName,String acidThreeLetter,String acidSingleLetter) {
        this.acidName = acidName;
        this.acidThreeLetter = acidThreeLetter;
        this.acidSingleLetter = acidSingleLetter;

    }




    public String getAcidName() {
        return acidName;
    }

    public String getAcidThreeLetter() {
        return acidThreeLetter;
    }

    public String getAcidSingleLetter() {
        return acidSingleLetter;
    }

    public void setAcidName(String acidName) {
        this.acidName = acidName;
    }

    public void setAcidThreeLetter(String acidThreeLetter) {
        this.acidThreeLetter = acidThreeLetter;
    }

    public void setAcidSingleLetter(String acidSingleLetter) {
        this.acidSingleLetter = acidSingleLetter;
    }
}
