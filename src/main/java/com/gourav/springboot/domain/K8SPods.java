package com.gourav.springboot.domain;

public class K8SPods {
    String hostName, hostAddress;


    public K8SPods(String hostName, String hostAddress) {
        this.hostName = hostName;
        this.hostAddress = hostAddress;
    }

    public String getHostName() {
        return hostName;
    }



    public String getHostAddress() {
        return hostAddress;
    }



    @Override
    public String toString() {
        return "K8SPods{" +
                "hostName='" + hostName + '\'' +
                ", hostAddress='" + hostAddress + '\'' +
                '}';
    }
}
