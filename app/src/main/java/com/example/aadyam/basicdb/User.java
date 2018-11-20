package com.example.aadyam.basicdb;

public class User {


    private String name;
    private  String address;
    private long contact;
    private  String email;

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return  name;
    }

    public void setAddress(String address)
    {
        this.address=address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setContact(long contact)
    {
        this.contact=contact;
    }

    public long getContact()
    {
        return contact;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getEmail()
    {
        return  email;
    }


}
