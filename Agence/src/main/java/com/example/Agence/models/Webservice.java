package com.example.Agence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Webservice {
        @Id
        @GeneratedValue
        Long id;
        String uri;

        public Webservice(String uri){
            this.uri=uri;
        }

    public Webservice() {

    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
