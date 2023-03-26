package land;

public class Land {
    private Integer LandSizeInHa = 0;
    private Integer freeLand = 0;
    private Integer sownLandInHa = 0;
    private Double buyPriceOfLandPerHa = 140.00;
    private Double sellPriceOfLandPerHa = 122.00;

    public Integer getLandSizeInHa() {
        return LandSizeInHa;
    }

    public void setLandSizeInHa(Integer landSizeInHa) {
        this.LandSizeInHa = landSizeInHa;
    }

    public Integer getFreeLand() {
        return freeLand;
    }

    public void setFreeLand(Integer freeLand) {
        this.freeLand = freeLand;
    }

    public Integer getSownLandInHa() {
        return sownLandInHa;
    }

    public void setSownLandInHa(Integer sownLandInHa) {
        this.sownLandInHa = sownLandInHa;
    }

    public Double getBuyPriceOfLandPerHa() {
        return buyPriceOfLandPerHa;
    }

    public void setBuyPriceOfLandPerHa(Double buyPriceOfLandPerHa) {
        this.buyPriceOfLandPerHa = buyPriceOfLandPerHa;
    }

    public Double getSellPriceOfLandPerHa() {
        return sellPriceOfLandPerHa;
    }

    public void setSellPriceOfLandPerHa(Double sellPriceOfLandPerHa) {
        this.sellPriceOfLandPerHa = sellPriceOfLandPerHa;
    }
}
