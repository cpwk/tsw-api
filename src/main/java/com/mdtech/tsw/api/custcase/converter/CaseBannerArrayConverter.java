package com.mdtech.tsw.api.custcase.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mdtech.tsw.api.custcase.entity.CaseBanner;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter(autoApply = true)
public class CaseBannerArrayConverter implements AttributeConverter<List<CaseBanner>, String> {

    @Override
    public String convertToDatabaseColumn(List<CaseBanner> list) {
        return JSON.toJSONString(list);
    }

    @Override
    public List<CaseBanner> convertToEntityAttribute(String data) {
        try {
            return JSONArray.parseArray(data, CaseBanner.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
