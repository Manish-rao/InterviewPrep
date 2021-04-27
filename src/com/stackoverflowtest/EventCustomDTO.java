package com.stackoverflowtest;

public class EventCustomDTO {
    private Long id;
    private String eventName;
    private Boolean passport;
    private Boolean featured;
    private String status;

    public EventCustomDTO(Boolean passport, Boolean featured, String status) {
        this.passport = passport;
        this.featured = featured;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Boolean getPassport() {
        return passport;
    }

    public void setPassport(Boolean passport) {
        this.passport = passport;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "\npassport "+passport+", featured:" +featured+", status:"+status;
    }
}