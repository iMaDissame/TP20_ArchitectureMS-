package com.microservice.servicevoiture.models;

import com.microservice.servicevoiture.entities.Client;

public class CarResponse {
    private Long id;
    private String brand;
    private String model;
    private String matricule;
    private Client client;

    public CarResponse() {
    }

    public CarResponse(Long id, String brand, String model, String matricule, Client client) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.matricule = matricule;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getMatricule() {
        return matricule;
    }

    public Client getClient() {
        return client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String brand;
        private String model;
        private String matricule;
        private Client client;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder matricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public CarResponse build() {
            return new CarResponse(id, brand, model, matricule, client);
        }
    }

    // equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResponse that = (CarResponse) o;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(brand, that.brand) &&
                java.util.Objects.equals(model, that.model) &&
                java.util.Objects.equals(matricule, that.matricule) &&
                java.util.Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, brand, model, matricule, client);
    }

    @Override
    public String toString() {
        return "CarResponse{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", matricule='" + matricule + '\'' +
                ", client=" + client +
                '}';
    }
}