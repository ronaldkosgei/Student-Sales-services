package com.shippingmicroservice.mapper;

import com.shippingmicroservice.dto.ShippingDto;
import com.shippingmicroservice.entity.Shipping;

public class ShippingMapper {

    public static ShippingDto mapToShippingDto(Shipping shipping) {
        ShippingDto shippingDto = new ShippingDto();
        shippingDto.setTrackingNumber(shipping.getTrackingNumber());
        shippingDto.setShippingDate(shipping.getShippingDate());
        shippingDto.setOrigin(shipping.getOrigin());
        shippingDto.setWeight(shipping.getWeight());
        shippingDto.setShippingCost(shipping.getShippingCost());
        shippingDto.setShippingStatus(shipping.getShippingStatus());
        shippingDto.setCarrierInformation(shipping.getCarrierInformation());
        shippingDto.setShippingAddress(shipping.getShippingAddress());
        shippingDto.setReportId(shipping.getReportId());

        return shippingDto;
    }

    public static Shipping mapToShipping(ShippingDto shippingDto) {
        Shipping shipping = new Shipping();
        shipping.setTrackingNumber(shippingDto.getTrackingNumber());
        shipping.setShippingDate(shippingDto.getShippingDate());
        shipping.setOrigin(shippingDto.getOrigin());
        shipping.setWeight(shippingDto.getWeight());
        shipping.setShippingCost(shippingDto.getShippingCost());
        shipping.setShippingStatus(shippingDto.getShippingStatus());
        shipping.setCarrierInformation(shippingDto.getCarrierInformation());
        shipping.setShippingAddress(shippingDto.getShippingAddress());
        shipping.setReportId(shippingDto.getReportId());

        return shipping;
    }
}
