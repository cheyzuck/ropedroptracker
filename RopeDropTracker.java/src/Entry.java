public class Entry {
    private String temp;
    private String humidity;
    private String harnessID;
    private String harnessCount;
    private String QRCount;
    private String SRCount;
    private String carabinerCount;
    private String indyName;
    private String indyWeight;
    private String dropDistance;
    private String techName;

    public Entry(){
    }

    public Entry(String newTemp, String newHumidity, String newHarnessID, String newHarnessCount, String newQRCount, String newSRCount, String newCarabinerCount, String newIndyName, String newIndyWeight, String newDropDistance, String newTech){
        String temp = newTemp;
        String humidity = newHumidity;
        String harnessID = newHarnessID;
        String harnessCount = newHarnessCount;
        String QRCount = newQRCount;
        String SRCount = newSRCount;
        String carabinerCount = newCarabinerCount;
        String indyName = newIndyName;
        String indyWeight = newIndyWeight;
        String dropDistance = newDropDistance;
        String techName = newTech;
    }

    public void setTemp(String temp){
        this.temp = temp;
    }

    public void setHumidity(String humidity){
        this.humidity = humidity;
    }

    public void setHarnessID(String harnessID){
        this.harnessID = harnessID;
    }

    public void setHarnessCount(String harnessCount){
        this.harnessCount = harnessCount;
    }

    public void setQRCount(String QRCount){
        this.QRCount = QRCount;
    }

    public void setSRCount(String SRCount){
        this.SRCount = SRCount;
    }

    public void setCarabinerCount(String carabinerCount){
        this.carabinerCount = carabinerCount;
    }

    public void setIndyName(String indyName){
        this.indyName = indyName;
    }

    public void setIndyWeight(String indyWeight){
        this.indyWeight = indyWeight;
    }

    public void setDropDistance(String dropDistance){
        this.dropDistance = dropDistance;
    }

    public void setTechName(String techName){
        this.techName = techName;
    }

    public String getTemp(){
        return temp;
    }

    public String getHumidity(){
        return humidity;
    }

    public String getHarnessID(){
        return harnessID;
    }

    public String getHarnessCount(){
        return harnessCount;
    }

    public String getQRCount(){
        return QRCount;
    }

    public String getSRCount(){
        return SRCount;
    }

    public String getCarabinerCount(){
        return carabinerCount;
    }

    public String getIndyName(){
        return indyName;
    }

    public String getIndyWeight(){
        return indyWeight;
    }

    public String getDropDistance(){
        return dropDistance;
    }

    public String getTechName(){
        return techName;
    }
}
