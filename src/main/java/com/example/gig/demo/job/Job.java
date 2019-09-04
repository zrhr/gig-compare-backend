package com.example.gig.demo.job;




import lombok.Data;

        import javax.persistence.*;

@Entity
@Data
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String minPay;
    @Column
    private String maxPay;
    @Column
    private String referrals;
    @Column
    private String peakTimes;
    @Column
    private String logoUrl;
    @Column
    private String tips;
    @Column
    private String marketShare;
    @Column
    private String traded;
    @Column
    private String headquarters;
    @Column
    private String location;
    @Column
    private String name;
    @Column
    private String type;
    @Column (length=65536)
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWildcard() {
        return wildcard;
    }

    public void setWildcard(String wildcard) {
        this.wildcard = wildcard;
    }

    @Column
    private String wildcard;
    public Job() {
            }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMinPay() {
        return minPay;
    }

    public void setMinPay(String minPay) {
        this.minPay = minPay;
    }

    public String getMaxPay() {
        return maxPay;
    }

    public void setMaxPay(String maxPay) {
        this.maxPay = maxPay;
    }

    public String getReferrals() {
        return referrals;
    }

    public void setReferrals(String referrals) {
        this.referrals = referrals;
    }

    public String getPeakTimes() {
        return peakTimes;
    }

    public void setPeakTimes(String peakTimes) {
        this.peakTimes = peakTimes;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logo_url) {
        this.logoUrl = logoUrl;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(String marketShare) {
        this.marketShare = marketShare;
    }

    public String getTraded() {
        return traded;
    }

    public void setTraded(String traded) {
        this.traded = traded;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}