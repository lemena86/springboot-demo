package cl.home.store.demo.service.dto;

import cl.home.store.demo.domain.Seller;

import java.util.Objects;

public class SellerDto {

    private String name;

    private String address;

    public SellerDto() {
    }

    public SellerDto(Seller seller) {
        this.name = seller.getName();
        this.address = seller.getAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerDto sellerDto = (SellerDto) o;
        return Objects.equals(name, sellerDto.name) &&
                Objects.equals(address, sellerDto.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "SellerDto{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
